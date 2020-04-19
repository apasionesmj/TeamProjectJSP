package usedelectron.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CommandPrecess.CommandPrecess;
import usedelectron.Dao.ReportListDAO;

public class ReportListAction implements CommandPrecess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=utf-8");
			
			//리스트 목록 DAO 실행 (신고 목록 전체 가져오기)
			ReportListDAO service = new ReportListDAO();
			
			//request에다가 넣기
			request.setAttribute("reportlist", service.reportlist());
			request.setAttribute("tag_num", 4);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "khome.jsp";
	}
}
