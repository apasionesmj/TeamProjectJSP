package usedelectron.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CommandPrecess.CommandPrecess;
import usedelectron.Dao.NoticeModifyDao;

public class NoticeUpdateFormAction implements CommandPrecess {
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//재현
		//FROM noticeModifyForm.jsp TO noticeModify.jsp
		try {
			request.setCharacterEncoding("utf-8");
			String title = request.getParameter("nt_title");
			String body = request.getParameter("nt_body");
			int num = Integer.parseInt(request.getParameter("nt_num1"));
			NoticeModifyDao nmd = new NoticeModifyDao();
			
			request.setAttribute("nt_num", num);
			int result = nmd.NoticeModify(title, body, num);
			request.setAttribute("Result", result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "noticeUpdateForm.jsp";
	}

}
