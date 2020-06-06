<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editing Page</title>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
 <div  class="container">
 	<img src="img/college-student-dental-health.jpg"  style="height: 160px;">
 	<h2>Edit Your Information</h2>
 	<hr/>
 		<form action ="editSignUp" method="post">
 			<input type="hidden" name="uid" value="${entity.uID }">
 			<b>UserName</b>
 			<input type = "text" name="username" class = "form-control" style="width: 50%;"  value="${entity.userName}">
 			<b>Password</b>
 			<input type = "password" name="password" class = "form-control" style="width: 50%;"  value="${entity.password}">
 			<b>Name</b>
 			<input type = "text" name="name" class = "form-control" style="width: 50%;"  value="${entity.name}">
 			<b>Email</b>
 			<input type = "text" name="email" class = "form-control" style="width: 50%;"  value="${entity.email}">
 			<b>Salutation</b>
 			<select name="salutation" class = "form-control" style="width: 50%;">
 				<option ${entity.salutation = 'Mr' ? 'selected':''}>Mr</option>
 				<option ${entity.salutation = 'Mrs' ? 'selected':''}>Mrs</option>
 			</select>
 			
 			<br/>
   		      <button type="submit" class="btn btn-primary">Update</button>
   		      
   		      <a href="login.jsp">
   		      <button type="button" class="btn btn-danger" style ="background-color: Blue">Sign In</button>
   		      </a>
   		      <a href="signup.jsp">
   		     <button type="button" class="btn btn-danger" style ="background-color: Red">Sign Up</button>
   		     </a>
 			
 		</form>
 	
 	
 
 </div>
</body>
</html>