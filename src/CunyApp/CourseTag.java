package CunyApp;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CourseTag extends SimpleTagSupport {
	
public void doTag () throws IOException, JspException  {
		
		JspWriter out = getJspContext().getOut();	
		out.println("<h2> My Courses </h2> </br>");
		out.println("<table> <tr> <td><h2> Course ID </h2> </td> <td> <h2> Course Name </h2> </td> </tr>");
		for(Courses c: Courses.coursesRegistered) {
			out.print("<tr><td><h3>" + c.getCourseID() + "</h3></td><td><h3>" + c.getCoursesTitle() + "</h3></td></tr>");
			}
		out.println("</table><h2>Total # of Credits: " + Courses.creditsEnrol);

	
		}
	


}
