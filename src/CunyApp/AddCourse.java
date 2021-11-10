package CunyApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddCourse")
public class AddCourse extends HttpServlet {
	private static List<Courses> courses;


	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		courses = DatabaseUtility.DBConnect.coursesAvailable();	
	    HttpSession session = request.getSession();
	    session.setAttribute("enrollBean", courses);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/AddCourse.jsp");
		dispatcher.forward(request, response);		
	}
	
	
	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
	doGet(request,response);
	}

}
