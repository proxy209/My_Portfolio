package com.org.kr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.kr.service.UserService;


@Controller
public class ViewController {
	
	private final UserService user;
	
	
	@Autowired
	public ViewController(UserService user) { 
		this.user = user;
	}
	
	@RequestMapping("/adlogin.do")
	public ModelAndView adloginView(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("login");
		return mv; 
	}
	
	@RequestMapping("/pjadmin.do")
	public ModelAndView pjadminView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String, Object> map = new HashMap<>();
		
		if( request.getSession().getAttribute("ssUserType") == null ){
            response.sendRedirect("/adlogin.do");
        }
		
		List boardList = user.boardList(map);
		
		mv.addObject("boardList", boardList);
		mv.addObject("admin", request.getSession().getAttribute("ssUserType"));
		mv.setViewName("pjadView");

		return mv; 
	}
	
	@RequestMapping("/main.do")
	public ModelAndView mainView(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String, Object> map = new HashMap<>();
		
		
		List boardList = user.boardList(map);
		
		mv.addObject("boardList", boardList);
		mv.addObject("admin", request.getSession().getAttribute("ssUserType"));
		mv.setViewName("pjadView");

		mv.setViewName("main");
		return mv; 
	}
	
	@RequestMapping("/pjview.do")
	public ModelAndView pjView(@RequestParam Map map, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		List boardList = user.boardList(map);
		
		mv.addObject("boardDetail", user.boardDetail(map));
		mv.addObject("boardList", boardList);
		mv.addObject("admin", request.getSession().getAttribute("ssUserType"));
		mv.setViewName("pjView");
		
		return mv; 
	}
}
 