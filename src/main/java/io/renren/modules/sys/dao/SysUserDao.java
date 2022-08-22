/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.sys.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 系统用户
 *
 * @author Mark sunlightcs@gmail.com
 */
@Mapper
public interface SysUserDao extends BaseMapper<SysUserEntity> {
	
	/**
	 * 查询用户的所有权限
	 * @param userId  用户ID
	 */
	List<String> queryAllPerms(Long userId);
	
	/**
	 * 查询用户的所有菜单ID
	 */
	List<Long> queryAllMenuId(Long userId);
	
	/**
	 * 根据用户名，查询系统用户
	 */
	SysUserEntity queryByUserName(String username);
//	根据读者ID，获取读者相关信息
    Map<String,Object> getUserNameById(Long userId);
//	获取所有的读者信息
    List<Map<String, Object>> getReaderNameList();
//	根据账号信息获取该账号的权限
    Map<String,Object> getUserRoleByUserName(String userName);
//	判断当前数据库中是否存在对应的用户名
    int getIsHasUserName(String userName);
//	根据用户名获取相关用户信息
	Map<String, Object> getUserByUserName(String userName);
//	获取数据库中的最大userId值
	long getMaxUserId();
//	根据userName判断该读者在我们系统不，并且他的借记卡等级是多少，能借多少书
	Map<String, Object> getReaderByUserName(String user);
}
