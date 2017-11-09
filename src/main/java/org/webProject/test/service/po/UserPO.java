package org.webProject.test.service.po;

import org.webProject.test.orm.AbstractUser;
import org.webProject.test.orm.base.User;
import org.webProject.test.service.IUserService;

public class UserPO extends AbstractUser {
	private final IUserService userService;

	public UserPO(IUserService userService) {
		this.userService = userService;
	}

	public UserPO copyFrom(User obj) {
		this.setId(obj.getId());
		this.setLoginName(obj.getLoginName());
		this.setLoginPwd(obj.getLoginPwd());
		this.setTypeId(obj.getTypeId());
		return this;
	}

	@Override
	public String findTypeName() {
		return userService.findTypeName(this.getTypeId());
	}
}
