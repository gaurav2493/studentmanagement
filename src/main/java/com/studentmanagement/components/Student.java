package com.studentmanagement.components;

public class Student {
	
	private int rollNumber;
	private String name;
	private int attendenceCount;
	
	public Student(int rollNumber, int attendenceCount, String name) {

		this.rollNumber=rollNumber;
		this.attendenceCount=attendenceCount;
		this.name=name;
	}
	public int getRollNumber() {
		return rollNumber;
	}
	public String getName() {
		return name;
	}
	public int getAttendenceCount() {
		return attendenceCount;
	}
}
