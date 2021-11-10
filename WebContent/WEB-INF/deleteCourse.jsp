<%@ page import="CunyApp.Courses"%>
<%@ page import="CunyApp.AddCourse"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Drop Course </title>
</head>
<body>
<h2> Drop Course </h2>
<hr> </br>
<h2> Courses Enrolled </h2>
<form action="confirmDrop" name = "coursesForm" value = "">
<select name = "deleteCombo">
<%
for (Courses c : Courses.coursesRegistered) {
	out.println("<option value='" + c.getCourseID() +"'>" + c.getCourseID() + "   " + c.getCoursesTitle() + "</option>");
}
%>
</select>
<table> 
<tr> <td> <input type="submit" name="submit" value="Cancel" formaction="confirmDrop"/> </td>
 <td> <input type="submit" name="submit" value="Drop Course"/> </td> </tr>
</table>
</form>
</body>
</html>