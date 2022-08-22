package io.renren.modules.bookmanager.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import io.renren.modules.bookmanager.entity.*;
import io.renren.modules.bookmanager.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import org.springframework.web.multipart.MultipartFile;


/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-04 11:55:06
 */
@RestController
@RequestMapping("bookmanager/bookinfo")
public class BookInfoController {
    @Autowired
    private BookInfoService bookInfoService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ClassifyService classifyService;
    @Autowired
    private LibraryInfoService libraryInfoService;
    @Autowired
    private BookAddressService bookAddressService;
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("bookmanager:bookinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = bookInfoService.queryPage(params);
//        根据page中的list查询对应的图书馆名
        List<BookInfoEntity> list = (List<BookInfoEntity>) page.getList();
//        创建一个新的list用来接收处理之后的数据
        List<Map<String,Object>> list1 = new ArrayList<>();
//        遍历list
        for(BookInfoEntity bookInfoEntity:list){
//            判断当前数据是否已经逻辑删除
            if (bookInfoEntity.getDeleted() == 0) {
                HashMap map = new HashMap();
                map.put("bookId",bookInfoEntity.getBookId());
                map.put("bookCode",bookInfoEntity.getBookCode());
                map.put("bookName",bookInfoEntity.getBookName());
                map.put("bookPress",bookInfoEntity.getBookPress());
                map.put("insertName",bookInfoEntity.getInsertName());
                map.put("insertTime",bookInfoEntity.getInsertTime());
//                获取图书的分类信息
                Map<String,Object> categoryMap =categoryService.getCategoryNameById(bookInfoEntity.getCategoryCode());
                map.put("categoryName",categoryMap.get("categoryName"));
                Long libraryId = bookInfoEntity.getLibraryId();
                Map<String,Object> libraryNameMap =libraryInfoService.getLibraryNameById(libraryId);
                map.put("libraryName",libraryNameMap.get("libraryName"));
                map.put("address",libraryNameMap.get("address"));
                map.put("author",bookInfoEntity.getAuthor());
                map.put("pricing",bookInfoEntity.getPricing());
                map.put("pressTime",bookInfoEntity.getPressTime());
                list1.add(map);
            }
        }
        page.setList(list1);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{bookId}")
    @RequiresPermissions("bookmanager:bookinfo:info")
    public R info(@PathVariable("bookId") Long bookId){
		BookInfoEntity bookInfo = bookInfoService.getById(bookId);
		Map<String,Object> map = new HashMap<>();
		map.put("bookName",bookInfo.getBookName());
		map.put("bookPress",bookInfo.getBookPress());
        //                获取图书的分类信息
        Map<String,Object> categoryMap =categoryService.getCategoryNameById(bookInfo.getCategoryCode());
        map.put("categoryName",categoryMap.get("categoryName"));
        Long libraryId = bookInfo.getLibraryId();
        Map<String,Object> libraryNameMap =libraryInfoService.getLibraryNameById(libraryId);
        map.put("libraryName",libraryNameMap.get("libraryName"));
        map.put("address",libraryNameMap.get("address"));

        return R.ok().put("bookInfo", map);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("bookmanager:bookinfo:save")
    public R save(@RequestBody BookInfoEntity bookInfo){
        //        根据当前时间自动编译代码
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
        String dates = format.format(new Date());
//        使用random产生随机数
        Random random = new Random();
        int i = random.nextInt(1000);
        String code = dates+i;
        bookInfo.setBookCode(code);
//        对cateCode进行拆分处理，得到相对应的类别
//        String categoryCode = bookInfo.getCategoryCode();
//        String [] categoryCodes = categoryCode.split("-");
////        创建分类实体类
//        CategoryEntity categoryEntity = new CategoryEntity();
//        categoryEntity.setCategoryCode(categoryCode);
//        创建书籍地址实体类，改变书籍存储位置的状态
        BookAddressEntity bookAddressEntity = new BookAddressEntity();
        bookAddressEntity.setAddressId(bookInfo.getAddressId());
        bookAddressEntity.setStatus(0);
        bookAddressEntity.setUpdateName(bookInfo.getInsertName());
        bookAddressEntity.setUpdateTime(new Date());
        bookAddressService.updateById(bookAddressEntity);

        bookInfo.setDeleted((long) 0);
        bookInfo.setInsertName("admin");
        bookInfo.setInsertTime(new Date());

//        categoryService.save(categoryEntity);
		bookInfoService.save(bookInfo);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("bookmanager:bookinfo:update")
    public R update(@RequestBody(required = false) Map<String,Object> map){
        BookInfoEntity bookInfo = new BookInfoEntity();
        bookInfo.setBookId(Long.valueOf((Integer) map.get("bookId")));
        bookInfo.setBookName((String)map.get("bookName"));
        bookInfo.setBookPress((String)map.get("bookPress"));
        bookInfo.setLibraryId((Long)map.get("libraryId"));
        bookInfo.setBookCode((String)map.get("categoryCode"));
        bookInfo.setUpdateName((String)map.get("userName"));
        bookInfo.setUpdateTime(new Date());
//        处理图片
        bookInfo.setBookImageurl((String)map.get("image"));
        bookInfoService.updateById(bookInfo);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("bookmanager:bookinfo:delete")
    public R delete(@RequestBody Long[] bookIds){
		bookInfoService.removeByIds(Arrays.asList(bookIds));

        return R.ok();
    }

//    获取书籍的相关信息
    @RequestMapping("/getBooksList")
    public R getBooksList(@RequestParam Map<String, Object> params){
        List<Map<String,Object>> list = bookInfoService.getBooksList();
        return R.ok().put("list", list);
    }
//    接收前端传过来的图片并进行处理
    @PostMapping("/saveImageUrl")
    public R saveImageUrl(@RequestParam(value = "file") MultipartFile multipartFile){
//        对图片资源进行处理
        Map<String, Object> map = bookInfoService.updateImage(multipartFile);
        return R.ok(map);
    }
}
