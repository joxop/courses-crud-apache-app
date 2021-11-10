package DatabaseUtility;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import CunyApp.Courses;
import CunyApp.LoginBean;
import CunyApp.ValidateID;

public class DBConnect{
	
private static String DB_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
static String dbLoc = "jdbc:sqlserver://s16988308.onlinehome-server.com:1433;databaseName=CUNY_DB;integratedSecurity=false;";
private static String dbUser = "cst4713";
private static String dbPw = "password1";
public static Connection connection = null;
public static ResultSet rs;
public static boolean dbError = false;
//public static LoginBean currentStudent;

public static void startConnect () throws ServletException, IOException {
try {
	Class.forName(DB_CLASS);
	connection = DriverManager.getConnection(dbLoc, dbUser, dbPw);
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	dbError = true;	
}
}

public static LoginBean verifyStudent (String sID) 
{
	String query = "select ssn,firstName,lastName from students"
			+ " where ssn =" + ValidateID.sID;
	try {
		startConnect();
		Statement statement = connection.createStatement();
		rs =statement.executeQuery(query);
		if (rs.next()==false || rs==null) {
			CunyApp.ValidateID.errMess ="Student does not exist";
			CunyApp.ValidateID.path="LoginPage.jsp";
		}else {
				LoginBean currentStudent = new LoginBean (rs.getString(1),rs.getString(2),rs.getString(3));
				showCoursesReg();
				ValidateID.path="/WEB-INF/MyCourses.jsp";
				return currentStudent;
		}
		connection.close();

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ServletException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	return null;
}

public static void showCoursesReg() {
	Courses.coursesRegistered.clear();
	String query = "SELECT c.CourseID, c.title, c.numOfCredits, e.grade, sum(numOfCredits) "
			+ "FROM Course c, Enrollment e "
			+ "WHERE e.courseId = c.CourseId and e.ssn =" + ValidateID.sID + 
			" group by c.CourseID,c.title,c.numOfCredits,e.grade " +
			"order by c.courseID";
	try {
		Statement statement = connection.createStatement();
		rs = statement.executeQuery(query);
		
			while (rs.next()) {
				String cID = rs.getString(1);
				String cTit = rs.getString(2);
				String cred=rs.getString(3);
				String grade=rs.getString(4);
				Courses.coursesRegistered.add(new Courses (cID, cTit,cred,grade));
			}
			query = "select sum(numOfCredits) " +
					"from course c, enrollment e,Students s "+
					"where e.ssn = s.ssn and " +
					"e.courseId = c.courseID and " +
					"s.ssn =" + ValidateID.sID+";";
					
			rs = statement.executeQuery(query);
			while (rs.next()) {
				Courses.creditsEnrol = rs.getString(1);
			}
			connection.close();
			
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

public static List<Courses> coursesAvailable () throws ServletException, IOException {
	List <Courses> courseList = new ArrayList <Courses> ();
	//Courses.coursesAvailable.clear();
	String sql = "SELECT c.courseId,c.title,c.numOfCredits FROM Course c where c.courseID NOT IN "
			+ "(select c.CourseId "
			+ "FROM Course c, Enrollment e "
			+ "where e.courseId = c.CourseId and e.ssn =" + ValidateID.sID + ") order by c.courseID;";
	try {
		startConnect();
		Statement statement = connection.createStatement();
		rs = statement.executeQuery(sql);	
		while (rs.next()) {
			String cId = rs.getString(1);
			String cName = rs.getString(2);
			String credits = rs.getString(3);
			String grade = "";
			courseList.add(new Courses (cId,cName,credits,grade));
		}
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return courseList;
}

public static void addCourse (String course, String grade) throws ServletException, IOException {
	String sql = "insert into enrollment values (?,?,GETDATE(),?)";
				try {
					startConnect();
					PreparedStatement ps = connection.prepareStatement(sql);
					ps.setString(1, ValidateID.sID);
					ps.setString(2, course);
					ps.setString(3, grade);
					ps.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
}

public static void dropCourse (String courseID) throws ServletException, IOException {
	String sql = "DELETE FROM Enrollment "
			+ "WHERE ssn = ? and courseID = ?";
	try {
		startConnect();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, ValidateID.sID);
		ps.setString(2, courseID);
		ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
}





	



}
