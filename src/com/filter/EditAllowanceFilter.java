package com.filter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

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

/**
 * Servlet Filter implementation class RoleFilter
 */
@WebFilter( filterName = "EditFilter")
public class EditAllowanceFilter implements Filter{
	
	private Map<String,String> roleAndUrl = new HashMap<>();
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
		roleAndUrl.put("editSignUp", "uid");
	}
	
	/* @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		HttpServletResponse httpServletResponse = (HttpServletResponse)response;
		
		String resourceName = httpServletRequest.getServletPath();
		System.out.println("Accessing resoureName = "+resourceName+" at  "+LocalDateTime.now());
		

		if(resourceName.contains("editSignUp")) {
			HttpSession httpSession = httpServletRequest.getSession();
			if(httpSession != null) {
				int uid = (int)httpSession.getAttribute("uid");
				String selectedID = (String)httpSession.getAttribute("selectedID");
				int sID = Integer.parseInt(selectedID);
				String role = (String)httpSession.getAttribute("role");
				if(uid == sID || role.equalsIgnoreCase("admin")) {
					chain.doFilter(request, response);
				}
				else {
					httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/users?message= Hey! you can not edit others info");
				}
				
			}
		}
		
		else {
			chain.doFilter(request, response);
		}
		
	}
}

