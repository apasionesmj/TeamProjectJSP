package usedelectron.Service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CommandPrecess.CommandPrecess;
import usedelectron.Dao.ReportGesiDao;
import usedelectron.Dto.ReportGesiDto;

public class ReportGesiListAction implements CommandPrecess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			ReportGesiDao con = new ReportGesiDao();

			List<ReportGesiDto> list = con.reportGesi();
			
			request.setAttribute("reportGesi_list", list);
			request.setAttribute("tag_num", 7);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "khome.jsp";
	}
}