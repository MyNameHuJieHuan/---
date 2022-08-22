package io.renren.modules.bookmanager.dao;

import io.renren.modules.bookmanager.entity.DebitInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.swagger.models.auth.In;
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
public interface DebitInfoDao extends BaseMapper<DebitInfoEntity> {
//    根据读者Id获取读者借记卡相关信息
    Map<String, Object> getDebitInfoByUserId(Integer userId);
}
