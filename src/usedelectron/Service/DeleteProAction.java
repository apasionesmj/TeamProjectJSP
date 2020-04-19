package usedelectron.Service;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CommandPrecess.CommandPrecess;
import usedelectron.Dao.ConnectionDao;
public class DeleteProAction implements CommandPrecess {
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//FROM deleteForm.jsp
		try {
			//bd_num -> 게시판번호   ur_num -> 유저번호  ur_class -> 유저등급
			int bd_num = Integer.parseInt(request.getParameter("bd_num"));
			int ur_num = Integer.parseInt(request.getParameter("ur_num"));
			int ur_class = Integer.parseInt(request.getParameter("ur_class"));
			ConnectionDao cd = ConnectionDao.getInstance();
			//게시판을 삭제하기 위한 필요한 값(게시판번호, 유저번호, 유저등급)을 전달
			int result = cd.delete(bd_num, ur_num, ur_class);
			//int result = cd.delete(bd_num);

			request.setAttribute("result", result);
			request.setAttribute("bd_num", bd_num);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "deleteForm.jsp";
	}
}