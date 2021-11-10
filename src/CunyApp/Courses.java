package CunyApp;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Courses extends SimpleTagSupport implements Serializable {
	
	private String courseID;
	private String coursesTitle;
	private String courseCredits;
	private String courseGrade;
	public static String creditsEnrol;
	public static ArrayList <Courses> coursesRegistered = new ArrayList <Courses> (); 
	public static ArrayList <Courses> coursesAvailable = new ArrayList <Courses> (); 
	
	public Courses () {
		
	}
	public Courses (String courseID, String coursesTitle, String courseCredits, String courseGrade) {
		this.courseID = courseID;
		this.coursesTitle = coursesTitle;
		this.courseCredits = courseCredits;
		this.courseGrade = courseGrade;
		
	}
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public String getCoursesTitle() {
		return coursesTitle;
	}
	public void setCoursesTitle(String coursesTitle) {
		this.coursesTitle = coursesTitle;
	}
	public String getCourseCredits() {
		return courseCredits;
	}
	public void setCourseCredits(String courseCredits) {
		this.courseCredits = courseCredits;
	}
	public String getCourseGrade() {
		return courseGrade;
	}
	public void setCourseGrade(String courseGrade) {
		this.courseGrade = courseGrade;
	}
	

	
	

}
