package com.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/*
 * web.xml
<listener>
   <listener-class>com.pizza.listener.AppBootListener</listener-class>
</listener>
OR
*/
@WebListener
public class AppBootListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@");
		   System.out.println("-------------------AppBootListener-----------------------");
		   System.out.println("@@@@@@@@@@@@@@@@@@@@@@@");
		   ServletContext  servletContext=sce.getServletContext();
		   servletContext.setAttribute("adminEmail", "pizzadmin@gmail.com");
		   servletContext.setAttribute("adminMobile", "+918272736363");
		
	}
	
	

}
