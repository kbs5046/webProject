package com.domino;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.query.SQLQuery;
import com.mysql.cj.ParseInfo;
import com.util.SQLConnectionUtils;

@WebServlet("/deleteSignup")
public class DeleteSignupServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException{
		String sid=req.getParameter("sid");
		try {
			Connection connection = SQLConnectionUtils.getConn();
			PreparedStatement pstmt = connection.prepareStatement(SQLQuery.DELETE_USER_BY_UID);
			pstmt.setInt(1,Integer.parseInt(sid));
			pstmt.execute();
			//now auto adjust the uid after deleting user so they remain in sync
			pstmt = connection.prepareStatement(SQLQuery.UPDATE_UIDS_AFTER_DELETE);
			pstmt.setInt(1, Integer.parseInt(sid));
			pstmt.execute();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//Forwarding request to the servlet!!!!
 		req.getRequestDispatcher("users").forward(req, resp);
		
	}

}
