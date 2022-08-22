package io.renren.modules.bookmanager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.bookmanager.entity.DebitInfoEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-04 11:55:06
 */
public interface DebitInfoService extends IService<DebitInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    int insertDebitInfo(DebitInfoEntity debitInfo);
//    根据userId获取借记卡信息
    Map<String, Object> getDebitInfoByUserId(Integer userId);
}

