package usedelectron.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CommandPrecess.CommandPrecess;
import usedelectron.Dao.ReportDeatilDAO;

public class ReportDetail implements CommandPrecess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//한글출력 코드
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		//맹핑 확인
		System.out.println("신고게시판 디테일 확인");
		
		//신고번호 가져오는지 확인
		String s_r_num = request.getParameter("report");
	
		//신고디테일 DAO 실행 (해당 신고 목록만가져오기)
		ReportDeatilDAO service = new ReportDeatilDAO();
		//게시글 번호로 신고게시판 불러오기
		//request에다가 넣기
		request.setAttribute("repordetail", service.reportdetail(Integer.parseInt(s_r_num)));
		request.setAttribute("tag_num", 12);
	return "khome.jsp";

}
}
