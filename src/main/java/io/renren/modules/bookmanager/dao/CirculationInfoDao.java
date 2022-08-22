package io.renren.modules.bookmanager.dao;

import io.renren.modules.bookmanager.entity.CirculationInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-04 11:55:06
 */
@Mapper
public interface CirculationInfoDao extends BaseMapper<CirculationInfoEntity> {
//    根据图书编码获取该图书的相关信息，并判断该图书的状态
    Map<String, Object> getCirculationInfo(Map<String,Object> map);
//    根据图书编码判断当前数据库中是否存在对应的借还记录且没有逻辑删除
    int getCirculationByCode(String isbnCode);
//    根据用户查看当前用户已经借了多少本书
    int getCirculationNumberByUserName(String user);
}
