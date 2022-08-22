package io.renren.modules.bookmanager.dao;

import io.renren.modules.bookmanager.entity.TopicEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author hujh
 * @email 1942698741@qq.com
 * @date 2022-04-26 19:18:59
 */
@Mapper
public interface TopicDao extends BaseMapper<TopicEntity> {
//    获取题目相关信息
    List<Map<String, Object>> getSubjectList();
}
