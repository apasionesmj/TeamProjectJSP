package usedelectron.Dao;

import java.sql.*;
import javax.sql.*;

import usedelectron.Dto.savelist_reportDto;

import javax.naming.*;

public class reBoardDao {
	
	private static reBoardDao instance;

	public static reBoardDao getInstance() {
		if (instance == null) {
			instance = new reBoardDao();
		}
		return instance;
	}
	
	private Connection getConnection() {
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

	public int insert(savelist_reportDto board) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		ResultSet rs = null;
		String sql1 = "select nvl(max(s_r_num),0) from SAVELIST_REPORT"; //number를 구하기 위한 sql
		String sql = "insert into SAVELIST_REPORT values(?,?,?,(null),?,?,?,sysdate,(null))"; //4와8은 image 와 date다.
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement(sql1);
			rs = pstmt.executeQuery();
			rs.next();
			
			//sequence 로 number을 구함

			int number = rs.getInt(1) + 1;
			
			//number는 table 에서 unique한 고유번호다. 이것이 s_r_num이 된다

			rs.close();
			pstmt.close();

			// board.setS_r_num(number); 필요하다면 board에 넣어 둘 수 있음. 

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, number); //고유 id = s_r_num
			pstmt.setString(2, board.getS_r_body());//report의 내용 = s_r_body
			pstmt.setString(3, board.getUr_id());//report 하는 사람의 아이디 = ur_id(string)
			pstmt.setInt(4, board.getBd_num());//report 당하는 board  = bd_num
			pstmt.setInt(5, board.getS_r_division());//s_r_division (int)
			pstmt.setString(6, board.getS_r_title());//s_r_title(String)

			result = pstmt.executeUpdate(); //0 아니면 +가 된다

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return result;
	}
}
