<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Attendance Marker</title>
</head>
<body>
     <form action="controller" method="GET">
       <input type="hidden" name="command" value="UPDATE"/>
          <table><tr>
     <td> <label> Roll Number</label></td>
     <td> <label> Name </label> </td>
     <td> <label> present</label> </td>
     <td> <label> Absent </label> </td>
     </tr>
      <c:forEach var="tempStudent" items="${STUDENTINFO}"> 
           <tr>
             
             <td> <input type="hidden" name="rollNo" value="${tempStudent.rollNo}"/> ${tempStudent.rollNo}</td> 
            <td> <input type="hidden" name="name" value="${tempStudent.name}"/> ${tempStudent.name}</td>
            <td> <input type="radio" name="${tempStudent.rollNo}" value="1">present</td>
            <td> <input type="radio" name="${tempStudent.rollNo}" value="0">Absent</td>
            </tr>
             
     </c:forEach>
                
      <tr> <td> <input type="submit" value= "submit"></td></tr>
     </table>
   </form>
</body>
</html>