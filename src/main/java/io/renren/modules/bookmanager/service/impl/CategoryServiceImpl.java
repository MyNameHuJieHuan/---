package io.renren.modules.bookmanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.bookmanager.dao.CategoryDao;
import io.renren.modules.bookmanager.entity.CategoryEntity;
import io.renren.modules.bookmanager.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<Map<String, Object>> getCategoryList() {
//        设置初始的结点为0
        long categoryId = 0;
        List<Map<String, Object>> list = categoryDao.getFatherList(categoryId);
        return null;
    }

//    创建一个递归调用的方法
    public List<Map<String,Object>> Recursion(long categoryId){
        List<Map<String,Object>> list = categoryDao.getFatherList(categoryId);
        for(Map<String,Object> map:list){
            long categoryIds = (Long)map.get("categoryId");
            Recursion(categoryIds);
        }
        return list;
    }

    @Override
    public void insertCategory(String category) {
//        对category进行字符拆分，得到每个分类的信息
        String [] arr = category.split("/");
//        将categoryId进行初始化
        long categoryId = 0;
        for (int i=0;i<arr.length;i++){
//            查询当前分类的父亲Id,并判断其是否存在
            int result = categoryDao.getCategory(arr[i]);
            if(result >0){
//                这个时候类名已经存在，调用方法，根据类名查找对应的类名Id
                Map<String,Object> categorys = categoryDao.getCategoryIdByName(arr[i]);
                categoryId = (Long)categorys.get("categoryId");
                continue;
            }else if(result ==0){
//                当分类不存在时，新增分类
//                创建category实体类
                CategoryEntity categoryEntity = new CategoryEntity();
                categoryEntity.setInsertTime(new Date());
                categoryEntity.setInsertName("admin");
                categoryEntity.setDeleted((long) 0);
                categoryEntity.setCategoryName(arr[i]);
                //        根据当前时间自动编译代码
                SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
                String dates = format.format(new Date());
//        使用random产生随机数
                Random random = new Random();
                int j = random.nextInt(1000);
                String code = dates+j;
                categoryEntity.setCategoryCode(code);
                categoryDao.insert(categoryEntity);
            }
        }
    }

    @Override
    public Map<String, Object> getCategoryNameByCode(String categoryCode) {
        return categoryDao.getCategoryNameByCode(categoryCode);
    }

    @Override
    public Map<String, Object> getCategoryNameById(Long categoryId) {
        return categoryDao.getCategoryNameById(categoryId);
    }

    @Override
    public Map<String, Object> getCategoryCorrelationList(Long categoryId) {
//        首先根据cateCode编码获取对应的分类信息
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map = categoryDao.getCategoryNameById(categoryId);
//        获取中图分类编码
        String categoryCode = (String) map.get("categoryCode");
//        对获取到的中途分类编码进行分解
        int j = categoryCode.length();
        while (j>0){
            String num = categoryCode.substring(0,j)+"%";
//            分类编码从强到弱
            List<Map<String,Object>> categoryList = categoryDao.getCategoryListByCode(num);
            for (Map<String,Object> categoryMap:categoryList){
                Map<String,Object> map2 = new HashMap<>();
                map2.put("categoryCode",categoryMap.get("categoryCode"));
//                判断该编码是否已经存在于list中
                map2.put("correlationStrength",0.01);
                map2.put("categoryId",categoryId);
                list.add(map2);
            }
            j--;
        }
        Map<String,Object> map1 = new HashMap<>();
//        对list集合进行去重处理，对于分类编码一样的，将相关性强度增加
        for (Map<String, Object> stringObjectMap : list) {
            if (map1.containsKey(stringObjectMap.get("categoryCode"))){
//                当map1中已经存在对应的相关强度，则将相关性强度相加
                map1.put((String) stringObjectMap.get("categoryCode"),(Double)map1.get((String) stringObjectMap.get("categoryCode"))+(Double)stringObjectMap.get("correlationStrength"));
            }else{
//                当map1中还未存在对应的相关强度，则直接增加
                map1.put((String) stringObjectMap.get("categoryCode"),stringObjectMap.get("correlationStrength"));
            }
        }
        return map1;
    }

    @Override
    public List<Map<String, Object>> getCategoryNameList() {
        return categoryDao.getCategoryNameList();
    }
}