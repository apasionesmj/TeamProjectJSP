package usedelectron.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class NoticeWriteDao {

	private static NoticeWriteDao instance; //싱글턴
	public static NoticeWriteDao getInstance() {
		if (instance == null) {
			instance = new NoticeWriteDao();
		}
		return instance;
	}
	

	private Connection getConnection() { //DB연동
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	public int write(String title, String body) throws SQLException{
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into notice (nt_num, nt_title, nt_body) values ((select NVL(MAX(nt_num),0) +1 from notice) ,?,?)";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, body);
			
			int execute = pstmt.executeUpdate();			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if(con != null) {
				con.close();
			}
			if(rs != null) {
				rs.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
		}
		return result;
	}

}
