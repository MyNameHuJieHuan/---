package io.renren.modules.bookmanager.dao;

import io.renren.modules.bookmanager.entity.BookInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-04 11:55:06
 */
@Mapper
public interface BookInfoDao extends BaseMapper<BookInfoEntity> {
//    根据书籍Id获取相关书籍信息
    Map<String, Object> getBookNameById(Long bookId);
//    获取所有的书籍相关信息
    List<Map<String, Object>> getBookList();
//    根据ISBNCode编码查询对应的图书信息
    Map<String, Object> getBookInfo(String isbnCode);
//        根据搜索框搜索的内容进行书籍检索
    List<Map<String, Object>> selectBookList(String con);
//    根据前端传过来的参数对数据进行查询
    List<Map<String,Object>> selectBookListByCon(String con);
//    根据书籍Id，获取书籍的详细信息
    Map<String, Object> getBookById(Long bookId);
//    根据用户Id和书籍Id，判断该书籍是否加入到该用户的书架中
    Integer getBookIsUserById(Map<String, Object> map);
//    根据分类编码获取对应的书籍信息
    List<Map<String, Object>> getBookByCategoryCode(String categoryCode);
//    根据分类编码和用户Id进行对书籍的筛选
    List<Map<String, Object>> getBookByCategoryCodeByUserId(Map<String, Object> map1);
//    根据userId和分类编码对书籍进行筛选
    List<Map<String, Object>> getBookListByCategory(Map<String, Object> map1);
}
