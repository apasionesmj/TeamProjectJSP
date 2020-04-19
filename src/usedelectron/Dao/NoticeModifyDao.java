package usedelectron.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import usedelectron.Dto.NoticeDto;

public class NoticeModifyDao {
	private static NoticeModifyDao instance;
	
	public NoticeModifyDao() {
		
	}
	
	public static NoticeModifyDao getInstance() {
		if (instance == null) {
			instance = new NoticeModifyDao();
		}
		return instance;
	}
	
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	public int NoticeModify(String nt_title, String nt_body, int nt_num) throws SQLException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int Result = 0;
		String sql = "update notice set nt_title=?,nt_body=?,nt_date=sysdate  where nt_num=?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nt_title);
			pstmt.setString(2, nt_body);
			pstmt.setInt(3, nt_num);
			Result = pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(pstmt != null)
				pstmt.close();
			if(conn != null)
				pstmt.close();
		}
		return Result;
	}
}
