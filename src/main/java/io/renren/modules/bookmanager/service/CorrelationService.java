package io.renren.modules.bookmanager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.bookmanager.entity.CorrelationEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author hujh
 * @email 1942698741@qq.com
 * @date 2022-04-08 20:24:17
 */
public interface CorrelationService extends IService<CorrelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
//    根据穿过来的类以及用户Id新增相关性数据
    int insertCorrelation(Long categoryCode, Long userId);
//    根据userId和选择的题目选项新增用户的相关性强度
    int insetCorrelation(Map<String, Object> map);
}

