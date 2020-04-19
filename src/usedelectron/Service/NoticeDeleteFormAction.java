package usedelectron.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CommandPrecess.CommandPrecess;
import usedelectron.Dao.NoticeDeleteDao;

public class NoticeDeleteFormAction implements CommandPrecess {
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//재현
		//FROM noticeDetail.jsp
		try {
			int nt_num = Integer.parseInt(request.getParameter("nt_num"));
			NoticeDeleteDao nd = NoticeDeleteDao.getInstance();
			
			System.out.println("nt_numnt_numnt_numnt_numnt_num" + nt_num);
			//공지글을 삭제하기 위해 필요한 값(공지글 번호)를 전달
			int result = nd.noticeDelete(nt_num);
			request.setAttribute("Result", result);
			System.out.println("NoticeDeleteFormAction result -> " + result);
			
			request.setAttribute("nt_num", nt_num);
			System.out.println("NoticeDeleteFormAction nt_num -> " + nt_num);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "noticeDeleteForm.jsp";
	}

}
