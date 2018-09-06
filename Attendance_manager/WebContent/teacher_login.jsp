<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Teacher Login</title>
<link type="text/css" href="css/login.css" rel="stylesheet">
</head>
<body>
<div class="body"></div>
		<div class="grad"></div>
		<div class="header">
			<div> Teacher Login</div>
		</div>
		<br>
		<div class="login">
		 <form action="controller" method="GET">
       <input type="hidden" name="command" value="TEACHER"/>
      
				<input type="text" placeholder="username" name="user"><br>
				<input type="password" placeholder="password" name="password"><br>
				<input type="submit" value="Login">
		</form>		
		</div>
</body>
</html>