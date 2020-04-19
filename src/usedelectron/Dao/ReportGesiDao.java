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

import usedelectron.Dto.ReportGesiDto;

public class ReportGesiDao {
	private static ReportGesiDao instance;

	public static ReportGesiDao getInstance() {
		if (instance == null) {
			instance = new ReportGesiDao();
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

	public List<ReportGesiDto> reportGesi() {

		Connection conn = null;
		PreparedStatement pstmt = null;

		List<ReportGesiDto> list = new ArrayList<>();

		String sql = "SELECT s_r_num, bd_num, bd_title, bd_sellbuy, bd_write FROM user_board, savelist_report WHERE savelist_report.s_r_bd_num = user_board.bd_num and s_r_division = 3";

		try {

			conn = getConnection();
			pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {

				ReportGesiDto r = new ReportGesiDto();

				r.setS_r_num(rs.getInt("s_r_num"));
				r.setBd_num(rs.getInt("bd_num"));
				r.setBd_title(rs.getString("bd_title"));
				r.setBd_sellbuy(rs.getString("bd_sellbuy"));
				r.setBd_write(rs.getString("bd_write"));
				
				list.add(r);
			}
			
			pstmt.close();
			conn.close();
			rs.close();

			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

}
