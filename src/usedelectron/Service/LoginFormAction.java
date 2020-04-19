package usedelectron.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import CommandPrecess.CommandPrecess;
import usedelectron.Dao.ConnectionDao;
import usedelectron.Dto.MemberDto;


public class LoginFormAction implements CommandPrecess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String ur_id = request.getParameter("ur_id");
			String ur_passwd = request.getParameter("ur_passwd");
			ConnectionDao ctd = ConnectionDao.getInstance();
			MemberDto mbt = new MemberDto(ur_id, ur_passwd);
			int result = ctd.login(mbt); 
			MemberDto mbt2 = ctd.loginGet(mbt);
			request.setAttribute("result", result);
			// 세션 생성
			HttpSession session = request.getSession(true);	
			session.setAttribute("ur_id", mbt2.getUr_id());
			session.setAttribute("ur_passwd", mbt2.getUr_passwd());
			session.setAttribute("ur_name", mbt2.getUr_name());
			session.setAttribute("ur_address", mbt2.getUr_address());
			session.setAttribute("ur_phone", mbt2.getUr_phone());
			session.setAttribute("loginResult", result);
			session.setAttribute("ur_class", mbt2.getUr_class());
			session.setAttribute("ur_num", mbt2.getUr_num());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
		return "loginForm.jsp";
	}
}