package io.renren.modules.bookmanager.service.impl;

import io.renren.modules.bookmanager.dao.*;
import io.renren.modules.bookmanager.entity.BookAddressEntity;
import io.renren.modules.bookmanager.entity.BookrackInfoEntity;
import io.renren.modules.bookmanager.entity.CategoryEntity;
import io.renren.modules.bookmanager.service.CorrelationService;
import io.renren.modules.bookmanager.utils.ImageUtil;
import io.renren.modules.sys.dao.SysUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.keyvalue.core.IdentifierGenerator;
import org.springframework.data.util.TypeInformation;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.bookmanager.entity.BookInfoEntity;
import io.renren.modules.bookmanager.service.BookInfoService;
import org.springframework.util.IdGenerator;
import org.springframework.web.multipart.MultipartFile;


@Service("bookInfoService")
public class BookInfoServiceImpl extends ServiceImpl<BookInfoDao, BookInfoEntity> implements BookInfoService {

    @Autowired
    private BookInfoDao bookInfoDao;
    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private BookrackInfoDao bookrackInfoDao;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private BookAddressDao bookAddressDao;
    @Autowired
    private CorrelationDao correlationDao;
    @Autowired
    private CorrelationService correlationService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BookInfoEntity> page = this.page(
                new Query<BookInfoEntity>().getPage(params),
                new QueryWrapper<BookInfoEntity>()
        );
//        在这里对page中的数据进行处理，根据cookie中的账号信息判断对应的信息
        return new PageUtils(page);
    }

    @Override
    public Map<String, Object> getBookNameById(Long bookId) {
        return bookInfoDao.getBookNameById(bookId);
    }

    @Override
    public List<Map<String, Object>> getBooksList() {
        return bookInfoDao.getBookList();
    }

    @Override
    public Map<String, Object> getBookInfo(String isbnCode) {
        return bookInfoDao.getBookInfo(isbnCode);
    }

    @Override
    public List<Map<String, Object>> selectBookList(Map<String, Object> map) {
//        使用ES搜索
//        根据前端床过来的参数进行对于书籍的相关信息的查询
        String con = "%"+ (String) map.get("con") +"%";
        Long userId = Long.valueOf((Integer)map.get("userId"));
        List<Map<String,Object>> list = bookInfoDao.selectBookListByCon(con);
//        首先判断获取到的list是否为空
        if (list.size() == 0){
            return null;
        }
//        调用计算每个用户与每个类别的相关性的大小
//        遍历list中的所有元素并获取其中的category
        for (Map<String,Object> bookMap:list){
            Long categoryCode = (Long)bookMap.get("category_code");
            correlationService.insertCorrelation(categoryCode,userId);
        }
        return bookInfoDao.selectBookList(con);
    }

    @Override
    public int insertBookInfo(Map<String, Object> map) throws ParseException {
//        创建图书信息实体类
        BookInfoEntity bookInfoEntity = new BookInfoEntity();
        bookInfoEntity.setInsertTime(new Date());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        获取bookInfo的信息
        Map<String,Object> bookInfo = (Map<String, Object>) map.get("bookInfo");
//        根据userId获取对应的用户名
        Map <String,Object> map1 = sysUserDao.getUserNameById(Long.valueOf((Integer)map.get("userId")));
        bookInfoEntity.setBookCode((String) bookInfo.get("ISBN"));
        bookInfoEntity.setInsertName((String) map1.get("userName"));
        bookInfoEntity.setDeleted((long) 0);
        bookInfoEntity.setPressTime(format.parse((String)bookInfo.get("press_time")));
        bookInfoEntity.setAuthor((String) bookInfo.get("author"));
        bookInfoEntity.setBookName((String) bookInfo.get("book_name"));
        bookInfoEntity.setBookPress((String)bookInfo.get("book_press"));
//        bookInfoEntity.setBookImageurl((String)bookInfo.get("image_url"));
//        bookInfoEntity.setBookTxtUrl((String)bookInfo.get("bookTxt_url"));
        bookInfoEntity.setPricing((String)bookInfo.get("pricing"));
//        判断当前分类信息在数据库是否存在，如果不存在则先将该分类信息进行注册
        Map<String,Object> categoryMap = categoryDao.getCategoryNameByCode((String)bookInfo.get("category"));
        if(categoryMap == null){
//            当分类信息为空的时候
//            创建分类实体类
            CategoryEntity categoryEntity = new CategoryEntity();
            categoryEntity.setDeleted((long) 0);
            categoryEntity.setInsertTime(new Date());
            categoryEntity.setInsertName("admin");
            categoryEntity.setCategoryName((String)bookInfo.get("category_name"));
            categoryEntity.setCategoryCode((String)bookInfo.get("category"));
            categoryDao.insert(categoryEntity);
        }
        categoryMap = categoryDao.getCategoryNameByCode((String)bookInfo.get("category"));
        bookInfoEntity.setCategoryCode((Long)categoryMap.get("categoryId"));
//        给图书自动分配存储地址
        bookInfoEntity.setLibraryId((Long)map1.get("libraryId"));
//        给图书自动分配地址
//        首先，根据分类的编码获取当前数据中与之匹配的书架，如果没有则依次递减，直到找到分类编码
        String categoryCode = (String)bookInfo.get("category");
        String [] nums = categoryCode.split("");
        for (int i=0;i<nums.length;i++){
            Map<String,Object> bookAddressMap = bookAddressDao.getBookAddressByCategoryId(nums[i]);
            if (bookAddressMap != null){
//                找到书架地址，将其存储到相应的书籍信息表中，并且结束循环
                bookInfoEntity.setAddressId((Long)bookAddressMap.get("addressId"));
//                成功之后，修改书架的数量
                BookAddressEntity bookAddressEntity = new BookAddressEntity();
                bookAddressEntity.setAddressId((Long)bookAddressMap.get("addressId"));
                bookAddressEntity.setStatus(0);
                bookAddressDao.updateById(bookAddressEntity);
                break;
            }
        }
        return bookInfoDao.insert(bookInfoEntity);
    }

    @Override
    public Map<String, Object> updateImage(MultipartFile multipartFile) {
//        使用id自动生成器
        Map<String,Object> map = new HashMap<>();
        //获取后缀
        String suffixName = ImageUtil.getImagePath(multipartFile);
        //获取新的文件名
        String newFileName = ImageUtil.getNewFileName(suffixName);
        //保存图片
        File file = new File(ImageUtil.getNewImagePath(newFileName));
        boolean state = ImageUtil.saveImage(multipartFile, file);
        if(state) {
            //图片保存成功
            map.put("success",true);
            map.put("msg","图书上传成功");
            map.put("imageUrl",newFileName);
        }else {
            map.put("success", false);
            map.put("msg", "图片上传失败");
        }
        return map;
    }

    @Override
    public Map<String, List<Map<String,Object>>> getSectionalizerList(Map<String, Object> map) {
//        创建返回数据
//        第一步。根据userId获取每个人不同的相关性推荐强度
        List<Map<String,Object>> correlationList = correlationDao.getCorrelationByUserId(Long.valueOf((Integer)map.get("userId")));
//        遍历相关性强度数据，从而获取相关书籍
//        创建推荐书籍List集合],推荐书籍只要十本
        List<Map<String,Object>> bookRecommendList = new ArrayList<>();
        Map<String,List<Map<String,Object>>> newMap = new HashMap<>();
        Map<String,Object> map1 = new HashMap<>();
        map1.put("userId",Long.valueOf((Integer)map.get("userId")));
        int j = 10;
        if(j > correlationList.size()){
            j = correlationList.size();
        }
        for (int i = 0; i < j; i++) {
            map1.put("categoryCode",correlationList.get(i).get("categoryCode"));
            List<Map<String,Object>> bookList= bookInfoDao.getBookByCategoryCodeByUserId(map1);
//            遍历bookList
            for (Map<String, Object> stringObjectMap : bookList) {
                stringObjectMap.put("bookImageUrl","/static/bookimage/"+stringObjectMap.get("bookImageUrl"));
                bookRecommendList.add(stringObjectMap);
            }
        }
        newMap.put("推荐",bookRecommendList);
//         第二步，获取每个分类下的书籍
//        根据分类编码获取所有为主类的编码，即只有一个大写的英文字母
        List<Map<String,Object>> categoryList = categoryDao.getCategoryNameList();
//        遍历分类list,通过分类编码获取书籍信息
        for (Map<String, Object> stringObjectMap : categoryList) {
//            判断当前分类编码是否是主类，如果不是则跳过
            if(stringObjectMap.get("categoryCode").toString().length()==1){
//                调用接口，根据主类的分类编码获取该分类编码下的所有图书,并且该图书还要不属于书架中的
                map1.put("categoryCode",stringObjectMap.get("categoryCode")+"%");
                List<Map<String,Object>> bookList = bookInfoDao.getBookListByCategory(map1);
//                当当前书籍列表下没有书籍的时候直接跳过
                if(bookList.size() != 0){
                    for (Map<String, Object> objectMap : bookList) {
                        objectMap.put("bookImageUrl","/static/bookimage/"+objectMap.get("bookImageUrl"));
                    }
                    newMap.put((String) stringObjectMap.get("categoryName"),bookList);
                }

            }
        }
        return newMap;
    }

    @Override
    public Map<String, Object> getBookById(Map<String, Object> map) {
//        第一步，获取书籍的相关信息
        Map<String,Object> newMap = bookInfoDao.getBookById(Long.valueOf((String) map.get("bookId")));
//        第二步，根据用户Id和书籍Id判断该书籍是否以及加入该用户的书架
        Integer statue = bookInfoDao.getBookIsUserById(map);
        if(statue == 1){
//            则证明该书籍加入到该用户的书架中
            newMap.put("statue","checkmarkempty");
        }else if (statue == 0){
//            则证明该书籍还未加入到该用户的书架中
            newMap.put("statue","plusempty");
        }
        return newMap;
    }

    @Override
    public Integer addBookInBookRack(Map<String, Object> map) {
//        创建书架实体类
        BookrackInfoEntity bookrackInfoEntity = new BookrackInfoEntity();
        bookrackInfoEntity.setBookId(Long.valueOf((String) map.get("bookId")));
        bookrackInfoEntity.setUserId(Long.valueOf((String) map.get("userId")));
        bookrackInfoEntity.setDeleted(0);
        bookrackInfoEntity.setInsertTime(new Date());
        return bookrackInfoDao.insert(bookrackInfoEntity);
    }
}