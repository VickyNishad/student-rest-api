package com.student.details;

public class StudentDetails {
	
	private long student_Id;
	private  String student_Name;
	public StudentDetails(long student_Id, String student_Name) {
		super();
		this.student_Id = student_Id;
		this.student_Name = student_Name;
	}
	public StudentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getStudent_Id() {
		return student_Id;
	}
	public void setStudent_Id(long student_Id) {
		this.student_Id = student_Id;
	}
	public  String getStudent_Name() {
		return student_Name;
	}
	public void setStudent_Name(String student_Name) {
		this.student_Name = student_Name;
	}
	@Override
	public String toString() {
		return "StudentDetails [student_Id=" + student_Id + ", student_Name=" + student_Name + "]";
	}
	

}
