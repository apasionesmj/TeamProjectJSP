package usedelectron.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CommandPrecess.CommandPrecess;
import usedelectron.Dao.WriteDao;
import usedelectron.Dto.used_boardDto;

public class WriteUpdateBtnAction implements CommandPrecess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int bd_num = Integer.parseInt(request.getParameter("bd_num"));
//			String pageNum = request.getParameter("pageNum"); //페이지
			WriteDao con = new WriteDao();
			used_boardDto board = con.select(bd_num);

			request.setAttribute("bd_num", bd_num);
//			request.setAttribute("pageNum", pageNum); //페이지
			request.setAttribute("board", board);
			request.setAttribute("tag_num", 14);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "khome.jsp";
	}

}
