<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/table.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1 style="margin-left:600px;color:white;">Attendance Manger</h1>
 
  <c:url var="tempLink" value="controller">
        <c:param name="command" value="MARK"/></c:url>
  <div class="buttons-con" style="margin-left:500px">
    <div class="action-link-wrap">
      <a href="add_student.jsp" class="link-button link-back-button">Add Student</a>
      <a href="${tempLink}" class="link-button">Mark Attendance</a>
    </div>
  </div>
   
 
         <svg width="380px" height="500px" viewBox="0 0 837 1045" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:sketch="http://www.bohemiancoding.com/sketch/ns">
    <g id="Page-1" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd" sketch:type="MSPage">
        <path d="M353,9 L626.664028,170 L626.664028,487 L353,642 L79.3359724,487 L79.3359724,170 L353,9 Z" id="Polygon-1" stroke="#007FB2" stroke-width="6" sketch:type="MSShapeGroup"></path>
        <path d="M78.5,529 L147,569.186414 L147,648.311216 L78.5,687 L10,648.311216 L10,569.186414 L78.5,529 Z" id="Polygon-2" stroke="#EF4A5B" stroke-width="6" sketch:type="MSShapeGroup"></path>
        <path d="M773,186 L827,217.538705 L827,279.636651 L773,310 L719,279.636651 L719,217.538705 L773,186 Z" id="Polygon-3" stroke="#795D9C" stroke-width="6" sketch:type="MSShapeGroup"></path>
        <path d="M639,529 L773,607.846761 L773,763.091627 L639,839 L505,763.091627 L505,607.846761 L639,529 Z" id="Polygon-4" stroke="#F2773F" stroke-width="6" sketch:type="MSShapeGroup"></path>
        <path d="M281,801 L383,861.025276 L383,979.21169 L281,1037 L179,979.21169 L179,861.025276 L281,801 Z" id="Polygon-5" stroke="#36B455" stroke-width="6" sketch:type="MSShapeGroup"></path>
    </g>
</svg>
<div class="message-box">
 <table class="table-fill">
<thead>
<tr>
<th class="text-left">Roll No</th>
<th class="text-left">Name</th>
<th class="text-left">Attend</th>
<th class="text-left">NO.of class</th>
<th class="text-left">Percentage</th>
</tr>
</thead>
<tbody class="table-hover">

        <tr>
         <td> ${STUDENTINFO.rollNo} </td>
         <td> ${STUDENTINFO.name}</td>
         <td> ${STUDENTINFO.attend}</td>
         <td> ${STUDENTINFO.total}</td>
         <td> ${STUDENTINFO.percentage}</td>
        
     </tr>


</tr>

</tbody>
</table>
</div>
 
 
</body>
</html>