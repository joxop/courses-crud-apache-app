package CunyApp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/confirmDrop")
public class ConfirmDrop extends HttpServlet {
	private static RequestDispatcher dispatcher;
	private static String path;
	public static String errMess = "";
	public static String course;
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		course = request.getParameter("deleteCombo");
		String button = request.getParameter("submit");
		if (course == null) {
			path = "/WEB-INF/deleteCourse.jsp";
		} 
		else if (button.equals("Cancel")) {
			path ="/WEB-INF/MyCourses.jsp";
		}
		else {
		errMess = "Please select a course";
		path = "/WEB-INF/ConfirmRemove.jsp";
		}
		dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
	
	
}
