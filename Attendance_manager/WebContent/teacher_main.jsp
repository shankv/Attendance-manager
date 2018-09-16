<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <c:url var="tempLink" value="controller">
        <c:param name="command" value="MARK"/></c:url>
 <input type="button" value="ADD STUDENT" onclick="window.location.href='add_student.jsp';return false;"/></br>
         <a href="${tempLink}">mark</a>
 
</body>
</html>