package com.MyReact.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("index")
public class IndexController {
	@GetMapping("default")
	public ModelAndView load(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView modelAndView = new ModelAndView("/index");
		List<Object> weather = new ArrayList<>();

		Map<String, String> t1 = new HashMap<>();
		t1.put("date", "2019-05-28");
		t1.put("temp", "23度");
		weather.add(t1);

		Map<String, String> t2 = new HashMap<>();
		t2.put("date", "2019-05-29");
		t2.put("temp", "24度");
		weather.add(t2);

		Map<String, String> t3 = new HashMap<>();
		t3.put("date", "2019-05-30");
		t3.put("temp", "20度");
		weather.add(t3);

		Map<String, String> t4 = new HashMap<>();
		t4.put("date", "2019-05-31");
		t4.put("temp", "22度");
		weather.add(t4);
		req.setAttribute("weather", weather);

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User principal = (User) authentication.getPrincipal();
		req.setAttribute("username", principal.getUsername());
		return modelAndView;
	}
}
