package usedelectron.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

import CommandPrecess.CommandPrecess;
import usedelectron.Dao.BoardDao;
import usedelectron.Dto.savelist_reportDto;
//import usedelectron.Dto.used_boardDto;

public class FavoriteProAction implements CommandPrecess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
		HttpSession session = request.getSession(true);
		String id = (String)session.getAttribute("ur_id");
		List<savelist_reportDto> list = new ArrayList<savelist_reportDto>();
//		String id = request.getParameter("ur_id");//세션아이디로 대체해준다.
		BoardDao bd = BoardDao.getInstance();
		list = bd.favoriteShow(id);
		request.setAttribute("list", list);
		request.setAttribute("tag_num", 0);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "khome.jsp";
	}

}
