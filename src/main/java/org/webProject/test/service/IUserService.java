package org.webProject.test.service;

import org.webProject.test.orm.AbstractUser;
import org.webProject.test.orm.base.User;

public interface IUserService {
	// 添加系统管理员
	void addSystemUser(String loginName, String loginPwd);

	// 添加普通用户
	void addNormalUser(String loginName, String loginPwd);

	// 根据用户Id查询抽象用户
	AbstractUser getAbstractUserById(int userId);

	// 根据用户Id查询用户
	User getUserById(int userId);

	// 修改用户信息
	void updateUser(int userId, String loginName, String loginPwd);

	// 根据用户Id删除用户
	int deleteUser(int userId);

	String findTypeName(int typeId);
}
