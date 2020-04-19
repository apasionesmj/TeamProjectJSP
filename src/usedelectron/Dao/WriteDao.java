package usedelectron.Dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import usedelectron.Dto.used_boardDto;

public class WriteDao {
	public Connection getConnection() {
		Connection con = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/OracleDB");
			con = ds.getConnection();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return con;
	}
	public int WriteInsert(used_boardDto board) throws SQLException {
		
		
		//WriteAction에서 board로 받은 데이터를 테이블에 입력
		Connection conn = null;
		PreparedStatement ptmt = null;
		int result = 0;
		//String sql1="select nvl(MAX(bd_num),0 from USER_BOARD";
		String sql="insert into USER_BOARD values((select nvl(MAX(bd_num),0) + 1 from USER_BOARD),?,?,?,?,?,sysdate,?,null,0,?)";

		try { 
				conn = getConnection();
				ptmt = conn.prepareStatement(sql);
				ptmt.setString(1, board.getBd_ur_id());
				ptmt.setString(2, board.getBd_title());
				ptmt.setString(3, board.getBd_sellbuy());
				ptmt.setString(4, board.getBd_write());
				ptmt.setString(5, board.getBd_image());
				ptmt.setInt(6, board.getUr_num());
				ptmt.setString(7, board.getBd_price());
				result = ptmt.executeUpdate();
				
		}catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (ptmt != null)
				ptmt.close();
			if (conn != null)
				conn.close();
		}
		return result;
	}
	

	public used_boardDto select(int bd_num) throws SQLException {
		String sql = "SELECT * FROM user_board WHERE bd_num=" + bd_num;
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		used_boardDto board = new used_boardDto();
		try {
			conn = getConnection();
			ptmt = conn.prepareStatement(sql);
			rs = ptmt.executeQuery();
			
			if (rs.next()) {
				board.setBd_num(rs.getInt("bd_num")); 
				board.setBd_sellbuy(rs.getString("bd_sellbuy"));
				board.setBd_title(rs.getString("bd_title"));
				board.setBd_ur_id(rs.getString("bd_ur_id"));
				board.setBd_image(rs.getString("bd_image"));
				board.setBd_write(rs.getString("bd_write"));
				board.setBd_date(rs.getDate("bd_date"));
				board.setBd_price(rs.getString("bd_price"));
				
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (ptmt != null)
				ptmt.close();
			if (conn != null)
				conn.close();
		}
		return board;
	}
	
	public int update(used_boardDto board, String uploadPath) throws SQLException {
		//UpdateAction에서 board로 수정한 데이터를 테이블에 입력
				Connection conn = null;
				PreparedStatement ptmt = null;
				ResultSet rs = null;
				int result = 0;
				//bd_image가 들어왔을 경우 ,현재의 이미지를 bd_DELIMAGE에 넣어두고 추후 삭제
				String sql1="select bd_image from USER_BOARD where bd_num=?";
				String sql2="update USER_BOARD set bd_ur_id=?, bd_title=?, bd_sellbuy=?, bd_write=?, bd_image=? where bd_num=?";
				
				try { 
						conn = getConnection();
						if(board.getBd_image() != null) {
							ptmt = conn.prepareStatement(sql1);
							ptmt.setInt(1, board.getBd_num());
							rs = ptmt.executeQuery();
							//이미지가 업데이트되면 현재 이미지를 반드시 삭제하도록
							//bd_delimage컬럼에 현재 이미지명 저장
							if(rs.next()) {
								board.setBd_delimage(rs.getString(1));
						    }
							rs.close(); ptmt.close();
						}
						ptmt = conn.prepareStatement(sql2);
						ptmt.setString(1, board.getBd_ur_id());
						ptmt.setString(2, board.getBd_title());
						ptmt.setString(3, board.getBd_sellbuy());
						ptmt.setString(4, board.getBd_write());
						ptmt.setString(5, board.getBd_image());
						ptmt.setInt(6, board.getBd_num());
						
						if (board.getBd_delimage() != null) {
							//경로 + "\\" + bd_delimage로 보낸 파일명을 지워라!
							File f = new File(uploadPath+"\\"+ board.getBd_delimage());
							f.delete();
						}
						// 파일이 존재하지 않으면 result를 0으로 셋팅해서 그냥 파일을 저장
						result = ptmt.executeUpdate();
				}catch (Exception e) {
					System.out.println(e.getMessage());
				} finally {
					if (ptmt != null)
						ptmt.close();
					if (conn != null)
						conn.close();
				}
				return result;
	}
	public int getTotalCnt() throws SQLException {
		int tot = 0;
		Connection conn = null;
		String sql = "SELECT COUNT(*) FROM user_board";
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			ptmt = conn.prepareStatement(sql);
			rs = ptmt.executeQuery();
			if (rs.next())
				tot = rs.getInt(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (ptmt != null)
				ptmt.close();
			if (conn != null)
				conn.close();
		}
		return tot;
	}

	public List<used_boardDto> list(int startRow, int endRow) throws SQLException {
		List<used_boardDto> list = new ArrayList<used_boardDto>();
		Connection conn = null;
		String sql = "SELECT * FROM (SELECT rownum rn ,a.* from "
				+ " (SELECT bd_num, bd_ur_id, bd_title, bd_sellbuy, bd_date FROM user_board ORDER BY bd_num DESC) a ) " + " where rn between ? and ?";
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, startRow);
			ptmt.setInt(2, endRow);
			rs = ptmt.executeQuery();
			while (rs.next()) {
				used_boardDto board = new used_boardDto();
				board.setBd_num(rs.getInt("bd_num"));
				board.setBd_ur_id(rs.getString("bd_ur_id"));
				board.setBd_title(rs.getString("bd_title"));
				board.setBd_sellbuy(rs.getString("bd_sellbuy"));
				board.setBd_date(rs.getDate("bd_date"));
				list.add(board);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (conn != null)
				conn.close();
			if (ptmt != null)
				ptmt.close();
		}
		return list;
	}

	public List<used_boardDto> list(int startRow, int endRow, int login) throws SQLException {
		List<used_boardDto> list = new ArrayList<used_boardDto>();
		Connection conn = null;
		
		
		
		String sql = "SELECT * FROM (SELECT rownum rn ,a.* from "
				+ " (SELECT bd_num, bd_ur_id, bd_title, bd_sellbuy, bd_date FROM user_board ORDER BY bd_num DESC) a ) " + " where rn between ? and ?" + "and bd_ur_id =" + login;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, startRow);
			ptmt.setInt(2, endRow);
			rs = ptmt.executeQuery();
			while (rs.next()) {
				used_boardDto board = new used_boardDto();
				board.setBd_num(rs.getInt("bd_num"));
				board.setBd_ur_id(rs.getString("bd_ur_id"));
				board.setBd_title(rs.getString("bd_title"));
				board.setBd_sellbuy(rs.getString("bd_sellbuy"));
				board.setBd_date(rs.getDate("bd_date"));
				list.add(board);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (conn != null)
				conn.close();
			if (ptmt != null)
				ptmt.close();
		}
		return list;
	}
	
	public int delete(int bd_num) throws SQLException {
		int result = 0;
		Connection conn = null;
		String sql = "DELETE FROM user_board WHERE bd_num=?";
		PreparedStatement ptmt = null;
		try {
			conn = getConnection();
			ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, bd_num);
			result = ptmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (conn != null)
				conn.close();
			if (ptmt != null)
				ptmt.close();
		}
		return result;
		
	}
	
	
}
