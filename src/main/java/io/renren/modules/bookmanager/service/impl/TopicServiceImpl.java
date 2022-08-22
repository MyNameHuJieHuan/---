package io.renren.modules.bookmanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.bookmanager.dao.TopicDao;
import io.renren.modules.bookmanager.entity.TopicEntity;
import io.renren.modules.bookmanager.service.TopicService;


@Service("topicService")
public class TopicServiceImpl extends ServiceImpl<TopicDao, TopicEntity> implements TopicService {
    @Autowired
    private TopicDao topicDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TopicEntity> page = this.page(
                new Query<TopicEntity>().getPage(params),
                new QueryWrapper<TopicEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<Map<String, Object>> getSubjectList() {
        return topicDao.getSubjectList();
    }
}