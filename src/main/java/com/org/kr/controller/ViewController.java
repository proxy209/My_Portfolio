package com.org.kr.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ViewController {
	
	@RequestMapping("/adlogin.do")
	public ModelAndView adloginView(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("login");
		return mv; 
	}
	
	@RequestMapping("/pjadmin.do")
	public ModelAndView pjadminView(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("pjadView");
		return mv; 
	}
	
	@RequestMapping("/main.do")
	public ModelAndView mainView(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("main");
		return mv; 
	}
	
	@RequestMapping("/pjview.do")
	public ModelAndView pjView(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("pjView");
		return mv; 
	}
}
 