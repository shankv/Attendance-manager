<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Studenr</title>
<link type="text/css" href="css/login.css" rel="stylesheet">
</head>
<body>
<div class="body"></div>
		<div class="grad"></div>
		<div class="header">
			
			<div>Add Student</div>
		</div>
		<br>
		<div class="login">
		
		 <form action="controller" method="GET">
       <input type="hidden" name="command" value="ADD"/>
      
				<input type="text" placeholder="Roll Number" name="rollNo"><br></br>
				<input type="text" placeholder="Name of student" name="name"><br>
				<input type="submit" value="ADD">
		</form>		
		</div>
     
</body>
</html>