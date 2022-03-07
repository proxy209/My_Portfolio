package com.org.kr.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TestController {

	@RequestMapping("/chatting.do")
	public ModelAndView SesssionTest(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("chatting");
		return mv; 
	}
	
	
	@RequestMapping("/logOut.do")
	public ModelAndView logOut(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		HttpSession session = request.getSession(true);
		session.invalidate();
		
		mv.setViewName("test");
		return mv; 
	}
}
 