package com.org.kr.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.kr.utils.SHA256;


@Controller
public class ActionController {
	
	private final SHA256 sha256;
	
	@Autowired
	public ActionController(SHA256 sha256) { 
		this.sha256 = sha256; 
	}

	
	@RequestMapping("/login.do")
	public ModelAndView login(@RequestParam Map map){
		ModelAndView mv = new ModelAndView();
		sha256.shaEncrypt((String) map.get("passwd"));
		mv.setViewName("pjadView");
		return mv;
	}
}
 