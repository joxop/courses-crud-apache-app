<%@ page import="CunyApp.ValidateID"%>
<%@ page import="DatabaseUtility.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
DatabaseUtility.DBConnect.startConnect(); 
if (DBConnect.dbError) {
	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/errorPage.jsp");
	dispatcher.forward(request, response);
}
%>
<html>
<head>
<script>
<!-- 
function LoadOnce() 
{ 
window.location.reload(); 
} 
//-->
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Login</title>
</head>
<body>
<h1> Student Login Page </h1> </br></br>
<center>
<fieldset>
<legend> <h3> Login Form </h3> </legend> </br> 
<form action="ValidateID">
<table> <tr> <td> Student ID: </td>
<td> <input type="text" name="studentID" value =  <% out.print(CunyApp.ValidateID.idCookie); %>> </td>
<td> <font color ="red"> <% out.println(CunyApp.ValidateID.errMess); %> </font>  </td>
</tr>
</table>
<input type="submit" value="Login"/>
</form>
</fieldset>
</center>

</body>
</html>