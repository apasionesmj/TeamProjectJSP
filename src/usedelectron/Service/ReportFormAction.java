package usedelectron.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import CommandPrecess.CommandPrecess;

public class ReportFormAction implements CommandPrecess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int num = 0;
			if (request.getParameter("bd_num") != null) {
				num = Integer.parseInt(request.getParameter("bd_num"));
			}
			request.setAttribute("bd_num", num);
			request.setAttribute("tag_num", 11);
			
			HttpSession session = request.getSession(true);
			request.setAttribute("login_rp", session.getAttribute("ur_id"));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "khome.jsp";
	}
}
