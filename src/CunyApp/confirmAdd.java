package CunyApp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/confirmAdd")
public class confirmAdd extends HttpServlet {
	private static String path = "";
	public static String errMess = "";
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		String course = request.getParameter("coursesCombo");
		String grade = request.getParameter("gradeCombo");

		if (course == null || grade==null) {
			errMess = "Please choose course and grade";
			path = "/WEB-INF/AddCourse.jsp";
		}else {
	DatabaseUtility.DBConnect.addCourse(course, grade);	
	DatabaseUtility.DBConnect.showCoursesReg();
	path = "/WEB-INF/MyCourses.jsp";
		}
	RequestDispatcher dispatcher = request.getRequestDispatcher(path);
	dispatcher.forward(request, response);
	}

}
