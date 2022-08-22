/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.modules.app.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.exception.RRException;
import io.renren.common.validator.Assert;
import io.renren.modules.app.dao.UserDao;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.form.LoginForm;
import io.renren.modules.app.form.RegisterForm;
import io.renren.modules.app.service.UserService;
import io.renren.modules.bookmanager.entity.DebitInfoEntity;
import io.renren.modules.bookmanager.service.DebitInfoService;
import io.renren.modules.sys.dao.SysUserDao;
import io.renren.modules.sys.dao.SysUserRoleDao;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.entity.SysUserRoleEntity;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {
	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	@Autowired
	private DebitInfoService debitInfoService;

	@Override
	public UserEntity queryByMobile(String mobile) {
		return baseMapper.selectOne(new QueryWrapper<UserEntity>().eq("mobile", mobile));
	}

	@Override
	public long login(LoginForm form) {
		UserEntity user = queryByMobile(form.getUserName());
		Assert.isNull(user, "用户名或密码错误");

		//密码错误
		if(!user.getPassword().equals(DigestUtils.sha256Hex(form.getPassword()))){
			throw new RRException("用户名或密码错误");
		}

		return user.getUserId();
	}

	@Override
	public int insertForm(RegisterForm form) {
		//        对于从app注册的用户默认为读者
		//表单校验
		int i =0;
//        获取当前用户Id中的最大值
		long userId = sysUserDao.getMaxUserId();
//        创建用户实体类
		SysUserEntity sysUserEntity = new SysUserEntity();
		sysUserEntity.setUsername(form.getUserName());
//        使用Sha256加密密码
		//sha256加密
		String salt = RandomStringUtils.randomAlphanumeric(20);
		sysUserEntity.setPassword(new Sha256Hash(form.getPassword(), salt).toHex());
		sysUserEntity.setSalt(salt);
		sysUserEntity.setStatus(2);
		sysUserEntity.setCreateUserId((long)1);
		sysUserEntity.setMobile(form.getMobile());
		sysUserEntity.setEmail(form.getEmail());
		sysUserEntity.setCreateTime(new Date());
		i+=sysUserDao.insert(sysUserEntity);
//        创建角色用户中间表实体类
		SysUserRoleEntity sysUserRoleEntity = new SysUserRoleEntity();
		sysUserRoleEntity.setUserId(userId);
		sysUserRoleEntity.setRoleId((long) 2);
		i+=sysUserRoleDao.insert(sysUserRoleEntity);
//		初始化借记卡
		DebitInfoEntity debitInfoEntity = new DebitInfoEntity();
		debitInfoEntity.setUserId(userId);
		i+=debitInfoService.insertDebitInfo(debitInfoEntity);
		return i;
	}
}
