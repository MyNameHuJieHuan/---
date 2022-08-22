/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.modules.app.controller;


import io.renren.common.utils.R;
import io.renren.modules.app.annotation.Login;
import io.renren.modules.app.annotation.LoginUser;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.bookmanager.entity.ForwardInfoEntity;
import io.renren.modules.bookmanager.service.*;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * APP测试接口
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
@RequestMapping("/app")
@Api("APP测试接口")
public class AppTestController {
    @Autowired
    private LibraryInfoService libraryInfoService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private BookInfoService bookInfoService;
    @Autowired
    private OfficalBookService officalBookService;
    @Autowired
    private ForwardInfoService forwardInfoService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private BookrackInfoService bookrackInfoService;
    @Autowired
    private TopicService topicService;
    @Autowired
    private CorrelationService correlationService;
    @Autowired
    private CirculationInfoService circulationInfoService;

    @Login
    @GetMapping("userInfo")
    @ApiOperation("获取用户信息")
    public R userInfo(@LoginUser UserEntity user){
        return R.ok().put("user", user);
    }

    @Login
    @GetMapping("userId")
    @ApiOperation("获取用户ID")
    public R userInfo(@RequestAttribute("userId") Integer userId){
        return R.ok().put("userId", userId);
    }

    @GetMapping("notToken")
    @ApiOperation("忽略Token验证测试")
    public R notToken(){
        return R.ok().put("msg", "无需token也能访问。。。");
    }

    @PostMapping("getLibraryNameList")
    @ApiOperation(value = "获取图书馆名")
    public R getLibraryNameList(){
        List<Map<String,Object>> list = libraryInfoService.getLibraryNameList();
        return R.ok().put("list", list);
    }

    @PostMapping("insertForward")
    @ApiOperation(value = "新增预约记录")
    public R insertForward(@RequestBody(required = false) Map<String,Object> map) throws ParseException {
        SysUserEntity user = sysUserService.getById(Long.valueOf((Integer)map.get("userId")));
//        创建预约实体类
        ForwardInfoEntity forwardInfoEntity = new ForwardInfoEntity();
        //        根据当前时间自动编译代码
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dates = format.format(new Date());
//        使用random产生随机数
        Random random = new Random();
        int i = random.nextInt(1000);
        String code = dates+i;
        forwardInfoEntity.setForwardCode(code);
        forwardInfoEntity.setDeleted((long) 0);
        forwardInfoEntity.setInsertTime(new Date());
        forwardInfoEntity.setUserId(Long.valueOf((Integer)map.get("userId")));
        forwardInfoEntity.setLibraryId(Long.valueOf((Integer)map.get("libraryId")));
//        将字符串格式的时间转换为时间格式的时间
        forwardInfoEntity.setForwardTime(format2.parse((String)map.get("forwardTime")));
        forwardInfoEntity.setInsertName(user.getUsername());
        boolean j =forwardInfoService.save(forwardInfoEntity);
        return R.ok().put("新增结果",j);
    }

    @PostMapping("getMessageInfoByUserId")
    @ApiOperation(value = "查询所有与用户联系过的联系人")
    public R getMessageInfoByUserId(@RequestParam(value = "userId") Integer userId){

        List<Map<String,Object>> list = messageService.getMessageInfo(userId);
        return R.ok().put("list", list);
    }

    @PostMapping("getMessageDetail")
    @ApiOperation(value = "查询两个人的具体消息")
    public R getMessageDetail(@RequestBody Map<String,Object> map){

        List<Map<String,Object>> list = messageService.getMessageDetail(map);
        return R.ok().put("list", list);
    }

    @PostMapping("insertMessage")
    @ApiOperation(value = "新增消息")
    public R insertMessage(@RequestBody Map<String,Object> map){

        int result = messageService.insertMessage(map);
        return R.ok();
    }

    @PostMapping("getBookInfo")
    @ApiOperation(value = "根据ISBN编码查询图书信息")
    public R getBookInfo(@RequestParam(value = "ISBNCode") String ISBNCode){

        Map<String,Object> map = officalBookService.getBookInfo(ISBNCode);
        return R.ok(map);
    }
    @PostMapping("insertBookInfo")
    @ApiOperation(value = "新增图书信息到图书馆的数据库中")
    public R insertBookInfo(@RequestBody(required = false) Map<String,Object> map) throws ParseException {
        int i = bookInfoService.insertBookInfo(map);
        return R.ok();
    }

    @PostMapping("selectBookList")
    @ApiOperation(value = "搜索框搜索书籍相关信息")
    public R selectBookList(@RequestBody Map<String,Object> map){

        List<Map<String,Object>> list = bookInfoService.selectBookList(map);
        if(list == null){
            return R.error("查无此书");
        }
        return R.ok().put("list", list);
    }

    @PostMapping("getSectionalizerList")
    @ApiOperation(value = "获取分段器中的数据")
    public R getSectionalizerList(@RequestBody Map<String,Object> map){
        Map<String,List<Map<String,Object>>> newMap = bookInfoService.getSectionalizerList(map);
        Map<String,Map<String,List<Map<String,Object>>>> newMap2 = new HashMap<>();
        newMap2.put("content",newMap);
        return R.okNewMap(newMap2);
    }

    @PostMapping("getBookrackList")
    @ApiOperation(value = "获取书架相关信息")
    public R getBookrackList(@RequestBody Map<String,Object> map){
        List<Map<String,Object>> list = bookrackInfoService.getBookrackList(map);
        return R.ok().put("list", list);
    }

//    根据用户和书籍Id获取某一个本的相关信息
    @PostMapping("getBookById")
    @ApiOperation(value = "获取书籍相关信息")
    public R getBookById(@RequestBody Map<String,Object> map){
        Map<String,Object> map1 = bookInfoService.getBookById(map);
        return R.ok(map1);
    }

    //    根据用户和书籍Id获取某一个本的相关信息
    @PostMapping("addBookInBookRack")
    @ApiOperation(value = "添加书籍到书架中")
    public R addBookInBookRack(@RequestBody Map<String,Object> map){
        Integer status = bookInfoService.addBookInBookRack(map);
        Map<String,Object> newMap = new HashMap<>();
        newMap.put("status",status);
        return R.ok(newMap);
    }

//    获取题目相关信息
    @PostMapping("getSubjectList")
    @ApiOperation(value = "获取题目相关信息")
    public R getSubjectList(@RequestBody Map<String,Object> map){
        List<Map<String,Object>> list = topicService.getSubjectList();
        return R.ok().put("list",list);
    }

    @PostMapping("insetCorrelation")
    @ApiOperation(value = "根据题目新增相关性强度")
    public R insetCorrelation(@RequestBody Map<String,Object> map){
        int result = correlationService.insetCorrelation(map);
        if (result == 0) {
            return R.ok();
        }
        return R.error();
    }

//    根据图书编码获取该图书的信息，并判断该书是处于什么状态（借书还是还书）
    @PostMapping("getCirculationInfo")
    @ApiOperation(value = "根据图书编码获取该图书的信息，并判断该书是处于什么状态（借书还是还书）")
    public R getCirculationInfo(@RequestParam(value = "ISBNCode") String ISBNCode){
        Map<String,Object> map = circulationInfoService.getCirculationInfo(ISBNCode);
        if(map == null){
            return R.error();
        }
        return R.ok(map);
    }

    @PostMapping("insertCirculation")
    @ApiOperation(value = "新增借还记录")
    public R insertCirculation(@RequestBody Map<String,Object> map){
        int result = circulationInfoService.insertCirculation(map);
        if(result > 0){
            return R.ok();
        }else if(result == -1){
            return R.error("您的借记卡已经过期，请联系管理员");
        }else if(result == -2){
            return R.error("您的可借书余额已不足");
        }
        return R.error("新增借还记录失败");
    }

}
