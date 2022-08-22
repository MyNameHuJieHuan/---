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

import io.renren.modules.bookmanager.entity.BookRecommendEntity;
import io.renren.modules.bookmanager.service.BookRecommendService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author hujh
 * @email 1942698741@qq.com
 * @date 2022-03-09 17:20:33
 */
@RestController
@RequestMapping("bookmanager/bookrecommend")
public class BookRecommendController {
    @Autowired
    private BookRecommendService bookRecommendService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("bookmanager:bookrecommend:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = bookRecommendService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{recommendId}")
    @RequiresPermissions("bookmanager:bookrecommend:info")
    public R info(@PathVariable("recommendId") Long recommendId){
		BookRecommendEntity bookRecommend = bookRecommendService.getById(recommendId);

        return R.ok().put("bookRecommend", bookRecommend);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("bookmanager:bookrecommend:save")
    public R save(@RequestBody BookRecommendEntity bookRecommend){
		bookRecommendService.save(bookRecommend);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("bookmanager:bookrecommend:update")
    public R update(@RequestBody BookRecommendEntity bookRecommend){
		bookRecommendService.updateById(bookRecommend);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("bookmanager:bookrecommend:delete")
    public R delete(@RequestBody Long[] recommendIds){
		bookRecommendService.removeByIds(Arrays.asList(recommendIds));

        return R.ok();
    }

}
