package usedelectron.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import usedelectron.Dto.NoticeDto;

public class NoticeDao {
	private static ReportListDAO instance;
	public static ReportListDAO getInstance() {
		if (instance == null) {
			instance = new ReportListDAO();
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
	
	public List<NoticeDto> noticelist() throws SQLException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM NOTICE ORDER BY nt_date ASC"; 
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs  = pstmt.executeQuery(); 
		
			List<NoticeDto> list = new ArrayList();
				
			while(rs.next()) {
				NoticeDto notiDto = new NoticeDto();
				
				notiDto.setNt_num(rs.getInt("nt_num"));
				notiDto.setNt_title(rs.getString("nt_title"));
				notiDto.setNt_date(rs.getDate("nt_date"));
				notiDto.setNt_body(rs.getString("nt_body"));
	
				list.add(notiDto);
				}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				rs.close();	
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		}
		return null;
	}
}
