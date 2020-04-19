package usedelectron.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import CommandPrecess.CommandPrecess;
import usedelectron.Dao.ConnectionDao;
import usedelectron.Dto.MemberDto;

public class MemberOutFormAction implements CommandPrecess{

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int outCheck = 0;
		String result = null;
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");			
			HttpSession session = request.getSession(true);
			String id = (String)session.getAttribute("ur_id");
			if(id == null || id.equals("")){
				result = "membeOut.jsp";
			}else {
				result = "memberOutForm.jsp";
			}	
			ConnectionDao ctd = ConnectionDao.getInstance();
			String ur_passwd = request.getParameter("ur_passwd");	
			String ur_passwd1 = request.getParameter("ur_passwd1");
			MemberDto mbt = new MemberDto(id, ur_passwd);
			outCheck = ctd.memberOut(mbt);
			if(outCheck == 1) {
				session.invalidate();
			}
			request.setAttribute("outCheck", outCheck);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return result;

	}
	
}
