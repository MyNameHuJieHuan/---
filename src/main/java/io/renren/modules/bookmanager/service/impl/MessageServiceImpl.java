package io.renren.modules.bookmanager.service.impl;

import io.renren.modules.sys.dao.SysUserDao;
import io.renren.modules.sys.entity.SysUserEntity;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.bookmanager.dao.MessageDao;
import io.renren.modules.bookmanager.entity.MessageEntity;
import io.renren.modules.bookmanager.service.MessageService;


@Service("messageService")
public class MessageServiceImpl extends ServiceImpl<MessageDao, MessageEntity> implements MessageService {
    @Autowired
    private MessageDao messageDao;
    @Autowired
    private SysUserDao sysUserDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MessageEntity> page = this.page(
                new Query<MessageEntity>().getPage(params),
                new QueryWrapper<MessageEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<Map<String, Object>> getMessageInfo(Integer userId) {
//        判断当前联系人是否是管理员
        Map<String,Object> map1 = sysUserDao.getUserNameById(Long.valueOf(userId));
        List<Map<String, Object>> list = new ArrayList<>();
        if ((Long)map1.get("roleId") == 1){
            list = messageDao.getManagerInfo(userId);
        }else{
            list = messageDao.getMessageInfo(userId);
        }
//        对获取的联系人集合进行去重
        List<Map<String,Object>> newList = new ArrayList<>();
        Map<String,Object> newMap = new HashMap<>();
        for (Map<String, Object> map : list) {
            if(!newMap.containsValue(map.get("sendUserName"))){
                newMap = map;
                newList.add(map);
            }
        }
        return newList;
    }

    @Override
    public List<Map<String, Object>> getMessageDetail(Map<String, Object> map) {
//        判断当前的传过来的用户是谁，并设置对应的状态
        Integer userId = (Integer)map.get("sendUserId");
        List<Map<String, Object>> list = messageDao.getMessageDetail(map);
        int status =0;
//        遍历list进行处理
        for(Map<String,Object> map1:list){
            if ((Long)map1.get("sendUserId")==Long.valueOf(userId)){
                status = 0;
            }else{
                status = 1;
            }
            map1.put("status",status);
        }
        return list;
    }

    @Override
    public int insertMessage(Map<String, Object> map) {
//        获取前端的map，创建消息实体类，并生成对应的数据
        MessageEntity messageEntity = new MessageEntity();
        Integer sendId = (Integer) map.get("sendUserId");
        messageEntity.setSendId(sendId.longValue());
        Integer receivedId = (Integer) map.get("receivedUserId");
        messageEntity.setReceiveId(Long.valueOf(receivedId));
        messageEntity.setMessageInfo((String) map.get("matter"));
        Map<String,Object> map1 = sysUserDao.getUserNameById(sendId.longValue());
        messageEntity.setInsertName((String) map1.get("userName"));
        messageEntity.setDeleted(0);
        messageEntity.setInsertTime(new Date());
        return messageDao.insert(messageEntity);
    }
}