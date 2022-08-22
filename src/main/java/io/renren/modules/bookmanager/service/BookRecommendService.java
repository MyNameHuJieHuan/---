package io.renren.modules.bookmanager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.bookmanager.entity.BookRecommendEntity;

import java.util.Map;

/**
 * 
 *
 * @author hujh
 * @email 1942698741@qq.com
 * @date 2022-03-09 17:20:33
 */
public interface BookRecommendService extends IService<BookRecommendEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

