package com.org.kr.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	 
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                HttpSession session = request.getSession();

        if(request.getSession().getAttribute("test") == null){
        
            // 세션이 없을 시, login으로 Redirect
            response.sendRedirect("/adlogin.do");
            return false;
        }
	
        
        return true;
    }
    
    
}
