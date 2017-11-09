package org.webProject.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.webProject.test.orm.base.User;
import org.webProject.test.service.IUserService;

@Controller
public class UserController {
	private int i;
	@Autowired
	private IUserService userService;

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/user/index")
	public String index(HttpServletRequest request, HttpServletResponse response) {
		i++;
		User user = userService.getUserById(1);
		if (user != null) {
			System.out.println("user name = " + user.getLoginName());
		}
		System.out.println("wating 3sec" + this.toString() + "-" + i);
		try {
			Thread.sleep(3000l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("over");
		request.setAttribute("count", i);
		return "jsp/user/user";
	}

}
