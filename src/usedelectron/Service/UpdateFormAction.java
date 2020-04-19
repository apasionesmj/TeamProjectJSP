package usedelectron.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import CommandPrecess.CommandPrecess;
import usedelectron.Dao.ConnectionDao;
import usedelectron.Dto.MemberDto;

public class UpdateFormAction implements CommandPrecess {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result = 0;
		String ur_id = null;
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			MemberDto mbt = new MemberDto();
			ConnectionDao ctd = ConnectionDao.getInstance();
			String ur_passwd = request.getParameter("ur_passwd");
			HttpSession session = request.getSession(true);
			if(ur_passwd.equals(session.getAttribute("ur_passwd"))) {
				ur_id = (String)session.getAttribute("ur_id");
				mbt.setUr_passwd(request.getParameter("ur_passwd1"));
				mbt.setUr_adress(request.getParameter("ur_address"));
				mbt.setUr_phone(request.getParameter("ur_phone"));	
				mbt.setUr_id(ur_id);
				result = ctd.update(mbt);
				if(result == 1) {
					session.invalidate();
				}
				request.setAttribute("result", result);
				request.setAttribute("ur_id", ur_id);
			}else {
				System.out.println("비밀번호가 틀림");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "updateForm.jsp";

	}

}