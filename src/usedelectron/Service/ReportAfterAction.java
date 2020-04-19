package usedelectron.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CommandPrecess.CommandPrecess;
import usedelectron.Dao.ReportAfterDao;

public class ReportAfterAction implements CommandPrecess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int s_r_num = Integer.parseInt(request.getParameter("s_r_num"));
			int s_r_division = Integer.parseInt(request.getParameter("s_r_division"));
			int s_r_bd_num = Integer.parseInt(request.getParameter("s_r_bd_num"));
			ReportAfterDao con = new ReportAfterDao();
			int result = con.reportAfter(s_r_num, s_r_division, s_r_bd_num);
			
			request.setAttribute("result", result);
			request.setAttribute("num", s_r_num);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "reportAfter.jsp";
	}
	}
