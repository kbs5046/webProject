package com.domino;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logOut")
public class LogOutServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws IOException,ServletException{
		
		doPost(req,resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException,ServletException{
			
			HttpSession session = req.getSession(false);
			if(session != null) {
				session.invalidate();
			}
			resp.sendRedirect(req.getContextPath()+"/login.jsp");
			
	}
}
