package com.netive.service.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CommonInterceptor extends HandlerInterceptorAdapter{

	/* 
	 * @AUTHOR   : NETIVE
	 * @DATE     : 2018.07. 
	 * @DESCRIPT : SPRING CONTROLLER 진입 전 실행 인터셉터 [로그인 세션 처리 등]
	 * */		
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("login");

		try { 
	        if ( obj == null ){
	            response.sendRedirect("/login");
	            return false;
	        } 
		} catch (Exception e) { 
			e.printStackTrace(); 
		} 
		
		return true;
	}

	/* 
	 * @AUTHOR   : NETIVE
	 * @DATE     : 2018.07. 
	 * @DESCRIPT : SPRING CONTROLLER 실행 종료 후 VIEW 페이지 실행 전 인터셉터
	 * */			
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
	
	/* 
	 * @AUTHOR   : NETIVE
	 * @DATE     : 2018.07. 
	 * @DESCRIPT : SPRING VIEW 실행까지 모두 종료 후 실행 인터셉터
	 * */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}
}
