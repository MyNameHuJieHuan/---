package io.renren.modules.bookmanager.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.bookmanager.entity.ClassifyEntity;
import io.renren.modules.bookmanager.service.ClassifyService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-04 11:55:06
 */
@RestController
@RequestMapping("bookmanager/classify")
public class ClassifyController {
    @Autowired
    private ClassifyService classifyService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("bookmanager:classify:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = classifyService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{classifyId}")
    @RequiresPermissions("bookmanager:classify:info")
    public R info(@PathVariable("classifyId") Long classifyId){
		ClassifyEntity classify = classifyService.getById(classifyId);

        return R.ok().put("classify", classify);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("bookmanager:classify:save")
    public R save(@RequestBody ClassifyEntity classify){
        classify.setDeleted((long) 0);
        classify.setInsertName("admin");
        classify.setInsertTime(new Date());
		classifyService.save(classify);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("bookmanager:classify:update")
    public R update(@RequestBody ClassifyEntity classify){
		classifyService.updateById(classify);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("bookmanager:classify:delete")
    public R delete(@RequestBody Long[] classifyIds){
		classifyService.removeByIds(Arrays.asList(classifyIds));

        return R.ok();
    }

//    获取所有的类别
    @RequestMapping("/getClassifyNameList")
    public R getClassifyNameList(@RequestParam Map<String, Object> params){
        List<Map<String,Object>> list = classifyService.getClassifyNameList();
        return R.ok().put("list", list);
    }
}
