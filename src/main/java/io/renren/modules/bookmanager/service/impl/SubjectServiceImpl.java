package io.renren.modules.bookmanager.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.bookmanager.dao.SubjectDao;
import io.renren.modules.bookmanager.entity.SubjectEntity;
import io.renren.modules.bookmanager.service.SubjectService;


@Service("subjectService")
public class SubjectServiceImpl extends ServiceImpl<SubjectDao, SubjectEntity> implements SubjectService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SubjectEntity> page = this.page(
                new Query<SubjectEntity>().getPage(params),
                new QueryWrapper<SubjectEntity>()
        );

        return new PageUtils(page);
    }

}