package io.renren.modules.bookmanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.bookmanager.dao.OfficalBookDao;
import io.renren.modules.bookmanager.entity.OfficalBookEntity;
import io.renren.modules.bookmanager.service.OfficalBookService;


@Service("officalBookService")
public class OfficalBookServiceImpl extends ServiceImpl<OfficalBookDao, OfficalBookEntity> implements OfficalBookService {
    @Autowired
    private OfficalBookDao officalBookDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OfficalBookEntity> page = this.page(
                new Query<OfficalBookEntity>().getPage(params),
                new QueryWrapper<OfficalBookEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public Map<String, Object> getBookInfo(String isbnCode) {
        return officalBookDao.getBookInfo(isbnCode);
    }
}