package io.renren.modules.bookmanager.dao;

import io.renren.modules.bookmanager.entity.OfficalBookEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 
 * 
 * @author hujh
 * @email 1942698741@qq.com
 * @date 2022-03-24 20:41:35
 */
@Mapper
public interface OfficalBookDao extends BaseMapper<OfficalBookEntity> {
//    根据isbn编码获取对应的图书信息
    Map<String, Object> getBookInfo(String isbnCode);
}
