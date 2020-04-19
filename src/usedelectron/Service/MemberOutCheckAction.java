package usedelectron.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import CommandPrecess.CommandPrecess;

public class MemberOutCheckAction implements CommandPrecess{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = null;
		HttpSession session = request.getSession(true);
		String id = (String)session.getAttribute("ur_id");
		if(id == null || id.equals("")){
			result = "loginCheck.jsp";			
		}else {
			request.setAttribute("tag_num", 13);
			result = "khome.jsp";
		}
		return result;
	}
	
}
