package io.renren.modules.bookmanager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.bookmanager.entity.BookAddressEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-07 20:28:23
 */
public interface BookAddressService extends IService<BookAddressEntity> {

    List<Map<String,Object>> queryPage(Map<String, Object> params);
//    根据前端选择的图书馆和图书类别自动匹配并生成对应的书架号
    Map<String, Object> getBookAddress(Map<String, Object> params);
}

