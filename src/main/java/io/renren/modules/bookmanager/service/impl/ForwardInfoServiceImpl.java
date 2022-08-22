package io.renren.modules.bookmanager.service.impl;

import io.renren.modules.bookmanager.entity.DebitInfoEntity;
import io.renren.modules.sys.dao.SysUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.bookmanager.dao.ForwardInfoDao;
import io.renren.modules.bookmanager.entity.ForwardInfoEntity;
import io.renren.modules.bookmanager.service.ForwardInfoService;


@Service("forwardInfoService")
public class ForwardInfoServiceImpl extends ServiceImpl<ForwardInfoDao, ForwardInfoEntity> implements ForwardInfoService {
    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private ForwardInfoDao forwardInfoDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ForwardInfoEntity> page = this.page(
                new Query<ForwardInfoEntity>().getPage(params),
                new QueryWrapper<ForwardInfoEntity>()
        );
        //        创建一个方法用来通过账号名获取这个账号的角色权限
        Map<String,Object> roleMap = new HashMap<>();
        if (!params.get("userName").equals("admin")){
            String userName = (String) params.get("userName");
            roleMap= sysUserDao.getUserRoleByUserName(userName);
        }else{
            roleMap.put("roleName","超级管理员");
            roleMap.put("roleId",0);
        }
//        根据账号信息判断是否要对具体的数据进行展示
        List<ForwardInfoEntity> list = new ArrayList<>();
//        当用户为超级管理员或者管理员时直接跳过该步骤
        if (roleMap.get("roleId").equals("2")){
            //        遍历数据
            for (ForwardInfoEntity forwardInfoEntity:page.getRecords()){
                long userId = forwardInfoEntity.getUserId();
                Map<String,Object> userMap = sysUserDao.getUserNameById(userId);
//                当数据是对应的账号信息时
                if (userMap.get("userName").equals(params.get("userName"))){
                    list.add(forwardInfoEntity);
                }
                continue;
            }
            page.setRecords(list);
            return new PageUtils(page);
        }
        return new PageUtils(page);
    }

    @Override
    public List<Map<String,Object>>  getForwardInfoByUserId(Integer userId) {
        return forwardInfoDao.getForwardInfoByUserId(userId);
    }
}