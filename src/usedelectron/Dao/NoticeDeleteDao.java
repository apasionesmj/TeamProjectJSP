package usedelectron.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class NoticeDeleteDao {
	private static NoticeDeleteDao instance;
	
	private NoticeDeleteDao() {
		
	}

	public static NoticeDeleteDao getInstance() {
		if (instance == null) {
			instance = new NoticeDeleteDao();
		}
		return instance;
	}

	private Connection getConnection() {
		Connection con = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/OracleDB");
			con = ds.getConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return con;
	}
	
	public int noticeDelete(int nt_num) throws SQLException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int Result = 0;
		int NoticeNum = 0;
		
		
		String sql = "delete from notice where nt_num = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nt_num);
			Result = pstmt.executeUpdate();
				
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (conn != null) conn.close();
			if (pstmt != null) pstmt.close();
		}
		return Result;
	}
}
