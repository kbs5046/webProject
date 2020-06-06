package com.domino;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.query.SQLQuery;
import com.util.SQLConnectionUtils;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		resp.setContentType("text/html");
		//below line is returning reference of Body of the response
		PrintWriter pw=resp.getWriter();
		try {
			Connection connection = SQLConnectionUtils.getConn();
			// Compiling query and assigning into PreparedStatement object
			PreparedStatement pstmt = connection.prepareStatement(SQLQuery.SELECT_SIGNUP_USERNAME_PASSWORD);
			// setting the values inside PreparedStatement object
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			// Fire the query
			ResultSet rs=pstmt.executeQuery();
			//username,password,email,name,salutation,datecreated
			if(rs.next()) {
				int uid = rs.getInt(1);
				String name=rs.getString(4);
				String email=rs.getString(5);
				String salutation=rs.getString(6);
				String role=rs.getString(8);
				//Setting values inside request scope
				req.setAttribute("uid", uid);
				req.setAttribute("email", email);
				req.setAttribute("name", name);
				req.setAttribute("salutation", salutation);
				req.setAttribute("role", role);
				
				HttpSession session = req.getSession();
				
				session.setAttribute("uid", uid);
				session.setAttribute("email", email);
				session.setAttribute("name", name);
				session.setAttribute("salutation", salutation);
				session.setAttribute("role", role);
				req.getRequestDispatcher("success.jsp").forward(req, resp);
			}else {
				pw.println("<h1>Sorry,  your username and password are  not correct! </h1>");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
