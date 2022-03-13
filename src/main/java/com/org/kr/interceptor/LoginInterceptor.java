package com.org.kr.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {
	 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		return true;
	}
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView, ModelMap model) throws Exception {
        try{
            if( request.getSession().getAttribute("adminId") == null ){
            	response.sendRedirect("/adlogin.do");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
