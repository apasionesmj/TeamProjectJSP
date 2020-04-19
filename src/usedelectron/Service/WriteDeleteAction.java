package usedelectron.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CommandPrecess.CommandPrecess;
import usedelectron.Dao.WriteDao;

public class WriteDeleteAction implements CommandPrecess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int bd_num = Integer.parseInt(request.getParameter("bd_num"));
			WriteDao con = new WriteDao();
			int result = con.delete(bd_num);

			request.setAttribute("result", result);
			request.setAttribute("bd_num", bd_num);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "khome.do";
	}

}
