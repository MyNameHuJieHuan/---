package io.renren.modules.bookmanager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.bookmanager.entity.CirculationInfoEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-04 11:55:06
 */
public interface CirculationInfoService extends IService<CirculationInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
//    根据图书编码判断该书的状态是处于借书还是还书状态
    Map<String, Object> getCirculationInfo(String isbnCode);
//    根据状态判断是新增还是修改借还记录
    int insertCirculation(Map<String, Object> map);
}

