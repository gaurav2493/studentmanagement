package com.studentmanagement.databasemanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

public class ExamReports {
	
	private DataSource dataSource;
	private Connection connect = null;
	private PreparedStatement statement = null;
	private Map<Integer, String> examTypeMap; 
	private ResultSet res=null;

	public ExamReports(DataSource dataSource) {
		
		this.dataSource=dataSource;
	}
	
	public void createNewExam(String param) {
		
		try {
			examTypeMap=new HashMap<Integer, String>();
			connect = dataSource.getConnection();
			String sql="INSERT INTO exam_type(exam_name) values(?)";
			statement = connect.prepareStatement(sql);
			statement.setString(1, param);
			statement.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			close();
		}
	}

	public Map<Integer,String> getExamTypes()
	{
		try {
			examTypeMap=new HashMap<Integer, String>();
			connect = dataSource.getConnection();
			String sql="SELECT EXAM_ID,EXAM_NAME from exam_type";
			statement = connect.prepareStatement(sql);
			res=statement.executeQuery();
			while (res.next())
			{
				examTypeMap.put(new Integer(res.getInt("exam_id")), res.getString("exam_name"));
			}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		} finally {
			close();
		}
		return examTypeMap;
	}
	
	private void close() {
		try {
			if(res!=null){
				res.close();
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
