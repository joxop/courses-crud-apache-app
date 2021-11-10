package CunyApp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/processRemove")
public class ProcessRemove extends HttpServlet {
	private static RequestDispatcher dispatcher;
	private static String path;
	public static String course;
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		DatabaseUtility.DBConnect.dropCourse(ConfirmDrop.course);
		DatabaseUtility.DBConnect.showCoursesReg();
		path = "/WEB-INF/MyCourses.jsp";
		dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
	
	
}
