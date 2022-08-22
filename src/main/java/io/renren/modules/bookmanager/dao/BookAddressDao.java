package io.renren.modules.bookmanager.dao;

import io.renren.modules.bookmanager.entity.BookAddressEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-07 20:28:23
 */
@Mapper
public interface BookAddressDao extends BaseMapper<BookAddressEntity> {
//    根据图书馆ID和书籍类别ID获取对应的书籍存放地址
    Map<String, Object> getBookAddress(Map<String,Object> maps);
//    根据分类编码获取数据库中是否存在对应的书架地址
    Map<String, Object> getBookAddressByCategoryId(String categoryCode);
//    获取所有的书籍地址信息
    List<Map<String, Object>> getBookAddressList();
}
