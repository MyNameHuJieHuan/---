package io.renren.modules.bookmanager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.bookmanager.entity.MessageEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author hujh
 * @email 1942698741@qq.com
 * @date 2022-03-20 21:54:22
 */
public interface MessageService extends IService<MessageEntity> {

    PageUtils queryPage(Map<String, Object> params);
//    根据用户Id获取用户对应的所有消息联系人
    List<Map<String, Object>> getMessageInfo(Integer userId);
//    根据收发人的Id获取两个人的聊天记录
    List<Map<String, Object>> getMessageDetail(Map<String, Object> map);
//    新增消息
    int insertMessage(Map<String, Object> map);
}

