package io.renren.modules.bookmanager.dao;

import io.renren.modules.bookmanager.entity.LibraryInfoEntity;
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
public interface LibraryInfoDao extends BaseMapper<LibraryInfoEntity> {
//    根据图书馆ID获取图书馆相关信息
    Map<String, Object> getLibraryNameById(Long libraryId);
//    获取所有的图书馆相关信息
    List<Map<String, Object>> getLibraryNameList();
}
