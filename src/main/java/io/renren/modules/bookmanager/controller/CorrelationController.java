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

import io.renren.modules.bookmanager.entity.CorrelationEntity;
import io.renren.modules.bookmanager.service.CorrelationService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author hujh
 * @email 1942698741@qq.com
 * @date 2022-04-08 20:24:17
 */
@RestController
@RequestMapping("bookmanager/correlation")
public class CorrelationController {
    @Autowired
    private CorrelationService correlationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("bookmanager:correlation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = correlationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{correlationId}")
    @RequiresPermissions("bookmanager:correlation:info")
    public R info(@PathVariable("correlationId") Long correlationId){
		CorrelationEntity correlation = correlationService.getById(correlationId);

        return R.ok().put("correlation", correlation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("bookmanager:correlation:save")
    public R save(@RequestBody CorrelationEntity correlation){
		correlationService.save(correlation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("bookmanager:correlation:update")
    public R update(@RequestBody CorrelationEntity correlation){
		correlationService.updateById(correlation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("bookmanager:correlation:delete")
    public R delete(@RequestBody Long[] correlationIds){
		correlationService.removeByIds(Arrays.asList(correlationIds));

        return R.ok();
    }

}
