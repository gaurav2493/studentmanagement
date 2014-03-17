package com.studentmanagement.databasemanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpSession;
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
	
	public void createNewExamType(String param) {
		
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

	public void insertMarks(Map<String, String> allRequestParams,HttpSession session) {
		
		String sql="INSERT INTO exams(exam_id,total_marks,subject_id) VALUES (?,?,?)";
		@SuppressWarnings("unchecked")
		Map<String,String> allRequestParamsFromPreviousPage=(Map<String, String>)session.getAttribute("examparams");
		int examid=(Integer)session.getAttribute("examid");
		int total_marks=Integer.parseInt(allRequestParamsFromPreviousPage.get("total"));
		int exam_no=0;
				
		try{
		connect=dataSource.getConnection();
		statement=connect.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		statement.setInt(1,examid);
		statement.setInt(2,total_marks );
		statement.setString(3, allRequestParamsFromPreviousPage.get("subject"));
		
		statement.executeUpdate();

		ResultSet res = statement.getGeneratedKeys();
		
		while (res.next())
			exam_no = res.getInt(1);
		
		
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try{
			if(statement!=null) statement.close();
			if(res!=null) res.close();
			}catch(SQLException ex){}
			
		}
		
		sql="INSERT INTO rollno_subject(rollno,exam_no,marks) VALUES " +
				"(?,?,?)";
		
		try{
		statement=connect.prepareStatement(sql);
		for(Entry<String, String> e : allRequestParams.entrySet()) {
			statement.setInt(1, Integer.parseInt(e.getKey()));
			statement.setInt(2, exam_no);		
			statement.setInt(3, Integer.parseInt(e.getValue()));
			statement.addBatch();
	    }
		
		statement.executeBatch();
		
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			close();
		}
		
	}	

}
