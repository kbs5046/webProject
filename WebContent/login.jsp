<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>LogIn Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<header style="height: 30px;background-color: #2196f3; color: White; text-align:center"> 
	Welcome to JDBC and Web Application</header>
	
<header style="height: 30px;background-color: #2196f3;color:white; text-align:center">
       Email - >>>   <b>${applicationScope.adminEmail}</b>     ->>>   Mobile - >>>  <b> ${applicationScope.adminMobile}</b>  
</header>
<div class="container"> 
	<br/>   
  	<img src="img/login.png" style="height: 120px;">
  	<hr/>	
  	 
  		 <form action="auth"  method="post">
  		  <b>Username</b>
  		   <input type="text"  name="username"  class="form-control"  required="required" style="width: 50%;">
  		   
  		   <b>Password</b>
  		   <input type="password"  name="password"  class="form-control"  required="required" style="width: 50%;">
  		    <br/>
  		   <button type="submit" class="btn btn-primary" style ="background-color: Blue">Sign In</button>
  		   <a href="signup.jsp">
  		   <button type="button" class="btn btn-danger" style ="background-color: Red">Sign Up</button>
  		   </a>
  		   <a href="users">
  		   <button type="button" class="btn btn-danger" style ="background-color: Green"> Users </button>
  		   <span style="background-color: red;font-weight: bold;"> ${param.message}</span>
  		   </a>
  		   </form>
</div>
</body>
</html>