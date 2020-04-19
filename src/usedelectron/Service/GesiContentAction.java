package usedelectron.Service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import CommandPrecess.CommandPrecess;
import usedelectron.Dao.ReplyDao;
import usedelectron.Dao.UsBoardDao;
import usedelectron.Dao.WriteDao;
import usedelectron.Dto.ReplyDto;
import usedelectron.Dto.used_boardDto;

public class GesiContentAction implements CommandPrecess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result = null;
		try {
			String num = request.getParameter("bd_num"); //"bd_num"가져오기
			if(num == null) {
				num = String.valueOf(request.getAttribute("cm_bd_num"));
			}
			
			int nums = Integer.valueOf(num);
			UsBoardDao bd = UsBoardDao.getInstance();
			ReplyDao reservice = ReplyDao.getInstance();		
			
			bd.readCount(nums);
			used_boardDto board = bd.select(nums);	
			List<ReplyDto> replylist = reservice.getrelist(nums);  
			//request속성에 값 담아주기
			request.setAttribute("replylist", replylist);
			request.setAttribute("bd_num", nums);
			request.setAttribute("board", board);
			HttpSession session = request.getSession(true);
			if(session.getAttribute("ur_id") != null) {
				request.setAttribute("tag_num", 9);
				result = "khome.jsp";
			}else {
				result = "loginCheck.jsp";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
 
}
