package org.webProject.test.orm;

import org.webProject.test.orm.base.User;

public abstract class AbstractUser extends User {
	// 获取当前用户所属分类名称
	public abstract String findTypeName();
}
