/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.modules.app.controller;


import io.renren.common.utils.R;
import io.renren.modules.app.form.LoginForm;
import io.renren.modules.app.service.UserService;
import io.renren.modules.app.utils.JwtUtils;
import io.renren.modules.bookmanager.service.DebitInfoService;
import io.renren.modules.bookmanager.service.ForwardInfoService;
import io.renren.modules.sys.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * APP登录授权
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
@RequestMapping("/app")
@Api("APP登录接口")
public class AppLoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private DebitInfoService debitInfoService;
    @Autowired
    private ForwardInfoService forwardInfoService;

    /**
     * 登录
     */
    @PostMapping("login")
    @ApiOperation("登录")
    public R login(@RequestBody LoginForm form){
//        根据用户名判断获取用户相关信息
        Map<String,Object> userMap = sysUserService.getUserByUserName(form.getUserName());
//        验证密码
        //账号不存在、密码错误
        if(userMap == null || !userMap.get("password").equals(new Sha256Hash(form.getPassword(), userMap.get("salt")).toHex())) {
            return R.error("账号或密码不正确");
        }
        //账号锁定
        if((Integer) userMap.get("status") == 0){
            return R.error("账号已被锁定,请联系管理员");
        }
        //生成token22
        String token = jwtUtils.generateToken((Long)userMap.get("userId"));

        userMap.put("token", token);
        userMap.put("expire", jwtUtils.getExpire());

        return R.ok(userMap);
    }

    //    根据app端传过来的userId获取当前用户的借记卡信息
    @PostMapping("getDebitInfoByUserId")
    public R getDebitInfoByUserId(@RequestParam(value = "userId") Integer userId){
//        long userId = (Long) mapValue.get("userId");
        Map<String,Object> map = debitInfoService.getDebitInfoByUserId(userId);
//        Map<String,Object> newMap = new HashMap<>();
//        newMap.put("map",map);
        return R.ok().put("map",map);
    }

    //    根据app端传过来的userId获取当前用户的预约记录信息
    @PostMapping("getForwardInfoByUserId")
    public R getForwardInfoByUserId(@RequestParam(value = "userId") Integer userId){
        List<Map<String,Object>> list = forwardInfoService.getForwardInfoByUserId(userId);
        Map<String,Object> map = new HashMap<>();
        map.put("list",list);
        return R.ok(map);
    }
}
