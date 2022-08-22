package io.renren.modules.bookmanager.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.bookmanager.entity.SubjectEntity;
import io.renren.modules.bookmanager.service.SubjectService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author hujh
 * @email 1942698741@qq.com
 * @date 2022-04-08 20:24:18
 */
@RestController
@RequestMapping("bookmanager/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("bookmanager:subject:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = subjectService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{subjectId}")
    @RequiresPermissions("bookmanager:subject:info")
    public R info(@PathVariable("subjectId") Integer subjectId){
		SubjectEntity subject = subjectService.getById(subjectId);

        return R.ok().put("subject", subject);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("bookmanager:subject:save")
    public R save(@RequestBody SubjectEntity subject){
		subjectService.save(subject);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("bookmanager:subject:update")
    public R update(@RequestBody SubjectEntity subject){
		subjectService.updateById(subject);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("bookmanager:subject:delete")
    public R delete(@RequestBody Integer[] subjectIds){
		subjectService.removeByIds(Arrays.asList(subjectIds));

        return R.ok();
    }

}
