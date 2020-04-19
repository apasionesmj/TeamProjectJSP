package usedelectron.Service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import CommandPrecess.CommandPrecess;
import usedelectron.Dao.ConnectionDao;
import usedelectron.Dto.MemberDto;

public class SignUpFormAction implements CommandPrecess {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			ConnectionDao ctd = ConnectionDao.getInstance();
			String name = request.getParameter("ur_name");
			String id = request.getParameter("ur_id");
			String passwd = request.getParameter("ur_passwd");
			String address = request.getParameter("ur_address");
			String phone = request.getParameter("ur_phone"); 
			String ur_ip = request.getRemoteAddr();
			MemberDto mbt = new MemberDto(id, passwd, name, phone, ur_ip, address);
			
			int result = ctd.signUp(mbt);

			request.setAttribute("result", result);
			request.setAttribute("ur_id", id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "signUpForm.jsp";
	}

}