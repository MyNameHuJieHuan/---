package io.renren.modules.bookmanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.bookmanager.dao.BookAddressDao;
import io.renren.modules.bookmanager.entity.BookAddressEntity;
import io.renren.modules.bookmanager.service.BookAddressService;


@Service("bookAddressService")
public class BookAddressServiceImpl extends ServiceImpl<BookAddressDao, BookAddressEntity> implements BookAddressService {
    @Autowired
    private BookAddressDao bookAddressDao;

    @Override
    public List<Map<String, Object>> queryPage(Map<String, Object> params) {
        return bookAddressDao.getBookAddressList();
    }

    @Override
    public Map<String, Object> getBookAddress(Map<String, Object> params) {
        //        对cateCode进行拆分处理，得到相对应的类别
        String categoryCode = (String) params.get("classifyName");
        String [] categoryCodes = categoryCode.split("-");
//        遍历codes
        for (int i=0;i<categoryCodes.length;i++){
            //        取出前端传过来的类别编码
            long classifyId = Long.valueOf(categoryCodes[i]);
            long libraryId = Long.valueOf((String)params.get("libraryName"));
//        获取当前匹配的所有书架空闲位置的可能性
            Map<String,Object> maps = new HashMap<>();
            maps.put("classifyId",classifyId);
            maps.put("libraryId",libraryId);
            Map<String,Object> map = bookAddressDao.getBookAddress(maps);
            if (!map.equals(null)){
//                当map不为空时结束
                return map;
            }
        }
        return null;
    }
}