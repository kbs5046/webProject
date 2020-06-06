package com.domino;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.query.SQLQuery;
import com.util.SQLConnectionUtils;

import com.dao.entity.UserEntity;

@WebServlet("/users")
public class UsersServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		try {
			List<UserEntity> userList = new ArrayList<>();
			Connection connection = SQLConnectionUtils.getConn();
			// Compiling query and assigning into PreparedStatement object
			PreparedStatement pstmt = connection.prepareStatement(SQLQuery.SELECT_SIGNUPS);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int uid = rs.getInt(1);
				String userName = rs.getString(2);
				String password = rs.getString(3);
				String name = rs.getString(4);
				String email = rs.getString(5);
				String salutation = rs.getString(6);
				Timestamp timeStamp = rs.getTimestamp(7);
				String role = rs.getString(8);
				UserEntity entity = new UserEntity(uid,userName,password,name,email,salutation,timeStamp,role);
				userList.add(entity);
			}
			req.setAttribute("signupList", userList);
			req.getRequestDispatcher("users.jsp").forward(req,resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
