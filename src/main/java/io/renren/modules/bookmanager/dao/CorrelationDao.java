package io.renren.modules.bookmanager.dao;

import io.renren.modules.bookmanager.entity.CorrelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author hujh
 * @email 1942698741@qq.com
 * @date 2022-04-08 20:24:17
 */
@Mapper
public interface CorrelationDao extends BaseMapper<CorrelationEntity> {
//    根据分类ID判断当前相关性表中是否存在着对应的数据
    Map<String, Object> getCorrelationByCategory(Long categoryId);
//    根据分类编码判断当前相关性表中是否存在着对应的数据
    Map<String, Object> getCorrelationByCategoryCode(String categoryCode);
//    根据userId获取对应的推荐数据，并根据相关强度递减
    List<Map<String, Object>> getCorrelationByUserId(Long userId);
}
