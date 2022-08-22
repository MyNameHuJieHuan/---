package io.renren.modules.bookmanager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.bookmanager.entity.OfficalBookEntity;

import java.util.Map;

/**
 * 
 *
 * @author hujh
 * @email 1942698741@qq.com
 * @date 2022-03-24 20:41:35
 */
public interface OfficalBookService extends IService<OfficalBookEntity> {

    PageUtils queryPage(Map<String, Object> params);
//    根据isbn编码获取对应的图书信息
    Map<String, Object> getBookInfo(String isbnCode);
}

