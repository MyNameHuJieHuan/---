package io.renren.modules.bookmanager.controller;

import java.util.*;

import io.renren.modules.bookmanager.entity.BookInfoEntity;
import io.renren.modules.bookmanager.entity.CategoryEntity;
import io.renren.modules.bookmanager.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.bookmanager.entity.BookAddressEntity;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author hujh
 * @email sunlightcs@gmail.com
 * @date 2022-03-07 20:28:23
 */
@RestController
@RequestMapping("bookmanager/bookaddress")
public class BookAddressController {
    @Autowired
    private BookAddressService bookAddressService;
    @Autowired
    private LibraryInfoService libraryInfoService;
    @Autowired
    private ClassifyService classifyService;
    @Autowired
    private CategoryService categoryService;
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("bookmanager:bookaddress:list")
    public R list(@RequestParam Map<String, Object> params){
        List<Map<String,Object>> page = bookAddressService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{adressId}")
    @RequiresPermissions("bookmanager:bookaddress:info")
    public R info(@PathVariable("adressId") Long adressId){
		BookAddressEntity bookAddress = bookAddressService.getById(adressId);

        return R.ok().put("bookAddress", bookAddress);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("bookmanager:bookaddress:save")
    public R save(@RequestBody BookAddressEntity bookAddress){
        long number = 0;
//        设置默认的书架行数和列数分别为7层和15列
        for(int i =1;i<=7;i++){
            for (int j =1;j<=15;j++){
//                设置一个新的书架地址实体类进行接收
                BookAddressEntity bookAddressEntity = bookAddress;
                bookAddressEntity.setBookRow(String.valueOf(i));
                bookAddressEntity.setBookLine(String.valueOf(j));
                bookAddressEntity.setDeleted((long) 0);
                bookAddressEntity.setInsertTime(new Date());
                bookAddressEntity.setStatus(1);
                bookAddressEntity.setCategoryId(bookAddress.getCategoryId());
                number++;
                bookAddressEntity.setAddressCode(number);
//                获取当前书籍地址中的最大值
                bookAddressService.save(bookAddress);
            }
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("bookmanager:bookaddress:update")
    public R update(@RequestBody BookAddressEntity bookAddress){
		bookAddressService.updateById(bookAddress);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("bookmanager:bookaddress:delete")
    public R delete(@RequestBody Long[] adressIds){
		bookAddressService.removeByIds(Arrays.asList(adressIds));

        return R.ok();
    }

//    根据前端传过来的图书馆名和书籍类别名自动分别书籍存储地址
    @RequestMapping("/getBookAddress")
    public R getBookAddress(@RequestParam Map<String, Object> params) {

        if (bookAddressService.getBookAddress(params)==null){
            return R.error("不存在所对应的书架类别");
        }
        Map<String,Object> map = bookAddressService.getBookAddress(params);
        return R.ok().put("map",map);
    }
}
