package usedelectron.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import javax.websocket.Session;
import javax.servlet.http.HttpSession;

import CommandPrecess.CommandPrecess;
import usedelectron.Dao.BoardDao;

public class FavoriteAction implements CommandPrecess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int result =0;
		try {
		HttpSession session = request.getSession(true);
		String ur_id = (String)session.getAttribute("ur_id");
		BoardDao bd = BoardDao.getInstance();
		int bd_num = Integer.valueOf(request.getParameter("bd_num")); //중고테이블 고유번호	
		result = bd.favoriteoverlap(bd_num, ur_id);
		
		if(result == 1) {
			result = bd.favorite(bd_num,ur_id);//추가
			System.out.println("찜목록 등록완료!" + result);
		} else {
			System.out.println("찜목록에 같은 값이 있음 =>favoriteAction.java");
		}	
		
		request.setAttribute("favorite_result", result);
		request.setAttribute("bd_num", bd_num);
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "favoriteForm.jsp";//게시판으로 리다이렉션
	}

}
