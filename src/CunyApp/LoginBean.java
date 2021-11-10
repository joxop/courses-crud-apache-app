package CunyApp;

import java.io.Serializable;

public class LoginBean implements Serializable, LoginInterface{
	private String studentID; 
	private String studentFirstName;
	private String studentLastName;
	
	public LoginBean () {
		
	}
	
	public LoginBean (String studentID, String studentFirstName, String studentLastName)
	{
		this.studentID = studentID;
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getStudentFirstName() {
		return studentFirstName;
	}
	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}
	public String getStudentLastName() {
		return studentLastName;
	}
	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}

	@Override
	public LoginBean checkStudent(String ssn) {
		// TODO Auto-generated method stub
		LoginBean student = DatabaseUtility.DBConnect.verifyStudent(ssn);
		return student;
		
	}
	

	
}
