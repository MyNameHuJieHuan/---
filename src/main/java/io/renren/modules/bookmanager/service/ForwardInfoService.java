package io.renren.modules.bookmanager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.bookmanager.entity.ForwardInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-04 16:10:07
 */
public interface ForwardInfoService extends IService<ForwardInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
//    根据userId获取预约记录相关信息
    List<Map<String,Object>>  getForwardInfoByUserId(Integer userId);
}

