package CunyApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DatabaseUtility.DBConnect;

@WebServlet("/ValidateID")
public class ValidateID extends HttpServlet {
	public static String errMess="";
	public static String path ="";
	public static String sID = "";
	static ResultSet rs= null;
	static RequestDispatcher dispatcherVal;
	public static String idCookie = "";
	
public void doGet(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException {
	PrintWriter out = response.getWriter();
	sID = request.getParameter("studentID");
	Cookie studentC = new Cookie ("studentC",sID);
	response.addCookie(studentC);
	idCookie = studentC.getValue();
	if (!sID.matches("[0-9]+"))
	{
		errMess = "Enter Numbers Only";
		path = "LoginPage.jsp";
	} 
	else
	{
		LoginInterface student = new LoginBean () ; 
		LoginBean currentStudent = student.checkStudent(sID);
		HttpSession session = request.getSession();
		session.setAttribute("key", currentStudent);
	}
	
	dispatcherVal = request.getRequestDispatcher(path);
	dispatcherVal.forward(request, response);

	
}


}






