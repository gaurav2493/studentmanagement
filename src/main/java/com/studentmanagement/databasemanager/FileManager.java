package com.studentmanagement.databasemanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

import javax.sql.DataSource;

public class FileManager {

	private DataSource dataSource;
	private Connection connect;
	private PreparedStatement statement;

	public FileManager(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void makeDatabaseFileEntry(Map<String, Long> fileNames, int noticeId) {
		String sql = "INSERT INTO files(NOTICE_ID,SEQUENCE_NO,FILE_NAME,TIMESTAMP) VALUES(?,?,?,?)";
		try {
			connect = dataSource.getConnection();
			statement = connect.prepareStatement(sql);
			int seq=1;

			for (Map.Entry<String, Long> entry : fileNames.entrySet()) {
				statement.setInt(1, noticeId);
				statement.setInt(2, seq++);
				statement.setString(3, entry.getKey());
				statement.setLong(4, entry.getValue());
				
				statement.addBatch();
			}
			statement.executeBatch();

		} catch (Exception e) {
			
			//e.getNe
			
		} finally {
			close();
		}
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
