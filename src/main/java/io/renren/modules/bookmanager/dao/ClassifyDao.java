package io.renren.modules.bookmanager.dao;

import io.renren.modules.bookmanager.entity.ClassifyEntity;
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
public interface ClassifyDao extends BaseMapper<ClassifyEntity> {
//    获取所有的图书类别信息
    List<Map<String, Object>> getClassifyNameList();
//    根据分类Id获取对应的分类名
    String getClassifyNameById(long firstClassifyId);
}
