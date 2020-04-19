package usedelectron.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import usedelectron.Dto.used_boardDto;

public class MyPostListDao {
	private static MyPostListDao instance;

	private MyPostListDao() {
	}

	public static MyPostListDao getInstance() {
		if (instance == null) {
			instance = new MyPostListDao();
		}
		return instance;
	}

	public Connection getConnection() {
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
	
	public ArrayList<used_boardDto> getMyPostList(String bd_ur_id) throws SQLException {
		ArrayList<used_boardDto> list = new ArrayList<used_boardDto>();
		Connection conn = null;
		Statement stmt = null;
//		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//로그인 상태 여부 확인 sql 문
		
		//sql에서 게시물 번호, 회원 id, 제목, 팝/삼, 게시 날짜 가지고 오기
		String sql = "select bd_num, bd_ur_id, bd_title, bd_sellbuy, bd_date "
				+ " From user_board where bd_ur_id = "+bd_ur_id;
//		String sql = "select bd_num, bd_ur_id, BD_TITLE, BD_SELLBUY, bd_date from user_board";
		try {
			conn = getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, bd_ur_id);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				used_boardDto mypost = new used_boardDto();
				mypost.setBd_num(rs.getInt("bd_num"));
				mypost.setBd_ur_id(rs.getString("bd_ur_id"));
				mypost.setBd_title(rs.getString("bd_title"));
				mypost.setBd_sellbuy(rs.getString("bd_sellbuy"));
				mypost.setBd_date(rs.getDate("bd_date"));
				list.add(mypost); //setter로 넣은 것을 list에 넣어주는 것 
			}
				
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)	rs.close();
			if (stmt != null) stmt.close();
			if (conn != null) conn.close();
		}
		return list;
	}
}
