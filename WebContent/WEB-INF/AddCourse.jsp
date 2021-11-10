<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="CunyApp.AddCourse"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function checkIt() {
	  if (confirm('Add this course?')) {
	   coursesForm.submit();
	  }
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Course Enrollment </title>
</head>
<body>
<h2> Course Enrollment </h2>
<hr> </br>
<form action="confirmAdd" name = "coursesForm">
<font size ="5"> Grade </font>
<select name= "coursesCombo">
<c:forEach items="${enrollBean}" var="courses"> 
<option  value= <c:out value="${courses.courseID}"/>> <c:out value="${courses.courseID}   ${courses.coursesTitle}"/> </option>
</c:forEach>
</select> 
<font size ="5"> Grade </font>
<select name= gradeCombo>
<option value ="A"> A </option>
<option value ="B"> B </option>
<option value ="C"> C </option>
<option value ="D"> D </option>
<option value ="F"> F </option>
</select> 
<h2> <font color = "red"> <% out.print(CunyApp.confirmAdd.errMess); %> </font></h2>
</br>
<input type="button" name="operation" value="Add Course" onclick="return checkIt()">
</form>
</body>
</html>