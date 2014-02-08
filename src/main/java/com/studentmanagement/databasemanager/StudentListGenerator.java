package com.studentmanagement.databasemanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import javax.sql.DataSource;

public class StudentListGenerator {

	private DataSource dataSource;
	private Map<String,String> parametersMap;
	private Connection connect = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet;
	
	public StudentListGenerator(DataSource dataSource,Map<String, String> map) {

		this.dataSource=dataSource;
		this.parametersMap=map;
	}
	
	public ResultSet getAttendenceList()
	{
		try {
	    	connect=dataSource.getConnection();
	        statement = connect
	        .prepareStatement("");
	        
	        
	        
	        statement.executeUpdate();
	      
	    } catch (Exception e) {
	      
	    } finally {
	      close();
	    }
		return null;
	}
	
	private void close() {
	    try {
	    	 if (resultSet != null) {
	 	        resultSet.close();
	    	 }
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
