<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUp Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<header style="height: 30px;background-color: #2196f3; color: White; text-align:center"> 
	* represents required field</header>
<div class="container"> 
	<br/>   
  	<img src="img/signup.png" style="height: 120px;">
  	<h3>User Sign Up</h3>
  	<hr/>	
  	 
  		 <form action="signUp"  method="post">
  		  Username<b>*</b>
  		   <input type="text"  name="username"  class="form-control"  required="required" style="width: 50%;">
  		   
  		   Password<b>*</b>
  		   <input type="password"  name="password"  class="form-control"  required="required" style="width: 50%;">
  		   Name<b>*</b>
  		   <input type="text"  name="name"  class="form-control"  required="required" style="width: 50%;">
  		   Email<b>*</b>
  		   <input type="text"  name="email"  class="form-control"  required="required" style="width: 50%;">
  		   Salutation<b>*</b>
  		   <select name="salutation"  class="form-control"  style="width: 50%;">
  		   	<option>Mr</option>
  		      <option>Mrs</option>
  		   </select>
  		    <br/>
  		   <button type="submit" class="btn btn-primary" style ="background-color: Red">Sign Up</button>
  		   <a href="login.jsp">
  		   <button type="button" class="btn btn-danger" style ="background-color: Blue">Sign In</button>
  		   </a>
  		   <a href="users">
  		   <button type="button" class="btn btn-danger" style ="background-color: Green"> Users </button>
  		   </a>
  		   </form>
</div>
</body>
</html>