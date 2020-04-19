package usedelectron.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CommandPrecess.CommandPrecess;
import usedelectron.Dao.ConnectionDao;
import usedelectron.Dto.MemberDto;

public class ConfirmidFormAction implements CommandPrecess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ur_id = request.getParameter("ur_id");
		System.out.println("ur_id=" + ur_id);
		int result = 0;
		try {
			ConnectionDao ctd = ConnectionDao.getInstance();
			result = ctd.confirm(ur_id);
			request.setAttribute("result", result);
			request.setAttribute("ur_id", ur_id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "confirmidForm.jsp";
	}

}
