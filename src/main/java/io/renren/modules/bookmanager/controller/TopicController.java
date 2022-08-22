package io.renren.modules.bookmanager.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.bookmanager.entity.TopicEntity;
import io.renren.modules.bookmanager.service.TopicService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author hujh
 * @email 1942698741@qq.com
 * @date 2022-04-26 19:18:59
 */
@RestController
@RequestMapping("bookmanager/topic")
public class TopicController {
    @Autowired
    private TopicService topicService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("bookmanager:topic:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = topicService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{topicId}")
    @RequiresPermissions("bookmanager:topic:info")
    public R info(@PathVariable("topicId") Long topicId){
		TopicEntity topic = topicService.getById(topicId);

        return R.ok().put("topic", topic);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("bookmanager:topic:save")
    public R save(@RequestBody TopicEntity topic){
        topic.setDeleted(0);
        topic.setInsertName("admin");
        topic.setInsertTime(new Date());
		topicService.save(topic);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("bookmanager:topic:update")
    public R update(@RequestBody TopicEntity topic){
		topicService.updateById(topic);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("bookmanager:topic:delete")
    public R delete(@RequestBody Long[] topicIds){
		topicService.removeByIds(Arrays.asList(topicIds));

        return R.ok();
    }

}
