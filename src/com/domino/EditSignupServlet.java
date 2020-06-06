package com.domino;

import java.io.IOException;
import java.net.HttpRetryException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.query.SQLQuery;
import com.util.SQLConnectionUtils;

@WebServlet("/editSignUp")
public class EditSignupServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
		throws HttpRetryException,IOException{
		String uid = req.getParameter("uid")
;		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String salutation = req.getParameter("salutation");
		try {
			Connection connection = SQLConnectionUtils.getConn();
			PreparedStatement pstmt = connection.prepareStatement(SQLQuery.EDIT_USER);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.setString(5, salutation);
			pstmt.setInt(6,Integer.parseInt(uid));
			pstmt.executeUpdate();		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		resp.sendRedirect(req.getContextPath()+"/users");
		
	}

}
