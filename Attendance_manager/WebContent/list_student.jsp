<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <input type="button" value="ADD STUDENT" onclick="window.location.href='add_student.jsp';return false;"/></br>
</br>   <table>
   <tr>
      <td> roll no </td>
      <td> name </td>
      <td> attend</td>
      <td> total</td>
      <td> percentage </td>
     </tr>
        <c:forEach var="tempStudent" items="${STUDENTINFO}"> 
       
        
        
   
     <tr>
          <td> ${tempStudent.rollNo} </td>
          <td> ${tempStudent.name}</td>
         <td> ${tempStudent.attend}</td>
         <td> ${tempStudent.total}</td>
         <td> ${tempStudent.percentage}</td>
        
     </tr>
</c:forEach>
     </table>
</body>
</html>