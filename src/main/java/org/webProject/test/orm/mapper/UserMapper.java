package org.webProject.test.orm.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.webProject.test.orm.base.User;

@Component("UserMapper")
public interface UserMapper {

	public void add(User user);

	public User get(@Param("id") int id);

	public void update(User user);

	public int delete(@Param("id") int id);

}
