package io.renren.modules.bookmanager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.bookmanager.entity.SubjectEntity;

import java.util.Map;

/**
 * 
 *
 * @author hujh
 * @email 1942698741@qq.com
 * @date 2022-04-08 20:24:18
 */
public interface SubjectService extends IService<SubjectEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

