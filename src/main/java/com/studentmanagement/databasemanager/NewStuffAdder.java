package com.studentmanagement.databasemanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

import javax.sql.DataSource;

public class NewStuffAdder {
	
	  private Connection connect = null;
	  private PreparedStatement statement = null;
	  private DataSource dataSource;
	  Map<String, String> map=null;
	
	public NewStuffAdder(DataSource dataSource,Map<String, String> map) {

		this.dataSource=dataSource;
		this.map=map;

	  }
	
	public boolean addStudent()
	{
		try {
	    	connect=dataSource.getConnection();
	        statement = connect
	        .prepareStatement("INSERT INTO student_info" +
	        		"(NAME,FATHER_NAME,MOTHER_NAME,EMAIL,PARENT_EMAIL,COURSE,BRANCH,ROLLNO) " +
	        		"VALUES(?,?,?,?,?,?,?,?)");
	        
	        statement.setString(1, map.get("name"));
	        statement.setString(2, map.get("fname"));
	        statement.setString(3, map.get("mname"));
	        statement.setString(4, map.get("email"));
	        statement.setString(5, map.get("pemail"));
	        statement.setString(6, map.get("course"));
	        statement.setString(7, map.get("branch"));
	        statement.setInt(8, Integer.parseInt(map.get("rollno")));
	        
	        statement.executeUpdate();
	      
	    } catch (Exception e) {
	      
	    	return false;
	    } finally {
	      close();
	    }
		return true;
	}
	
	public boolean addClass()
	{
		try {
	    	connect=dataSource.getConnection();
	        PreparedStatement statement = connect
	        .prepareStatement("INSERT INTO class" +
	        		"(SESSION_BEGIN,YEAR_NO,BRANCH,SECTION) " +
	        		"VALUES(?,?,?,?)");
	        
	        statement.setInt(1, Integer.parseInt(map.get("session")));
	        statement.setInt(2, Integer.parseInt(map.get("year")));
	        statement.setString(3, map.get("branch"));
	        statement.setString(4, map.get("section"));
	        
	        statement.executeUpdate();
	    } catch (Exception e) {
	      System.out.println(e);
	    	return false;
	    } finally {
	      close();
	    }
		return true;
	}

	public boolean addSubject() {
		
		try {
	    	connect=dataSource.getConnection();
	        statement = connect
	        .prepareStatement("INSERT INTO subject" +
	        		"(SUBJECT_CODE,SUBJECT_NAME) " +
	        		"VALUES(?,?)");
	        
	        statement.setString(1, map.get("code"));
	        statement.setString(2, map.get("name"));
	        
	        statement.executeUpdate();
	    } catch (Exception e) {
	      System.out.println(e);
	    	return false;
	    } finally {
	      close();
	    }
		return true;
	}
	private void close() {
	    try {
	      
	      if (statement != null) {
	        statement.close();
	      }
	      if (connect != null) {
	        connect.close();
	      }
	    } catch (Exception e) {

	    }
	}

}
