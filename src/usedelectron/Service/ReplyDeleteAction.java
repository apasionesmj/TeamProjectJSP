package usedelectron.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import CommandPrecess.CommandPrecess;
import usedelectron.Dao.ReplyDao;
import usedelectron.Dto.ReplyDto;

public class ReplyDeleteAction implements CommandPrecess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
		String cm_ur_id = (String)session.getAttribute("ur_id");
		int cm_bd_num = Integer.valueOf(request.getParameter("cm_bd_num"));
		int cm_num = Integer.valueOf(request.getParameter("cm_num"));
		int cm_level = Integer.valueOf(request.getParameter("cm_level"));
		int result = 0;
		System.out.println("cm_ur_id=>" + cm_ur_id);
		System.out.println("cm_bd_num=>" + cm_bd_num);
		System.out.println("cm_num=>" + cm_num);
		System.out.println("cm_level=>" + cm_level);
		ReplyDao reply = ReplyDao.getInstance();
		ReplyDto replydto = new ReplyDto();
		replydto.setCm_bd_num(cm_bd_num);
		replydto.setCm_num(cm_num);
		replydto.setCm_level(cm_level);
		replydto.setCm_ur_id(cm_ur_id);
		result = reply.ReplyDelete(replydto);
		request.setAttribute("cm_bd_num", cm_bd_num);
		request.setAttribute("replydelete",result);
		if(result == 1) {
			System.out.println("댓글 및 답글 삭제 성공!");
		}else {
			System.out.println("실패! ==> ReplyDeleteAction");
		}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return "gesiContent.do";
	}

}
