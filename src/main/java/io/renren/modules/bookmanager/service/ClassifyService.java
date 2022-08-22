package io.renren.modules.bookmanager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.bookmanager.entity.ClassifyEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-04 11:55:06
 */
public interface ClassifyService extends IService<ClassifyEntity> {

    PageUtils queryPage(Map<String, Object> params);
//    获取所有的图书类别信息
    List<Map<String, Object>> getClassifyNameList();
//    根据分类Id获取分类名
    String getClassifyNameById(long firstClassifyId);
}

