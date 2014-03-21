package com.studentmanagement.databasemanager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class NoticeManager {
	
	private DataSource dataSource;
	private Connection connect;
	private PreparedStatement statement;
	
	public NoticeManager(DataSource dataSource)
	{
		this.dataSource=dataSource;
	}
	
	public boolean addNotice(String content,String author,String subject)
	{
		String sql="INSERT INTO notice(NOTICE,AUTHOR,TIMESTAMP,SUBJECT) VALUES " +
				"(?,?,?,?)";
		try{
			connect=dataSource.getConnection();
			statement=connect.prepareStatement(sql);
			
			statement.setString(1, content);
			statement.setString(2, author);
			statement.setDate(3, new Date(new java.util.Date().getTime()));
			statement.setString(4, subject);
			
			statement.executeUpdate();
			
		}catch(SQLException ex)
		{
			System.out.println(ex);
			return false;
		}
		finally{
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
