package usedelectron.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CommandPrecess.CommandPrecess;
import usedelectron.Dao.NoticeWriteDao;

public class NoticeWriteFormAction implements CommandPrecess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		try {
			String title = request.getParameter("title");
			String body = request.getParameter("body");
			NoticeWriteDao nwd = new NoticeWriteDao();
			
			int result = nwd.write(title, body);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "noticeWriteForm.jsp";
	}

}
