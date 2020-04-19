package usedelectron.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import usedelectron.Dto.savelist_reportDto;
import usedelectron.Dto.used_boardDto;

public class  BoardDao {
	private ConnectionDao cd = ConnectionDao.getInstance();
	//싱글톤
	private static BoardDao instance;
	private BoardDao() {}
	public static BoardDao getInstance() {
		if(instance == null){instance = new BoardDao();}
		return instance;
}
	

	//찜하기
	public int favorite(int bd_num,String ur_id) throws SQLException{
		int result = 0;
		String sql = "select "
				+ "bd_num,"
				+ "bd_ur_id,"
				+ "bd_title,"
				+ "bd_date "
				+ "from user_board where bd_num = ?";
		
		String sql2 = "insert into savelist_report("
				+ "s_r_num,"
				+ "s_r_ur_id,"
				+ "s_r_title,"
				+ "s_r_date,"
				+ "s_r_bd_num,"
				+ "save_id)values((select nvl(max(s_r_num),0)+1 from savelist_report),?,?,?,?,?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			used_boardDto ud = new used_boardDto();
			con = cd.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bd_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				ud.setBd_num(rs.getInt("bd_num"));
				ud.setBd_ur_id(rs.getString("bd_ur_id"));
				ud.setBd_title(rs.getString("bd_title"));
				ud.setBd_date(rs.getDate("bd_date"));
			}
			pstmt.close(); //기존 sql문을 닫고 sql2문 실행
			pstmt = con.prepareStatement(sql2);
			pstmt.setString(1, ud.getBd_ur_id());
			pstmt.setString(2, ud.getBd_title());
			pstmt.setDate(3, (Date) ud.getBd_date());
			pstmt.setInt(4, ud.getBd_num());
			pstmt.setString(5, ur_id);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		}
		return result;
	}
	
	//찜목록보여주기
	public List<savelist_reportDto> favoriteShow(String id) throws SQLException{
		List<savelist_reportDto> list = new ArrayList<savelist_reportDto>();
		String sql = "select s_r_num,"
						+ "s_r_ur_id,"
						+ "s_r_title,"
						+ "s_r_date,"
						+ "s_r_bd_num from savelist_report where save_id = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = cd.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				savelist_reportDto srd = new savelist_reportDto();
				srd.setS_r_num(rs.getInt("s_r_num"));
				srd.setUr_id(rs.getString("s_r_ur_id"));
				srd.setS_r_title(rs.getString("s_r_title"));
				srd.setS_r_date(rs.getDate("s_r_date"));
				srd.setBd_num(rs.getInt("s_r_bd_num"));
				list.add(srd);
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(rs != null)rs.close();
			if(pstmt != null)pstmt.close();
			if(con != null)con.close();
		}
		return list;
	}
	//찜목록 데이터 삭제
	public int saveDelete(String bd_num) throws SQLException{
		int result = 0;
		String sql = "delete from savelist_report where s_r_num=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = cd.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bd_num);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		}
		return result;
	}
	
	/*메인 페이지 user_board DB  #####START*/
	public int getTotalCnt() throws SQLException{
		int tot = 0;		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from user_board ";
		
		try {
			con = cd.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				tot = rs.getInt(1);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(rs!=null)
				rs.close();
			if(stmt!=null)
				stmt.close();
			if(con!=null)
				con.close();
		}
		return tot;
	}
	
	public int favoriteoverlap(int bd_num,String ur_id) throws SQLException{
		String sql = "select s_r_bd_num,s_r_ur_id,s_r_title from savelist_report where s_r_bd_num = ? and save_id = ?";
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int result = 0;
		try {
			con = cd.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bd_num);
			pstmt.setString(2, ur_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				savelist_reportDto sr = new savelist_reportDto();
				sr.setBd_num(rs.getInt("s_r_bd_num"));
				result = 0;
			}else {
				result = 1;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();		
		}
		
		return result;
	}
	
}
