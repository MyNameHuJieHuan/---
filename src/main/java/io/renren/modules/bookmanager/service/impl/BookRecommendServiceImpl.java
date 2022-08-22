package io.renren.modules.bookmanager.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.bookmanager.dao.BookRecommendDao;
import io.renren.modules.bookmanager.entity.BookRecommendEntity;
import io.renren.modules.bookmanager.service.BookRecommendService;


@Service("bookRecommendService")
public class BookRecommendServiceImpl extends ServiceImpl<BookRecommendDao, BookRecommendEntity> implements BookRecommendService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BookRecommendEntity> page = this.page(
                new Query<BookRecommendEntity>().getPage(params),
                new QueryWrapper<BookRecommendEntity>()
        );

        return new PageUtils(page);
    }

}