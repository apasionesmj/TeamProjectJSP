package usedelectron.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import usedelectron.Dto.MemberDto;

public class AdminDao {
	private ConnectionDao cd = ConnectionDao.getInstance();
	//싱글톤
	private static AdminDao instance;
	private AdminDao() {}
	public static AdminDao getInstance() {
		if(instance == null){instance = new AdminDao();}
		return instance;
}
	//123	
	public List<MemberDto> memberSelect() throws SQLException {
		int a = 0;
		List<MemberDto> list = new ArrayList<MemberDto>();
		String sql = "select ur_ben,"
				+ "ur_date,"
				+ "ur_id,"
				+ "ur_localip,"
				+ "ur_name,"
				+ "ur_num,"
				+ "ur_phone from member where ur_class= ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = cd.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, a);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDto md = new MemberDto();
				md.setUr_ben(rs.getInt("ur_ben"));
				md.setUr_date(rs.getDate("ur_date"));
				md.setUr_id(rs.getString("ur_id"));
				md.setUr_localip(rs.getString("ur_localip"));
				md.setUr_name(rs.getString("ur_name"));
				md.setUr_num(rs.getInt("ur_num"));
				md.setUr_phone(rs.getString("ur_phone"));
				list.add(md);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();		
		}
		return list;
	}
	
	public int User_Ben(String ben_num, String ur_ben) throws SQLException {
		int result = 0;
		if(ur_ben.equals("0")) {
			ur_ben = "1";
		}else if(ur_ben.equals("1")) {
			ur_ben = "0";
		}
		String sql = "update member set ur_ben=? where ur_num=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = cd.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ur_ben);
			pstmt.setString(2, ben_num);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally{
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();		
		}
		return result;
	}
}
