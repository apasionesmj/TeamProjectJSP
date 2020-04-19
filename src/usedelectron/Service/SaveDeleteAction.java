package usedelectron.Service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import CommandPrecess.CommandPrecess;
import usedelectron.Dao.BoardDao;

public class SaveDeleteAction implements CommandPrecess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("UTF-8");
			String bd_num = request.getParameter("bd_num");
			BoardDao bd = BoardDao.getInstance();
			int result = bd.saveDelete(bd_num);
			request.setAttribute("deleteResult", result);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return "favoriteshow.do";
	}

}
