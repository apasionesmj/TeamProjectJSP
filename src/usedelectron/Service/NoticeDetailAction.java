package usedelectron.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import CommandPrecess.CommandPrecess;
import usedelectron.Dao.NoticeDetailDAO;

public class NoticeDetailAction implements CommandPrecess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String result = null;
		
		try {
			String num = request.getParameter("nt_num");
			NoticeDetailDAO service = new NoticeDetailDAO();
			
			request.setAttribute("noticeDetail", service.noticeDetail(num));
			request.setAttribute("tag_num", 15);
			
			HttpSession session = request.getSession(true);	
			if(session.getAttribute("ur_class") == null) {
				result = "loginCheck.jsp";
			}else {
				result = "khome.jsp";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
			
		return result;
	}

}
