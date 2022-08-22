package io.renren.modules.bookmanager.dao;

import io.renren.modules.bookmanager.entity.BookrackInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author hujh
 * @email 1942698741@qq.com
 * @date 2022-04-14 17:56:38
 */
@Mapper
public interface BookrackInfoDao extends BaseMapper<BookrackInfoEntity> {
//    根据userId获取书架的数据
    List<Map<String, Object>> getBookrackList(Map<String, Object> map);
}
