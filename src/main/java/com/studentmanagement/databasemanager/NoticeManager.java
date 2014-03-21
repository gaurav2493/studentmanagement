package com.studentmanagement.databasemanager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.studentmanagement.components.Notice;

public class NoticeManager {
	
	private DataSource dataSource;
	private Connection connect;
	private PreparedStatement statement;
	private ResultSet res;
	
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
	
	public List<Notice> getNoticeList(int begin,int end)
	{
		String sql="SELECT NOTICE_ID,AUTHOR,TIMESTAMP,SUBJECT FROM notice  OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		List<Notice> noticeList=new ArrayList<Notice>();
		try{
			connect=dataSource.getConnection();
			statement=connect.prepareStatement(sql);
			
			statement.setInt(1, begin);
			statement.setInt(2, end);
			
			res=statement.executeQuery();
			
			while(res.next())
			{
				Notice notice=new Notice();
				notice.setAuthor(res.getString("author"));
				notice.setDate(res.getDate("timestamp"));
				notice.setNotice_id(res.getInt("notice_id"));
				notice.setSubject(res.getString("subject"));
				
				noticeList.add(notice);
			}			
			
		}catch(SQLException ex)
		{
			System.out.println(ex);
			//return false;
		}
		finally{
			close();
		}
		return noticeList;
	}
	
	public Notice viewNotice(int notice_id)
	{
		Notice notice = new Notice();
		String sql="SELECT NOTICE,AUTHOR,TIMESTAMP,SUBJECT FROM notice WHERE notice_id=?";
		try{
			connect=dataSource.getConnection();
			statement=connect.prepareStatement(sql);
			
			statement.setInt(1, notice_id);
			
			res=statement.executeQuery();
			res.next();
			notice.setAuthor(res.getString("author"));
			notice.setDate(res.getDate("timestamp"));
			notice.setNotice_id(notice_id);
			notice.setSubject(res.getString("subject"));
			notice.setNotice(res.getString("notice"));
				
			
		}catch(SQLException ex)
		{
			System.out.println(ex);
		}
		finally{
			close();
		}
		return notice;
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
