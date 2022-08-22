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

import io.renren.modules.bookmanager.entity.BookrackInfoEntity;
import io.renren.modules.bookmanager.service.BookrackInfoService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author hujh
 * @email 1942698741@qq.com
 * @date 2022-04-14 17:56:38
 */
@RestController
@RequestMapping("bookmanager/bookrackinfo")
public class BookrackInfoController {
    @Autowired
    private BookrackInfoService bookrackInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("bookmanager:bookrackinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = bookrackInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{bookrackId}")
    @RequiresPermissions("bookmanager:bookrackinfo:info")
    public R info(@PathVariable("bookrackId") Long bookrackId){
		BookrackInfoEntity bookrackInfo = bookrackInfoService.getById(bookrackId);

        return R.ok().put("bookrackInfo", bookrackInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("bookmanager:bookrackinfo:save")
    public R save(@RequestBody BookrackInfoEntity bookrackInfo){
		bookrackInfoService.save(bookrackInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("bookmanager:bookrackinfo:update")
    public R update(@RequestBody BookrackInfoEntity bookrackInfo){
		bookrackInfoService.updateById(bookrackInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("bookmanager:bookrackinfo:delete")
    public R delete(@RequestBody Long[] bookrackIds){
		bookrackInfoService.removeByIds(Arrays.asList(bookrackIds));

        return R.ok();
    }

}
