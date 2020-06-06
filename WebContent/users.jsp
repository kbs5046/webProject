<%@ page import = "com.dao.entity.UserEntity" %>
<%@ page import = "java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html>
 <html>
 <head>
 <title>Users Page</title>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
 </head>
 <body>
   <header style="height: 30px;background-color: #2196f3;">
   </header>

   <div  class="container">
         <br/>
   		<img src="img/student.png"  style="height: 160px;">
   		 <h3>User Sign List</h3>
   		 <hr/>
   		 	<a href="logOut">
   		 		<button type="submit" class="btn btn-danger" style="background-color: Black">LogOut</button>
   		 	</a>
   		 	Current Role : - ${sessionScope.role}
   		 	<br/>
   		   <hr/>
   		 Username :  ${param.username}
   		 <br/>
   		 Email :  ${email}<br/>
   		 Name :  ${name}<br/>
   		 Salutation :  ${salutation}
   		<br/>
   		  Total Logged in User : =  ${activeSessions}
   		  <hr/>
   		<span style="background-color: red;font-weight: bold;"> ${param.message}</span>
   		 <hr/>
   		  <table class="table table-bordered">
     <thead>
       <tr>
         <th>UserName</th>
         <th>Name</th>
         <th>Email</th>
         <th>Salutation</th>
         <th>Date Created</th>
         <th>Action</th>
       </tr>
     </thead>
     <tbody>

     <%
     @SuppressWarnings("unchecked")
     	List<UserEntity> signupList =( List<UserEntity>)request.getAttribute("signupList");
     try{
     	for(UserEntity entity:signupList){
     %>
       
       <tr>
         <td><%=entity.getUserName() %></td>
         <td><%=entity.getName() %></td>
         <td><%=entity.getEmail() %></td>
           <td><%=entity.getSalutation() %></td>
             <td><%=entity.getTimeStamp() %></td>
             <td>
             <a href="deleteSignup?sid=<%=entity.getuID() %>">
                    <img src="img/del.png"  style="height: 40px;">
             </a>
             <a href="selectSignup?sid=<%=entity.getuID() %>">
                 <img src="img/edit.png"  style="height: 40px;">
                </a> 
             </td>
       </tr>

     <% }}
     catch (Exception e){
    	 e.printStackTrace();
     }%> 

     </tbody>
   </table>

   </div>


 </body>
 </html> 