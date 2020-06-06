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

import com.dao.query.SQLQuery;
import com.util.SQLConnectionUtils;

import com.dao.entity.UserEntity;

@WebServlet("/signUp")
public class SignUpServerlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String salutation=req.getParameter("salutation");
		UserEntity entity = new UserEntity(0,username,password,name,email,salutation,null,null);
		
		resp.setContentType("text/html");
		int count=0;
		try {
			Connection connection = SQLConnectionUtils.getConn();
			// Compiling query and assigning into PreparedStatement object
				
			PreparedStatement pstmt = connection.prepareStatement(SQLQuery.ADD_USER);
			// setting the values inside PreparedStatement object
			pstmt.setString(1, entity.getUserName());
			pstmt.setString(2, entity.getPassword());
			pstmt.setString(3, entity.getName());
			pstmt.setString(4, entity.getEmail());
			pstmt.setString(5, entity.getSalutation());
			// Fire the query
			count = pstmt.executeUpdate();
			pstmt = connection.prepareStatement(SQLQuery.DELETE_UID_COL);
			pstmt.execute();
			pstmt = connection.prepareStatement(SQLQuery.ADD_UID_COL);
			pstmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		if(count>0) {
			req.getRequestDispatcher("rsuccess.jsp").forward(req, resp);
		}
		else {
			pw.println("<h1>Sorry,  There is some problem in registration!! </h1>");
		}
		
	}

}
