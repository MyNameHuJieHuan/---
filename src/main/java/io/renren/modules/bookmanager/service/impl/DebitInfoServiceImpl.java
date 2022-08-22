package io.renren.modules.bookmanager.service.impl;

import io.renren.modules.bookmanager.entity.CirculationInfoEntity;
import io.renren.modules.sys.dao.SysUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.bookmanager.dao.DebitInfoDao;
import io.renren.modules.bookmanager.entity.DebitInfoEntity;
import io.renren.modules.bookmanager.service.DebitInfoService;


@Service("debitInfoService")
public class DebitInfoServiceImpl extends ServiceImpl<DebitInfoDao, DebitInfoEntity> implements DebitInfoService {
    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private DebitInfoDao debitInfoDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DebitInfoEntity> page = this.page(
                new Query<DebitInfoEntity>().getPage(params),
                new QueryWrapper<DebitInfoEntity>()
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
        List<DebitInfoEntity> list = new ArrayList<>();
//        当用户为超级管理员或者管理员时直接跳过该步骤
        if (roleMap.get("roleId").equals("2")){
            //        遍历数据
            for (DebitInfoEntity debitInfoEntity:page.getRecords()){
                long userId = debitInfoEntity.getUserId();
                Map<String,Object> userMap = sysUserDao.getUserNameById(userId);
//                当数据是对应的账号信息时
                if (userMap.get("userName").equals(params.get("userName"))){
                    list.add(debitInfoEntity);
                }
                continue;
            }
            page.setRecords(list);
            return new PageUtils(page);
        }
        return new PageUtils(page);
    }

    @Override
    public int insertDebitInfo(DebitInfoEntity debitInfo) {
        //        根据时间创建编码
        Date date = new Date();
        //        根据当前时间自动编译代码
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
        String dates = format.format(date);
//        使用random产生随机数
        Random random = new Random();
        int i = random.nextInt(1000);
        String code = dates+i;
        debitInfo.setDebitCode(code);
        debitInfo.setStatus((long) 0);
        debitInfo.setDeleted((long) 0);
        debitInfo.setInsertName("admin");
        debitInfo.setInsertTime(new Date());
//        借记卡级别初始时默认为1
        debitInfo.setDebitLevel(1);
//        借记卡有效期开始时默认为1年后
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1);
        debitInfo.setDebitValidity(calendar.getTime());
        return debitInfoDao.insert(debitInfo);
    }

    @Override
    public Map<String, Object> getDebitInfoByUserId(Integer userId) {
        Map<String,Object> map = debitInfoDao.getDebitInfoByUserId(userId);
//        获取当前借记卡的状态
        Long status = (Long)map.get("status");
        if (status==0){
            map.put("status","正常");
        }else{
            map.put("status","禁用");
        }
        return map;
    }
}