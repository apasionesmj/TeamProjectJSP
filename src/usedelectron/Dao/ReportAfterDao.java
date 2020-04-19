package usedelectron.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ReportAfterDao {
	private Connection getConnection() { // DB연동
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

	public int reportAfter(int s_r_num, int s_r_division, int s_r_bd_num) throws SQLException {
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql1 = "select * from savelist_report where s_r_bd_num=? AND s_r_division=3";
		String sql = "update SAVELIST_REPORT set s_r_division=? where s_r_num=?";
		try {
			conn = getConnection();
			ptmt = conn.prepareStatement(sql1);
			ptmt.setInt(1, s_r_bd_num);
			rs = ptmt.executeQuery();
			if(rs.next()) {
				s_r_division = 2;
			}
			ptmt.close();
			rs.close();
			
			ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, s_r_division);
			ptmt.setInt(2, s_r_num);
			
			System.out.println("ptmt: " + ptmt);

			result = ptmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (ptmt != null)
				ptmt.close();
			if (conn != null)
				conn.close();
		}
		return result;
	}


}
