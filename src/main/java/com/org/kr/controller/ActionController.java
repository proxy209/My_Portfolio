package com.org.kr.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.org.kr.service.UserService;
import com.org.kr.utils.FileUtils;


@Controller
@RequestMapping("/api")
public class ActionController {
	
	private final UserService user;
	
	private final FileUtils file;
	
	@Autowired
	public ActionController(UserService user, FileUtils file) { 
		this.user = user;
		this.file = file;
	}

	@ResponseBody
	@RequestMapping("/login.do")
	public int login(@RequestParam Map map, HttpServletResponse response, HttpServletRequest req) throws Exception{
		int result = (user.loginChk(map) == 1) ?  1 : 0; 

		if(result == 1) {
			req.getSession().setMaxInactiveInterval(60*60*3);
			req.getSession().setAttribute("ssUserId", map.get("email"));
			req.getSession().setAttribute("ssUserType", "admin");
		}
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/boarSave.do")
	public int boardSave(@RequestParam Map map, HttpServletResponse response, MultipartHttpServletRequest req) throws Exception{
		user.boardUpload(map);
		
		file.parseInsertFileInfo(map, req);
		
		return 0;
	}
}
 