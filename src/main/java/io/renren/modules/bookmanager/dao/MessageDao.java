package io.renren.modules.bookmanager.dao;

import io.renren.modules.bookmanager.entity.MessageEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author hujh
 * @email 1942698741@qq.com
 * @date 2022-03-20 21:54:22
 */
@Mapper
public interface MessageDao extends BaseMapper<MessageEntity> {
//    根据userId获取对应的用户的所有发过消息的联系人
    List<Map<String, Object>> getMessageInfo(Integer userId);
//    根据收发人信息获取两个人之间的童话记录
    List<Map<String, Object>> getMessageDetail(Map<String, Object> map);
//    获取所有的联系人
    List<Map<String, Object>> getManagerInfo(Integer userId);
}
