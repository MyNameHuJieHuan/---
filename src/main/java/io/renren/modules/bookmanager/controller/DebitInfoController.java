package io.renren.modules.bookmanager.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import io.renren.modules.bookmanager.entity.ForwardInfoEntity;
import io.renren.modules.sys.service.SysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.bookmanager.entity.DebitInfoEntity;
import io.renren.modules.bookmanager.service.DebitInfoService;
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
@RequestMapping("bookmanager/debitinfo")
public class DebitInfoController {
    @Autowired
    private DebitInfoService debitInfoService;
    @Autowired
    private SysUserService sysUserService;
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("bookmanager:debitinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = debitInfoService.queryPage(params);
        //        根据page中的list查询对应的读者名和图书馆名
        List<DebitInfoEntity> list = (List<DebitInfoEntity>) page.getList();
//        创建一个新的list用来接收处理之后的数据
        List<Map<String,Object>> list1 = new ArrayList<>();
//        遍历list
        for(DebitInfoEntity debitInfoEntity:list){
//            判断当前数据是否已经逻辑删除
            if (debitInfoEntity.getDeleted() == 0) {
                HashMap map = new HashMap();
                Long userId = debitInfoEntity.getUserId();
//            通过userId获取读者的详细信息，并将其存储到map集合中
                Map<String, Object> userMap = sysUserService.getUserNameById(userId);
                map.put("userName",userMap.get("userName"));
                map.put("email",userMap.get("email"));
                map.put("mobile",userMap.get("mobile"));
                map.put("debitValidity",debitInfoEntity.getDebitValidity());
                if (debitInfoEntity.getDebitValidity().getTime()<= new Date().getTime()){
                    debitInfoEntity.setStatus((long) 1);
                }
                if (debitInfoEntity.getStatus() == 0){
                    map.put("status","正常");
                }else{
                    map.put("status","停用");
                }
                map.put("debitId",debitInfoEntity.getDebitId());
                map.put("insertName",debitInfoEntity.getInsertName());
                map.put("insertTime",debitInfoEntity.getInsertTime());
                map.put("debitLevel",debitInfoEntity.getDebitLevel());
                map.put("debitCode",debitInfoEntity.getDebitCode());
                list1.add(map);
            }
        }
        page.setList(list1);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{debitId}")
    @RequiresPermissions("bookmanager:debitinfo:info")
    public R info(@PathVariable("debitId") Long debitId){
		DebitInfoEntity debitInfo = debitInfoService.getById(debitId);

        return R.ok().put("debitInfo", debitInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("bookmanager:debitinfo:save")
    public R save(@RequestBody DebitInfoEntity debitInfo){

		int i =debitInfoService.insertDebitInfo(debitInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("bookmanager:debitinfo:update")
    public R update(@RequestBody DebitInfoEntity debitInfo){
		debitInfoService.updateById(debitInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("bookmanager:debitinfo:delete")
    public R delete(@RequestBody Long[] debitIds){
		debitInfoService.removeByIds(Arrays.asList(debitIds));

        return R.ok();
    }
}
