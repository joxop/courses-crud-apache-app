<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="courseP" uri="currCourses.tld"%>
<jsp:useBean id="key" class="CunyApp.LoginBean" scope = "session" />
<html>
<head>
<title>  Courses </title>
</head>
<body>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<h1> <jsp:getProperty name="key" property="studentFirstName"/>, <jsp:getProperty name="key" property="studentLastName"/>  Courses </h1></br>
<courseP:courses/> </br>
<table> 
<form action="AddCourse">
<tr><td> <input type="submit" value="Delete Course" formaction="dropCourse"> </td> 
<td> <input type="submit" value="Add Course"> </td> </tr>
</form>
</table>
</body>
</html>