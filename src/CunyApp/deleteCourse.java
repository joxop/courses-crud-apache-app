package CunyApp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dropCourse")
public class deleteCourse extends HttpServlet {
	private static RequestDispatcher dispatcher;
	private static String path;
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws  IOException, ServletException {
		path = "/WEB-INF/deleteCourse.jsp";
		//DatabaseUtility.DBConnect.dropCourse(course);
		dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	
	}
	
	
}
