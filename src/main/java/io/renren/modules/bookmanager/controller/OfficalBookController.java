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

import io.renren.modules.bookmanager.entity.OfficalBookEntity;
import io.renren.modules.bookmanager.service.OfficalBookService;
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
@RequestMapping("bookmanager/officalbook")
public class OfficalBookController {
    @Autowired
    private OfficalBookService officalBookService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("bookmanager:officalbook:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = officalBookService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("bookmanager:officalbook:info")
    public R info(@PathVariable("id") Integer id){
		OfficalBookEntity officalBook = officalBookService.getById(id);

        return R.ok().put("officalBook", officalBook);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("bookmanager:officalbook:save")
    public R save(@RequestBody OfficalBookEntity officalBook){
		officalBookService.save(officalBook);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("bookmanager:officalbook:update")
    public R update(@RequestBody OfficalBookEntity officalBook){
		officalBookService.updateById(officalBook);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("bookmanager:officalbook:delete")
    public R delete(@RequestBody Integer[] ids){
		officalBookService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
