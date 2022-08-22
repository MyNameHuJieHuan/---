package io.renren.modules.bookmanager.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.bookmanager.entity.CategoryEntity;
import io.renren.modules.bookmanager.service.CategoryService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author hujh
 * @email 1942698741@qq.com
 * @date 2022-03-24 20:41:35
 */
@RestController
@RequestMapping("bookmanager/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("bookmanager:category:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = categoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{categoryId}")
    @RequiresPermissions("bookmanager:category:info")
    public R info(@PathVariable("categoryId") Long categoryId){
		CategoryEntity category = categoryService.getById(categoryId);

        return R.ok().put("category", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("bookmanager:category:save")
    public R save(@RequestBody CategoryEntity category){
        category.setInsertName("admin");
        category.setDeleted((long) 0);
        category.setInsertTime(new Date());
		categoryService.save(category);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("bookmanager:category:update")
    public R update(@RequestBody CategoryEntity category){
		categoryService.updateById(category);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("bookmanager:category:delete")
    public R delete(@RequestBody Long[] categoryIds){
		categoryService.removeByIds(Arrays.asList(categoryIds));

        return R.ok();
    }

    /**
     * 获取图书的所有分类信息
     * @return
     */
    @RequestMapping("/getCategoryList")
    public R getCategoryList(){
        List<Map<String,Object>> list = categoryService.getCategoryList();
        return R.ok().put("list",list);
    }

//    根据用户输入的图书分类链接，插入对应的分类
    @PostMapping("/insertCategory")
    public R insertCategory(@RequestParam(value = "category") String category){
        categoryService.insertCategory(category);
        return R.ok();
    }

    //    获取所有的类别
    @RequestMapping("/getCategoryNameList")
    public R getCategoryNameList(@RequestParam Map<String, Object> params){
        List<Map<String,Object>> list = categoryService.getCategoryNameList();
        return R.ok().put("list", list);
    }


}
