package usedelectron.Dao;

import java.sql.*;

import javax.naming.*;
import javax.sql.DataSource;

import usedelectron.Dto.NoticeDto;

public class NoticeDetailDAO {
	private static NoticeDetailDAO instance;
	public static NoticeDetailDAO getInstance() {
		if(instance == null) {
			instance = new NoticeDetailDAO();
		}
		return instance;
	}
	private Connection getConnection() {
		Connection con = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/OracleDB");
			con = ds.getConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return con;
	}
	public NoticeDto noticeDetail(String num) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from notice where nt_num=?";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(num));
			
			rs = pstmt.executeQuery();
			NoticeDto nd = new NoticeDto();
			while(rs.next()) {
				nd.setNt_num(rs.getInt("nt_num"));
				nd.setNt_title(rs.getString("nt_title"));
				nd.setNt_body(rs.getString("nt_body"));
				nd.setNt_date(rs.getDate("nt_date"));
			}
			return nd;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally{
			if(rs != null) {
				rs.close();
			}
			if(con != null) {
				con.close();
			}
			if(pstmt !=null) {
				pstmt.close();
			}
		}
		return null;
	}
	
	

}
