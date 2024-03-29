package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//로그인
	@RequestMapping(value="/user/login", method= {RequestMethod.GET, RequestMethod.POST})
	public String login(HttpSession session, @ModelAttribute UserVo userVo) {
		System.out.println("UserController.login()"); /* 핸들러 매핑에 주소 잘 등록 됐니? */
		
		UserVo authUser = userService.exeLogin(userVo);
		
		
		session.setAttribute("authUser", authUser);
		return "redirect:/main"; /* dispatcherServlet 에게 시킴 */
	}
	
	//로그인폼
	@RequestMapping(value="/user/loginform", method= {RequestMethod.GET, RequestMethod.POST})
	public String loginForm() {
	
		
		System.out.println("UserController.loginForm()");
		
		return "/user/loginForm";
	}

}
