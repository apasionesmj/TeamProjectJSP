package usedelectron.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import javax.xml.ws.Response;

import usedelectron.Dto.MemberDto;
import usedelectron.Dto.used_boardDto;

public class ConnectionDao {
	private static ConnectionDao instance;

	private ConnectionDao() {
	}

	public static ConnectionDao getInstance() {
		if (instance == null) {
			instance = new ConnectionDao();
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

	public int signUp(MemberDto mbt) throws Exception {
		String sql = "insert into member(ur_num, ur_name, ur_id, ur_passwd, ur_address, ur_phone, ur_localip) values((select NVL(MAX(ur_num),0) +1 from member),?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			ConnectionDao d = new ConnectionDao();
			con = d.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mbt.getUr_name());
			pstmt.setString(2, mbt.getUr_id());
			pstmt.setString(3, mbt.getUr_passwd());
			pstmt.setString(4, mbt.getUr_address());
			pstmt.setString(5, mbt.getUr_phone());
			pstmt.setString(6, mbt.getUr_localip());

			result = pstmt.executeUpdate(); 
			System.out.println(mbt.toString());
			con.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		return result;
	}

	public int confirm(String ur_id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select ur_id from member where ur_id=?";
		MemberDto mbt = new MemberDto();
		int result = 0;
		try {
			ConnectionDao d = new ConnectionDao();
			con = d.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ur_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = 0;
				mbt.setUr_id(rs.getString("ur_id"));
			} else {
				result = 1;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}

		return result;
	}

	public int login(MemberDto mbt) throws SQLException{
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where ur_id=? and ur_passwd=?";
		try {
			ConnectionDao d = new ConnectionDao();
			con = d.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mbt.getUr_id());
			pstmt.setString(2, mbt.getUr_passwd());
			rs = pstmt.executeQuery();

			if (rs.next()) { 
					int ur_ben = rs.getInt("ur_ben");
				if (ur_ben == 0) {
					result = 1;
				} else {
					result = 2;
				}
			} else {
				result = 0;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();		
		}
		return result;
	}

	public MemberDto loginGet(MemberDto mbt) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDto mbt2 = null;
		String sql = "select * from member where ur_id=? and ur_passwd=?";
		try {
			ConnectionDao d = new ConnectionDao();
			con = d.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mbt.getUr_id());
			pstmt.setString(2, mbt.getUr_passwd());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int ur_num = rs.getInt("ur_num");
				int ur_class = rs.getInt("ur_class");
				String ur_id = rs.getString("ur_id");
				String ur_passwd = rs.getString("ur_passwd");
				String ur_name = rs.getString("ur_name");
				String ur_phone = rs.getString("ur_phone");
				Date ur_date = rs.getDate("ur_date");
				int ur_ben = rs.getInt("ur_ben");
				String ur_localip = rs.getString("ur_localip");
				String ur_address = rs.getString("ur_address");
				mbt2 = new MemberDto(ur_num, ur_id, ur_passwd, ur_name, ur_phone, ur_date, ur_ben, ur_localip, ur_class, ur_address);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();		
		}
		return mbt2;
	}

	public int update(MemberDto mbt) throws SQLException{
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update member set ur_passwd=?, ur_address=?, ur_phone=? where ur_id=?";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mbt.getUr_passwd());
			pstmt.setString(2, mbt.getUr_address());
			pstmt.setString(3, mbt.getUr_phone());
			pstmt.setString(4, mbt.getUr_id());
			if(pstmt.executeUpdate() != 0) {
				result = 1;	
			}else {
				result = 0;	
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if(pstmt != null) {
				pstmt.close();
			}
			if(con != null) {
				con.close();
			}
		}
		return result;
	}

	public int memberOut(MemberDto mbt) throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "delete from member where ur_id=? and ur_passwd=?";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mbt.getUr_id());
			pstmt.setString(2, mbt.getUr_passwd());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = 1;	
			}else {
				result = 0;	
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if(con != null) {
				con.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(rs != null) {
				rs.close();
			}
		}
		return result;
	}

	public int getTotalCnt() throws SQLException{
		Connection con = null;  Statement stmt = null;
		ResultSet rs = null; 	int tot = 0;		
		String sql = "select count(*) from user_board ";
		
		try {
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) tot = rs.getInt(1);
			
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
		
	public List<used_boardDto> board_list(int startRow, int endRow) throws SQLException{
		List<used_boardDto> board_list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from (select rownum rn ,a.* from " + 
						"(select * from user_board order by bd_num desc) a ) " + 
						" where rn between ? and ? ";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				used_boardDto ubd = new used_boardDto();
				ubd.setBd_num(rs.getInt("bd_num"));
				ubd.setBd_ur_id(rs.getString("bd_ur_id"));
				ubd.setBd_title(rs.getString("bd_title"));
				ubd.setBd_sellbuy(rs.getString("bd_sellbuy"));
				ubd.setBd_write(rs.getString("bd_write"));
				ubd.setBd_date(rs.getDate("bd_date"));
				ubd.setUr_num(rs.getInt("ur_num"));
				ubd.setBd_readCount(rs.getInt("bd_readCount"));
				board_list.add(ubd);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(rs!=null)
				rs.close();
			if(pstmt!=null)
				pstmt.close();
			if(con!=null)
				con.close();
		}
		return board_list;
	}
	
	// 재현 검색 기능
		public List<used_boardDto> Searchlist(String search, String bd_sellbuy, int startRow, int endRow) throws SQLException{
			List<used_boardDto> list = new ArrayList<>();
			Connection con = null;	PreparedStatement pstmt= null;
			ResultSet rs = null;
			String sql =" select * from" 
						+"        (select rownum rn, a.*" 
						+"         FROM 	(select * from user_board" 
						+"              where lower(bd_title) like lower('%'||?||'%')" 
						+"                 and (lower(bd_sellbuy)=lower(?) or lower('ALL')=lower(?))"
						+"                 ) a"
						+"         )  "
						+" where rn between ? and ?";

			try {
				con = getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, search);
				pstmt.setString(2, bd_sellbuy);
				pstmt.setString(3, bd_sellbuy);
				pstmt.setInt(4, startRow);
				pstmt.setInt(5, endRow);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					used_boardDto ubd = new used_boardDto();
					ubd.setBd_num(rs.getInt("bd_num"));
					ubd.setBd_ur_id(rs.getString("bd_ur_id"));
					ubd.setBd_title(rs.getString("bd_title"));
					ubd.setBd_sellbuy(rs.getString("bd_sellbuy"));
					ubd.setBd_write(rs.getString("bd_write"));
					ubd.setBd_date(rs.getDate("bd_date"));
					ubd.setUr_num(rs.getInt("ur_num"));
					list.add(ubd);
					System.out.println("검색된 값 === "+ rs.getInt("bd_num"));
					System.out.println("검색된 값 === "+ rs.getString("bd_ur_id"));
					System.out.println("검색된 값 === "+ rs.getString("bd_title"));
					System.out.println("검색된 값 === "+ rs.getString("bd_sellbuy"));
					System.out.println("검색된 값 === "+ rs.getDate("bd_date"));
					System.out.println("검색된 값 === "+ rs.getInt("ur_num"));
				}
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}finally {
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
				if(con!=null)
					con.close();
			}
			return list;
	}
		//재현 검색에 해당하는 전체 값.
		public int getSearchCnt(String search, String bd_sellbuy) throws SQLException{
			Connection con = null;  PreparedStatement pstmt = null;
			ResultSet rs = null; 	int totcnt = 0;		
			String sql = "select count(*) from user_board where lower(bd_title) like lower('%'||?||'%') "
			+ "and (lower(bd_sellbuy)=lower(?) or lower('ALL')=lower(?))";
			System.out.println("getSearchCnt sql-->" + sql);  
			System.out.println("getSearchCnt search-->" + search);  
			System.out.println("getSearchCnt bd_sellbuy-->" + bd_sellbuy);  
			
			try {
				con = getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, search);
				pstmt.setString(2, bd_sellbuy);
				pstmt.setString(3, bd_sellbuy);
				rs = pstmt.executeQuery();
				if(rs.next()) totcnt = rs.getInt(1);
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}finally {
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
				if(con!=null)
					con.close();
			}
			return totcnt;
		}
		
	public used_boardDto select(int num) throws SQLException{
		used_boardDto ubd = new used_boardDto();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;		
		String sql = "select * from user_board where BD_NUM=" + num;
				
		try {
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				ubd.setBd_num(rs.getInt("bd_num"));
				ubd.setBd_ur_id(rs.getString("bd_ur_id"));
				ubd.setBd_title(rs.getString("bd_title"));
				ubd.setBd_sellbuy(rs.getString("bd_sellbuy"));
				ubd.setBd_write(rs.getString("bd_write"));
				ubd.setBd_image(rs.getString("bd_image"));
				ubd.setBd_date(rs.getDate("bd_date"));
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
		return ubd;
	}
	// 재현 - delete 기능
		public int delete(int bd_num, int ur_num, int ur_class) throws SQLException {
			Connection conn = null;
			PreparedStatement pstmt = null;

			int vResult = 0;
			int result = 0;
			String sql = "DELETE FROM user_board WHERE bd_num = ?";
			// verify영역에서 검증된 경우 삭제를 실시한다. 결과값이 1일때 검증이 완료
			vResult = verify(bd_num, ur_num, ur_class);

			try {
				// 검증된 유저면 삭제
				if (vResult == 1) {
					conn = getConnection();
					// pstmt = Connection을 통하여 sql구문을 준비 세팅한다.
					pstmt = conn.prepareStatement(sql);
					// pstmt.setInt(첫 번째 ?, int bd_num);
					pstmt.setInt(1, bd_num);
					result = pstmt.executeUpdate();
				} else {
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				//구문이 종료됨으로 인해 기존작업 영역들을 종료
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
			}
			return result;
		}

		// 재현 - delete 권한 확인 기능
		public int verify(int bd_num, int ur_num, int ur_class) throws SQLException {
			Connection conn = null;
			PreparedStatement pstmt = null;

			int Result = 0;
			int BoardNum = 0;
			ResultSet rs = null;
			// 관리자의 등급을 1번이라고 두고 관리자 등급 이거나 유저의 번호가 글을 작성한 유저의 번호와 동일 할경우
			// 글을 삭제할 수 있는 권한을 부여한다.
			String sql1 = "SELECT * FROM user_board WHERE bd_num = ? and (ur_num = ? or 1 = ?)";
			try {
				conn = getConnection();
				// pstmt = Connection을 통하여 sql구문을 준비 세팅한다.
				pstmt = conn.prepareStatement(sql1);
				pstmt.setInt(1, bd_num);
				pstmt.setInt(2, ur_num);
				pstmt.setInt(3, ur_class);
				// ResultSet -> 결과 집합을 받는것이기 떄문에 select SQL구문일때만 사용한다.
				rs = pstmt.executeQuery();
				if (rs.next()) {
					Result = 1;
				} else
					Result = -1;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				//구문이 종료됨으로 인해 기존작업 영역들을 종료
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
			}
			return Result;
		}
}
