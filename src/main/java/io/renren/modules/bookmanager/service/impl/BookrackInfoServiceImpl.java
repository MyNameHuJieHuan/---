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

import io.renren.modules.bookmanager.dao.BookrackInfoDao;
import io.renren.modules.bookmanager.entity.BookrackInfoEntity;
import io.renren.modules.bookmanager.service.BookrackInfoService;


@Service("bookrackInfoService")
public class BookrackInfoServiceImpl extends ServiceImpl<BookrackInfoDao, BookrackInfoEntity> implements BookrackInfoService {
    @Autowired
    private BookrackInfoDao bookrackInfoDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BookrackInfoEntity> page = this.page(
                new Query<BookrackInfoEntity>().getPage(params),
                new QueryWrapper<BookrackInfoEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<Map<String, Object>> getBookrackList(Map<String, Object> map) {
        List<Map<String, Object>> list = bookrackInfoDao.getBookrackList(map);
        return list;
    }
}