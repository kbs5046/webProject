package com.listener;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/*
 * web.xml
<listener>
   <listener-class>com.pizza.listener.AppBootListener</listener-class>
</listener>
OR
*/

@WebListener
public class SessionCountListener implements HttpSessionListener{
	final AtomicInteger sessionCount = new AtomicInteger(1);

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		sessionCount.getAndIncrement();
		setActiveSessionCount(se);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		sessionCount.getAndDecrement();
		setActiveSessionCount(se);
	} 
	
	private void setActiveSessionCount(HttpSessionEvent se) {
		ServletContext sc = se.getSession().getServletContext();
		sc.setAttribute("activeSessions", sessionCount.get());
		System.out.println("Total Active Session: " + sessionCount.get());
	}


}
