package io.renren.modules.bookmanager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.bookmanager.entity.TopicEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author hujh
 * @email 1942698741@qq.com
 * @date 2022-04-26 19:18:59
 */
public interface TopicService extends IService<TopicEntity> {

    PageUtils queryPage(Map<String, Object> params);
//    获取题目相关信息
    List<Map<String, Object>> getSubjectList();
}

