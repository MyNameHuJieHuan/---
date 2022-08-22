package io.renren.modules.bookmanager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.bookmanager.entity.LibraryInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-04 11:55:06
 */
public interface LibraryInfoService extends IService<LibraryInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
//    根据图书馆Id获取图书馆相关信息
    Map<String,Object> getLibraryNameById(Long libraryId);
//    获取所有的图书馆信息
    List<Map<String, Object>> getLibraryNameList();
}

