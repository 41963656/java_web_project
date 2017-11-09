package org.webProject.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webProject.test.orm.AbstractUser;
import org.webProject.test.orm.base.User;
import org.webProject.test.orm.mapper.UserMapper;
import org.webProject.test.service.IUserService;
import org.webProject.test.service.po.UserPO;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public void addSystemUser(String loginName, String loginPwd) {
		User user = new User();
		user.setLoginName(loginName);
		user.setLoginPwd(loginPwd);
		// 用户类型 1 管理员 2 普通用户
		user.setTypeId(1);
		userMapper.add(user);
	}

	@Override
	public void addNormalUser(String loginName, String loginPwd) {
		User user = new User();
		user.setLoginName(loginName);
		user.setLoginPwd(loginPwd);
		// 用户类型 1 管理员 2 普通用户
		user.setTypeId(2);
		userMapper.add(user);
	}

	@Override
	public AbstractUser getAbstractUserById(int userId) {
		User user = userMapper.get(userId);
		if (user != null) {
			UserPO po = new UserPO(this);
			po.copyFrom(user);
			return po;
		}
		return null;
	}

	@Override
	public User getUserById(int userId) {
		return userMapper.get(userId);
	}

	@Override
	public void updateUser(int userId, String loginName, String loginPwd) {
		// 先根据用户Id查询用户对象
		User user = userMapper.get(userId);
		if (user != null) {
			user.setLoginName(loginName);
			user.setLoginPwd(loginPwd);
			// 修改用户
			userMapper.update(user);
		}
	}

	@Override
	public int deleteUser(int userId) {
		return userMapper.delete(userId);
	}

	public String findTypeName(int typeId) {
		if (typeId == 1) {
			return "系统管理员";
		} else {
			return "普通用户";
		}
	}
}
