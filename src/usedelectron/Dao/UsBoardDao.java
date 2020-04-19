package usedelectron.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.*;

import usedelectron.Dto.used_boardDto;

import javax.naming.*;
import javax.sound.midi.Soundbank;

public class UsBoardDao {
	private static UsBoardDao instance;

	public static UsBoardDao getInstance() {
		if (instance == null) {
			instance = new UsBoardDao();
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

	public used_boardDto select(int num) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		System.out.println(" UsBoardDao num-> " + num);
		String sql = "select * from user_board where bd_num=" + num;

		used_boardDto board = new used_boardDto();

		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				// System.out.println("resultSet bd_num->" + rs.getInt("bd_num"));
				board.setBd_num(rs.getInt("bd_num"));
				// System.out.println("resultSet ur_num->" + rs.getInt("ur_num"));
				// board.setUr_num(rs.getInt("ur_num"));
				// System.out.println("resultSet bd_ur_id->" + rs.getInt("bd_ur_id"));
				board.setBd_ur_id(rs.getString("bd_ur_id"));
				// System.out.println("resultSet bd_title->" + rs.getInt("bd_title"));
				board.setBd_title(rs.getString("bd_title"));
				// System.out.println("resultSet bd_sellbuy->" + rs.getInt("bd_sellbuy"));
				board.setBd_sellbuy(rs.getString("bd_sellbuy"));
				// System.out.println("resultSet bd_write->" + rs.getInt("bd_write"));
				board.setBd_write(rs.getString("bd_write"));
				// System.out.println("resultSet bd_image->" + rs.getInt("bd_image"));
				board.setBd_image(rs.getString("bd_image"));
				// System.out.println("resultSet bd_date->" + rs.getInt("bd_date"));
				board.setBd_date(rs.getDate("bd_date"));
				board.setBd_price(rs.getString("bd_price"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
		return board;
	}

	public List<used_boardDto> historyList(int num) throws SQLException {
		String numS = Integer.toString(num);
		List<used_boardDto> list = new ArrayList<used_boardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from USER_BOARD where BD_UR_ID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, numS);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				used_boardDto board = new used_boardDto();
				board.setUr_num(num);
				board.setBd_num(rs.getInt("bd_num"));
				board.setBd_title(rs.getString("bd_title"));
				board.setBd_date(rs.getDate("bd_date"));
				board.setBd_sellbuy(rs.getString("bd_sellbuy"));
				list.add(board);
			}
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
		return list;
	}

	public int totCnt(int num) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int tot = 0;
		String sql = "select count(*) from USER_BOARD where BD_UR_ID = '" + num + "'";
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next())
				tot = rs.getInt(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
		return tot;
	}

	public void readCount(int num) throws SQLException {
		Connection conn = null;
		PreparedStatement ptmt = null;

		String sql = "update USER_BOARD set bd_readcount=((select bd_readcount from USER_BOARD where BD_NUM=?)+ 1) where bd_num=?";

		try {
			conn = getConnection();

			ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, num);
			ptmt.setInt(2, num);
			ptmt.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (ptmt != null)
				ptmt.close();
			if (conn != null)
				conn.close();
		}
	}
}