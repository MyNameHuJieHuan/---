package io.renren.modules.bookmanager.dao;

import io.renren.modules.bookmanager.entity.ForwardInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-04 16:10:07
 */
@Mapper
public interface ForwardInfoDao extends BaseMapper<ForwardInfoEntity> {
//    根据userId获取预约记录相关信息
    List<Map<String,Object>> getForwardInfoByUserId(Integer userId);
}
