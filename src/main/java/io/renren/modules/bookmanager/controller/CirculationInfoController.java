package io.renren.modules.bookmanager.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import io.renren.modules.bookmanager.entity.ForwardInfoEntity;
import io.renren.modules.bookmanager.service.BookInfoService;
import io.renren.modules.sys.service.SysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.bookmanager.entity.CirculationInfoEntity;
import io.renren.modules.bookmanager.service.CirculationInfoService;
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
@RequestMapping("bookmanager/circulationinfo")
public class CirculationInfoController {
    @Autowired
    private CirculationInfoService circulationInfoService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private BookInfoService bookInfoService;
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("bookmanager:circulationinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = circulationInfoService.queryPage(params);
        //        根据page中的list查询对应的读者名和图书馆名
        List<CirculationInfoEntity> list = (List<CirculationInfoEntity>) page.getList();
//        创建一个新的list用来接收处理之后的数据
        List<Map<String,Object>> list1 = new ArrayList<>();
//        处理时间格式
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        遍历list
        for(CirculationInfoEntity circulationInfoEntity:list) {
                HashMap map = new HashMap();
                Long userId = circulationInfoEntity.getUserId();
//            通过userId获取读者的详细信息，并将其存储到map集合中
                Map<String, Object> userMap = sysUserService.getUserNameById(userId);
//                判断当前账号获取到的账号信息是否与用户一样，获取账号为管理员或者超级管理员
                map.put("userName",userMap.get("userName"));
                map.put("email",userMap.get("email"));
                map.put("mobile",userMap.get("mobile"));
                Long bookId = circulationInfoEntity.getBookId();
//            通过bookId获取读者的详细信息，并将其存储到map集合中
                Map<String, Object> bookMap = bookInfoService.getBookNameById(bookId);
                map.put("bookName",bookMap.get("bookName"));
                map.put("bookPress",bookMap.get("bookPress"));
                map.put("bookCategory",bookMap.get("bookCategory"));
                map.put("libraryName",bookMap.get("libraryName"));
//                判断借还书记录状态
                if (circulationInfoEntity.getStatus()==0){
                    map.put("status","借书");
                }else if(circulationInfoEntity.getStatus() == 1){
                    map.put("status","还书");
                }
//                处理借还书时间
                map.put("borrowTime",format.format(circulationInfoEntity.getBorrowTime()));
                map.put("returnTime",format.format(circulationInfoEntity.getReturnTime()));
                map.put("insertName",circulationInfoEntity.getInsertName());
                map.put("insertTime",circulationInfoEntity.getInsertTime());
                list1.add(map);
        }
        page.setList(list1);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{circulationId}")
    @RequiresPermissions("bookmanager:circulationinfo:info")
    public R info(@PathVariable("circulationId") Long circulationId){
		CirculationInfoEntity circulationInfo = circulationInfoService.getById(circulationId);

        return R.ok().put("circulationInfo", circulationInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("bookmanager:circulationinfo:save")
    public R save(@RequestBody CirculationInfoEntity circulationInfo){
        circulationInfo.setDeleted((long) 0);
        circulationInfo.setInsertName("admin");
        circulationInfo.setInsertTime(new Date());
		circulationInfoService.save(circulationInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("bookmanager:circulationinfo:update")
    public R update(@RequestBody CirculationInfoEntity circulationInfo){
		circulationInfoService.updateById(circulationInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("bookmanager:circulationinfo:delete")
    public R delete(@RequestBody Long[] circulationIds){
		circulationInfoService.removeByIds(Arrays.asList(circulationIds));

        return R.ok();
    }

}
