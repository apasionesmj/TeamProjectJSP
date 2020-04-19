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

import usedelectron.Dto.ReplyDto;

public class ReplyDao {
	
	private static ReplyDao instance;
	public static ReplyDao getInstance() {
		if (instance == null) {
			instance = new ReplyDao();
		}
		return instance;
	}
	

	private Connection getConnection() { //댓글 등록
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
	
	public boolean readd(ReplyDto reply) {
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO COMMANT(CM_BODY,CM_UR_ID,CM_BD_NUM,CM_DATE,CM_GROUPID,CM_LEVEL,CM_ORDERNO,CM_NUM) "
				+ " values(?,?,?,sysdate,(SELECT NVl(max(CM_GROUPID),0) + 1 FROM COMMANT),0,0,(SELECT NVl(max(CM_NUM),0) + 1 FROM COMMANT))"; 
		
		System.out.println("readd 접속 했는지 확인");
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, reply.getCm_body());
			pstmt.setString(2, reply.getCm_ur_id());
			pstmt.setInt(3, reply.getCm_bd_num());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
	
			return true;
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
		return false;
	}
	
	
	public List<ReplyDto> getrelist(int Cm_bd_num) {
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		 List<ReplyDto> list =  new ArrayList<>();
		 
		 String sql = "SELECT * FROM COMMANT WHERE CM_BD_NUM = ? ORDER BY CM_GROUPID asc,CM_ORDERNO asc";
	
			try {
				
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, Cm_bd_num); //게시판 번호로 해당 댓글 찾기
				
				ResultSet rs = pstmt.executeQuery();
			
				
				while (rs.next()) { //돌면서 DTO에 넣고 list에 추가
					
					ReplyDto r = new ReplyDto() ;
					
					r.setCm_num(rs.getInt("CM_NUM"));
					r.setCm_body(rs.getString("CM_BODY"));
					r.setCm_ur_id(rs.getString("CM_UR_ID"));
					r.setCm_groupid(rs.getInt("CM_GROUPID"));
					r.setCm_bd_num(rs.getInt("CM_BD_NUM"));
					r.setCm_orderno(rs.getInt("CM_ORDERNO"));
					r.setCm_date(rs.getDate("CM_DATE"));
					r.setCm_level(rs.getInt("CM_LEVEL"));
					
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





	public ReplyDto getrerelist(int parientid) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		 String sql = "SELECT * FROM COMMANT WHERE CM_NUM = ? ";
	
			try {
				
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, parientid);//댓글 
				
				ResultSet rs = pstmt.executeQuery();
			
				ReplyDto parlist = new ReplyDto() ;
				while (rs.next()) { //DTO에 넣어주기
					
					parlist.setCm_num(rs.getInt("CM_NUM"));
					parlist.setCm_body(rs.getString("CM_BODY"));
					parlist.setCm_ur_id(rs.getString("CM_UR_ID"));
					parlist.setCm_groupid(rs.getInt("CM_GROUPID"));
					parlist.setCm_bd_num(rs.getInt("CM_BD_NUM"));
					parlist.setCm_orderno(rs.getInt("CM_ORDERNO"));
					parlist.setCm_date(rs.getDate("CM_DATE"));
					parlist.setCm_level(rs.getInt("CM_LEVEL"));
					
				}
				
					pstmt.close();
					conn.close();
					rs.close();
					
					return parlist;
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		
		return null;
		
	}


	public boolean rereadd(ReplyDto reply, ReplyDto parinfo) {  //답글 등록

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO COMMANT(CM_BODY,CM_UR_ID,CM_BD_NUM,CM_DATE,CM_GROUPID,CM_LEVEL,CM_ORDERNO,CM_NUM) "
				+ " values(?,?,?,sysdate,?,?,?,(SELECT NVl(max(CM_NUM),0) + 1 FROM COMMANT))"; 
		
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, reply.getCm_body());
			pstmt.setString(2, reply.getCm_ur_id());
			pstmt.setInt(3, reply.getCm_bd_num());
			
			pstmt.setInt(4, parinfo.getCm_groupid());
			pstmt.setInt(5, parinfo.getCm_level() + 1);
			pstmt.setInt(6, parinfo.getCm_orderno() + 1);
						
			pstmt.executeQuery();
			
			pstmt.close();
			conn.close();
			
	
			return true;
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
		return false;
		
	}



	public boolean reupdate(ReplyDto parinfo) { //답글 추가 업데이트

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE COMMANT SET CM_ORDERNO = CM_ORDERNO + 1 WHERE CM_GROUPID = ? AND CM_ORDERNO >= ?"; 
		
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setInt(1, parinfo.getCm_groupid());
			pstmt.setInt(2, parinfo.getCm_orderno());
			
			
			pstmt.executeQuery();
			
			pstmt.close();
			conn.close();
			
	
			return true;
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
		return false;
	}
	
	public int ReplyDelete(ReplyDto parinfo) throws SQLException {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from commant where cm_num=? AND(cm_ur_id=?AND cm_bd_num=?)AND(cm_level=?)"; 
		try {
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, parinfo.getCm_num());
		pstmt.setString(2, parinfo.getCm_ur_id());
		pstmt.setInt(3, parinfo.getCm_bd_num());
		pstmt.setInt(4, parinfo.getCm_level());
		result = pstmt.executeUpdate();
		} catch (SQLException e) {
		e.printStackTrace();
		}finally{
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();		
		}
		return result;
		}
	
}
