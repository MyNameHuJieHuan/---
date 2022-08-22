package io.renren.modules.bookmanager.controller;

import java.math.BigDecimal;
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

import io.renren.modules.bookmanager.entity.LibraryInfoEntity;
import io.renren.modules.bookmanager.service.LibraryInfoService;
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
@RequestMapping("bookmanager/libraryinfo")
public class LibraryInfoController {
    @Autowired
    private LibraryInfoService libraryInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("bookmanager:libraryinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = libraryInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{libraryId}")
    @RequiresPermissions("bookmanager:libraryinfo:info")
    public R info(@PathVariable("libraryId") Long libraryId){
		LibraryInfoEntity libraryInfo = libraryInfoService.getById(libraryId);

        return R.ok().put("libraryInfo", libraryInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("bookmanager:libraryinfo:save")
    public R save(@RequestBody LibraryInfoEntity libraryInfo){
//        设置逻辑删除状态为0
        libraryInfo.setDeleted((long) 0);
        libraryInfo.setInsertTime(new Date());
//        设置新增时间以及新增联系人
		libraryInfoService.save(libraryInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("bookmanager:libraryinfo:update")
    public R update(@RequestBody LibraryInfoEntity libraryInfo){
		libraryInfoService.updateById(libraryInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("bookmanager:libraryinfo:delete")
    public R delete(@RequestBody Long[] libraryIds){
		libraryInfoService.removeByIds(Arrays.asList(libraryIds));

        return R.ok();
    }

    //    获取所有的类别
    @RequestMapping("/getLibraryNameList")
    public R getLibraryNameList(@RequestParam Map<String, Object> params){
        List<Map<String,Object>> list = libraryInfoService.getLibraryNameList();
        return R.ok().put("list", list);
    }
}
