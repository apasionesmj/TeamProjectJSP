package usedelectron.Service;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import CommandPrecess.CommandPrecess;
import usedelectron.Dao.ConnectionDao;
import usedelectron.Dto.used_boardDto;
public class DeleteFormAction implements CommandPrecess {
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			//FROM content.jsp(삭제버튼 누를시)
			try {
				//세션이 존재하면 세션값을 받는다.
				HttpSession session = request.getSession(true);
				//세션으로부터 ur_class의 값을 받는다
				int ur_class = (int) session.getAttribute("ur_class");
				//세션으로부터 ur_num의 값을 받는다
				int ur_num = (int) session.getAttribute("ur_num");
				//parameter bd_num 값을 받는다
				int bd_num = Integer.parseInt(request.getParameter("bd_num"));
				
				request.setAttribute("bd_num", bd_num);
				request.setAttribute("ur_num", ur_num);
				request.setAttribute("ur_class", ur_class);
				
				ConnectionDao cd = ConnectionDao.getInstance();
				//게시판을 삭제하기 위한 필요한 값(게시판번호, 유저번호, 유저등급)을 전달
				int result = cd.delete(bd_num, ur_num, ur_class);

				request.setAttribute("result", result);
				request.setAttribute("bd_num", bd_num);

			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			return "deleteForm.jsp";
	}
}
