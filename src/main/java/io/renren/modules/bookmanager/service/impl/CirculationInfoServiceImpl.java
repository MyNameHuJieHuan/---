package io.renren.modules.bookmanager.service.impl;

import io.renren.modules.sys.dao.SysUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.bookmanager.dao.CirculationInfoDao;
import io.renren.modules.bookmanager.entity.CirculationInfoEntity;
import io.renren.modules.bookmanager.service.CirculationInfoService;


@Service("circulationInfoService")
public class CirculationInfoServiceImpl extends ServiceImpl<CirculationInfoDao, CirculationInfoEntity> implements CirculationInfoService {
    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private CirculationInfoDao circulationInfoDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CirculationInfoEntity> page = this.page(
                new Query<CirculationInfoEntity>().getPage(params),
                new QueryWrapper<CirculationInfoEntity>()
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
        List<CirculationInfoEntity> list = new ArrayList<>();
//        当用户为超级管理员或者管理员时直接跳过该步骤
       if (roleMap.get("roleId").equals("2")){
            //        遍历数据
            for (CirculationInfoEntity circulationInfoEntity:page.getRecords()){
                long userId = circulationInfoEntity.getUserId();
                Map<String,Object> userMap = sysUserDao.getUserNameById(userId);
//                当数据是对应的账号信息时
                if (userMap.get("userName").equals(params.get("userName"))){
                    list.add(circulationInfoEntity);
                }
                continue;
            }
            page.setRecords(list);
            return new PageUtils(page);
        }
        return new PageUtils(page);
    }

    @Override
    public Map<String, Object> getCirculationInfo(String isbnCode) {
//        首先，判断该书是否已经存在了借还记录且没有逻辑删除
//        如果有则代表该书是要还书，如果没有则代表该书是要借书
        int count = circulationInfoDao.getCirculationByCode(isbnCode);
        Map<String,Object> map = new HashMap<>();
        map.put("isbnCode",isbnCode);
        int statuss =0;
        if(count == 0){
//            该书为借书状态
            statuss = 0;
            map.put("statuss",statuss);
        }else if(count == 1){
//            该书为还书状态
            statuss = 1;
            map.put("statuss",statuss);
        }else{
            return null;
        }
        Map<String, Object> map1 = circulationInfoDao.getCirculationInfo(map);
        map1.put("statuss",statuss);
        return map1;
    }

    @Override
    public int insertCirculation(Map<String, Object> map) {
//        先判断当前书籍的状态是借书还是还书
//        先判断借还书的人在我们系统不
//        根据userName判断该读者在我们系统不，并且他的借记卡等级是多少，能借多少书
        Map<String,Object> map1 = sysUserDao.getReaderByUserName((String) map.get("user"));
        if(map1 == null){
            return 0;
        }
        if((Long)map1.get("status") == 1){
            return  -1;
        }
//        根据用户名判断当前用户已经借记还没有还的数量
        int count = circulationInfoDao.getCirculationNumberByUserName((String) map.get("user"));
        if(count >= (Integer) map1.get("debitNumber")){
            return -2;
        }
        int result =0;
//        创建借还实体类
        CirculationInfoEntity circulationInfoEntity = new CirculationInfoEntity();
        if((Integer)map.get("statuss")==0){
//            是借书
            circulationInfoEntity.setDeleted((long)0);
            circulationInfoEntity.setStatus((long)0);
            circulationInfoEntity.setInsertTime(new Date());
            circulationInfoEntity.setInsertName("admin");
            circulationInfoEntity.setBookId(Long.valueOf((Integer)map.get("bookId")));
            circulationInfoEntity.setUserId((Long)map1.get("userId"));
            circulationInfoEntity.setBorrowTime(new Date());
            result += circulationInfoDao.insert(circulationInfoEntity);
        }else if((Integer)map.get("statuss")==1){
//            是还书
            circulationInfoEntity.setDeleted((long) 1);
            circulationInfoEntity.setCirculationId(Long.valueOf((Integer)map.get("circulationId")));
            circulationInfoEntity.setUpdateName("admin");
            circulationInfoEntity.setUpdateTime(new Date());
            circulationInfoEntity.setReturnTime(new Date());
            circulationInfoEntity.setStatus((long)1);
            result += circulationInfoDao.updateById(circulationInfoEntity);
        }
        return result;
    }
}