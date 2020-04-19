package usedelectron.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import CommandPrecess.CommandPrecess;
import usedelectron.Dao.NoticeDao;
import usedelectron.Dto.NoticeDto;

public class NoticeListAction implements CommandPrecess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		try {
			//리스트 목록 DAO 실행 (신고 목록 전체 가져오기)
			NoticeDao service = new NoticeDao();
			List<NoticeDto> list = new ArrayList<NoticeDto>(); 
			//request에다가 넣기
			list = service.noticelist();
			request.setAttribute("noticeList", list);
			request.setAttribute("tag_num", 6);
			
			HttpSession session = request.getSession();
			int ur_class = (int)session.getAttribute("ur_class");
			request.setAttribute("ur_class", ur_class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "khome.jsp";
	}

}