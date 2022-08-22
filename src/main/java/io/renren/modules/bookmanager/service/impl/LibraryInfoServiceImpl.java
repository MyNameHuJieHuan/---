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

import io.renren.modules.bookmanager.dao.LibraryInfoDao;
import io.renren.modules.bookmanager.entity.LibraryInfoEntity;
import io.renren.modules.bookmanager.service.LibraryInfoService;


@Service("libraryInfoService")
public class LibraryInfoServiceImpl extends ServiceImpl<LibraryInfoDao, LibraryInfoEntity> implements LibraryInfoService {

    @Autowired
    private LibraryInfoDao libraryInfoDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LibraryInfoEntity> page = this.page(
                new Query<LibraryInfoEntity>().getPage(params),
                new QueryWrapper<LibraryInfoEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public Map<String, Object> getLibraryNameById(Long libraryId) {
        return libraryInfoDao.getLibraryNameById(libraryId);
    }

    @Override
    public List<Map<String, Object>> getLibraryNameList() {
        return libraryInfoDao.getLibraryNameList();
    }
}