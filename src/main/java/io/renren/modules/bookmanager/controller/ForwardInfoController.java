package io.renren.modules.bookmanager.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import io.renren.modules.bookmanager.service.LibraryInfoService;
import io.renren.modules.sys.service.SysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.bookmanager.entity.ForwardInfoEntity;
import io.renren.modules.bookmanager.service.ForwardInfoService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-04 16:10:07
 */
@RestController
@RequestMapping("bookmanager/forwardinfo")
public class ForwardInfoController {
    @Autowired
    private ForwardInfoService forwardInfoService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private LibraryInfoService libraryInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("bookmanager:forwardinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = forwardInfoService.queryPage(params);
//        根据page中的list查询对应的读者名和图书馆名
        List<ForwardInfoEntity> list = (List<ForwardInfoEntity>) page.getList();
//        创建一个新的list用来接收处理之后的数据
        List<Map<String,Object>> list1 = new ArrayList<>();
//        遍历list
        for(ForwardInfoEntity forwardInfoEntity:list){
//            判断当前数据是否已经逻辑删除
            if (forwardInfoEntity.getDeleted() == 0){
                HashMap map = new HashMap();
                Long userId = forwardInfoEntity.getUserId();
//            通过userId获取读者的详细信息，并将其存储到map集合中
                Map<String,Object> userMap = sysUserService.getUserNameById(userId);
                map.put("userName",userMap.get("userName"));
                map.put("email",userMap.get("email"));
                map.put("mobile",userMap.get("mobile"));
                Long libraryId = forwardInfoEntity.getLibraryId();
//            通过图书馆Id获取图书馆的详细信息，并将其存储到map中
                Map<String,Object> libraryMap = libraryInfoService.getLibraryNameById(libraryId);
                map.put("libraryName",libraryMap.get("libraryName"));
                map.put("address",libraryMap.get("address"));
                map.put("forwardCode",forwardInfoEntity.getForwardCode());
                map.put("insertName",forwardInfoEntity.getInsertName());
                map.put("insertTime",forwardInfoEntity.getInsertTime());
                map.put("forwardId",forwardInfoEntity.getForwardId());
                list1.add(map);
            }
        }
        page.setList(list1);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{forwardId}")
    @RequiresPermissions("bookmanager:forwardinfo:info")
    public R info(@PathVariable("forwardId") Long forwardId){
		ForwardInfoEntity forwardInfo = forwardInfoService.getById(forwardId);

        return R.ok().put("forwardInfo", forwardInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("bookmanager:forwardinfo:save")
    public R save(@RequestBody ForwardInfoEntity forwardInfo){
//        根据当前时间自动编译代码
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
        String dates = format.format(new Date());
//        使用random产生随机数
        Random random = new Random();
        int i = random.nextInt(1000);
        String code = dates+i;
        forwardInfo.setForwardCode(code);
        forwardInfo.setDeleted((long) 0);
        forwardInfo.setInsertTime(new Date());
		forwardInfoService.save(forwardInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("bookmanager:forwardinfo:update")
    public R update(@RequestBody ForwardInfoEntity forwardInfo){
        forwardInfo.setUpdateName("admin");
        forwardInfo.setUpdateTime(new Date());
		forwardInfoService.updateById(forwardInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("bookmanager:forwardinfo:delete")
    public R delete(@RequestBody Long[] forwardIds){
//        逻辑删除对应的预约记录
        for (Long forwardId:Arrays.asList(forwardIds)){
//            调用修改接口
            ForwardInfoEntity forwardInfo = new ForwardInfoEntity();
            forwardInfo.setForwardId(forwardId);
            forwardInfo.setDeleted((long) 1);
            forwardInfoService.updateById(forwardInfo);
        }

        return R.ok();
    }

//    根据app端传过来的userId获取当前用户的借记卡信息
    @RequestMapping("/getForwardInfoByUserId")
    public R getForwardInfoByUserId(@RequestParam Integer userId){
        List<Map<String,Object>> list = forwardInfoService.getForwardInfoByUserId(userId);
        Map<String,Object> map = new HashMap<>();
        map.put("list",list);
        return R.ok(map);
    }
}
