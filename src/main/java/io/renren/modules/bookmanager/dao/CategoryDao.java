package io.renren.modules.bookmanager.dao;

import io.renren.modules.bookmanager.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author hujh
 * @email 1942698741@qq.com
 * @date 2022-03-24 20:41:35
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
//    获取所有当前结点下的所有分类
    List<Map<String, Object>> getFatherList(long categoryId);
//    根据分类名判断当前数据库中是否存在对应的类名
    int getCategory(String categoryName);
//    根据分类名获取对应的分类ID
    Map<String,Object> getCategoryIdByName(String s);
//根据分类Id获取对应的分类信息
    Map<String, Object> getCategoryNameById(Long categoryId);
//    根据传过来的中图编码进行模糊查询
    List<Map<String, Object>> getCategoryListByCode(String num);
    //根据分类编码获取对应的分类信息
    Map<String, Object> getCategoryNameByCode(String categoryCode);
//    获取所有的分类信息
    List<Map<String, Object>> getCategoryNameList();
}
