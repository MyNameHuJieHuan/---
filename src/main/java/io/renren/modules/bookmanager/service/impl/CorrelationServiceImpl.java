package io.renren.modules.bookmanager.service.impl;

import io.renren.modules.bookmanager.service.CategoryService;
import io.renren.modules.sys.dao.SysUserDao;
import io.renren.modules.sys.entity.SysUserEntity;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.bookmanager.dao.CorrelationDao;
import io.renren.modules.bookmanager.entity.CorrelationEntity;
import io.renren.modules.bookmanager.service.CorrelationService;


@Service("correlationService")
public class CorrelationServiceImpl extends ServiceImpl<CorrelationDao, CorrelationEntity> implements CorrelationService {
    @Autowired
    private CorrelationDao correlationDao;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private CorrelationService correlationService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CorrelationEntity> page = this.page(
                new Query<CorrelationEntity>().getPage(params),
                new QueryWrapper<CorrelationEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public int insertCorrelation(Long categoryId, Long userId) {

        Map<String,Object> mapList = categoryService.getCategoryCorrelationList(categoryId);
//        使用set集合对mapList中的数据进行处理
        Set keySet = mapList.keySet();
//        遍历list集合
        for (Object key : keySet) {
//        首先判断当前相关性是否已经存在与数据之中
            Map<String,Object> map = correlationDao.getCorrelationByCategoryCode((String) key);
            CorrelationEntity correlationEntity = new CorrelationEntity();
            correlationEntity.setUserid(userId);
            correlationEntity.setCategoryCode((String) key);
            //        判断当前map是否为空
            if(map == null){
                //        根据分类编码并计算相关分类的相关性强度,并对相关性强度的表进行新增
                correlationEntity.setCorrelationStrength((Double) mapList.get(key));
                correlationDao.insert(correlationEntity);
            }else{
                correlationEntity.setCorrelationStrength((Double) map.get("correlationStrength")+(Double) mapList.get(key));
                correlationEntity.setCorrelationId((Long) map.get("correlationId"));
                correlationDao.updateById(correlationEntity);
            }
        }
        return 0;
    }

    @Override
    public int insetCorrelation(Map<String, Object> map) {
//        修改用户表中该用户状态不是第一次登录
        Long userId = Long.valueOf((Integer)map.get("userId"));
        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setUserId(userId);
        sysUserEntity.setStatus(1);
        sysUserDao.updateById(sysUserEntity);
        Integer select = 1;
//        创建数组，用来判断用户选择的是哪一个分类的
        int [] arr;
        if(select == 0){
            arr = new int[]{12, 22,37,47,48,46};
        }else if(select == 1){
            arr = new int[]{49,50,51,52,53};
        }else if(select == 2){
            arr = new int[]{54,55,56,57,58,59,60,61,62,63,64,65};
        }else{
            arr = new int[]{66};
        }
        for (int i = 0;i<arr.length;i++) {
            Integer num = arr[i];
            correlationService.insertCorrelation(Long.valueOf(num),userId);
        }
        return 0;
    }
}