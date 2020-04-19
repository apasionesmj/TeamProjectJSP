package usedelectron.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import CommandPrecess.CommandPrecess;

public class UpdateAction implements CommandPrecess {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("tag_num", 1);
		return "khome.jsp";
	}
}