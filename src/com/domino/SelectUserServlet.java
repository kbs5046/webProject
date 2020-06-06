package com.domino;

import java.io.IOException;
import java.net.HttpRetryException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.entity.UserEntity;
import com.dao.query.SQLQuery;
import com.util.SQLConnectionUtils;

@WebServlet("/selectSignup")
public class SelectUserServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws HttpRetryException, IOException{
		String uid = req.getParameter("sid");
		try {
			Connection connection = SQLConnectionUtils.getConn();
			PreparedStatement pstmt = connection.prepareStatement(SQLQuery.SELECT_USER_BY_UID);
			pstmt.setInt(1, Integer.parseInt(uid));
			ResultSet rs = pstmt.executeQuery();
			UserEntity entity = new UserEntity(0,null,null,null,null,null,null,null);
			if(rs.next()) {
				entity.setuID(rs.getInt(1));
				entity.setUserName(rs.getString(2));
				entity.setPassword(rs.getString(3));
				entity.setName(rs.getString(4));
				entity.setEmail(rs.getString(5));
				entity.setSalutation(rs.getString(6));
				entity.setTimeStamp(rs.getTimestamp(7));
			}
			req.setAttribute("selectedID", uid);
			req.setAttribute("entity", entity);
			HttpSession session = req.getSession();
			session.setAttribute("selectedID", uid);
			req.getRequestDispatcher("edituser.jsp").forward(req, resp);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
