package io.renren.modules.bookmanager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.bookmanager.entity.BookrackInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author hujh
 * @email 1942698741@qq.com
 * @date 2022-04-14 17:56:38
 */
public interface BookrackInfoService extends IService<BookrackInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
//    获取书架上的数据
    List<Map<String, Object>> getBookrackList(Map<String, Object> map);
}

