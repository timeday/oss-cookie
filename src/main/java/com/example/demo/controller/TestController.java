package com.example.demo.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 根据浏览器机制cookie实现跨域
 */
@Controller
public class TestController {
	
	@RequestMapping("/oss")
	public String test(HttpServletRequest request, HttpServletResponse response){

		return "index";
	}
	
}
