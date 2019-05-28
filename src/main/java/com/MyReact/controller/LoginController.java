package com.MyReact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("login")
public class LoginController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("default")
	public ModelAndView load() {
		ModelAndView modelAndView = new ModelAndView("/login"); //设置对应JSP的模板文件
		return modelAndView;
	}

	@PostMapping("check")
	@ResponseBody
	public void check() {
		
	}

	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}

}
