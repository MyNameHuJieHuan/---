package io.renren.modules.bookmanager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.bookmanager.entity.BookInfoEntity;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-04 11:55:06
 */
public interface BookInfoService extends IService<BookInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
//    根据bookId获取书籍的相关数据
    Map<String, Object> getBookNameById(Long bookId);
//    获取所有的书籍的相关信息
    List<Map<String, Object>> getBooksList();
//    根据ISBNCode编码查询对应的图书信息
    Map<String, Object> getBookInfo(String isbnCode);
//    根据搜索框搜索的内容进行书籍检索
    List<Map<String, Object>> selectBookList(Map<String, Object> map);
//    新增图书信息到本地图书馆的数据库中
    int insertBookInfo(Map<String, Object> map) throws ParseException;
//    对前端传过来的图片进行处理
    Map<String, Object> updateImage(MultipartFile multipartFile);
//    根据userId获取每个人不同的推荐数据
    Map<String, List<Map<String,Object>>> getSectionalizerList(Map<String, Object> map);
//    根据用户Id和书籍Id获取书籍的相关信息
    Map<String, Object> getBookById(Map<String, Object> map);
//    给对应的用户的书架添加对应的书籍
    Integer addBookInBookRack(Map<String, Object> map);
}

