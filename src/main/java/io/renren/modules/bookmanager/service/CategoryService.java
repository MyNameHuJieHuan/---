package io.renren.modules.bookmanager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.bookmanager.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author hujh
 * @email 1942698741@qq.com
 * @date 2022-03-24 20:41:35
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
//    获取图书的所有分类信息
    List<Map<String, Object>> getCategoryList();
//    根据用户输入的图书分类信息进行插入
    void insertCategory(String category);
//    根据分类ID获取对应的分类信息
    Map<String,Object> getCategoryNameByCode(String categoryCode);
//    根据分类编码获取对应的分类信息
    Map<String,Object> getCategoryNameById(Long categoryId);
//    根据分类编码查询当前分类下的所有类别信息，并得到相关性强度
    Map<String, Object> getCategoryCorrelationList(Long categoryCode);
//    获取所有的分类信息
    List<Map<String, Object>> getCategoryNameList();
}

