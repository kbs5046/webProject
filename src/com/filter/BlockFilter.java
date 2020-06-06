package com.filter;


import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "BlockFilter")
public class BlockFilter implements Filter{

	
	private Set<String> allowedResources=new HashSet<>();
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException{
		allowedResources.add("/login.jsp");
		allowedResources.add("/auth");
		allowedResources.add("/signup.jsp");
		allowedResources.add("/signUp");
		allowedResources.add("/logOut");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		HttpServletResponse httpServletResponse =(HttpServletResponse)response;
		String resourceName = httpServletRequest.getServletPath();
		System.out.println("Accessing resourceName ="+resourceName+" at "+LocalDateTime.now());
		if(allowedResources.contains(resourceName) || resourceName.contains("/img")) {
			chain.doFilter(request, response);//let them in
		}
		else {
			HttpSession httpSession = httpServletRequest.getSession(false);
			if(httpSession != null && httpSession.getAttribute("name") != null) {
				//System.out.println("my session id: "+httpSession.getId());
				chain.doFilter(request, response);
			}
			else {
				httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/login.jsp?message= Please login first");
			}
		}
		
		
	}
	
	@Override
	public void destroy() {
		
	}

}
