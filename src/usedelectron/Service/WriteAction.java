package usedelectron.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import CommandPrecess.CommandPrecess;
import usedelectron.Dao.WriteDao;
import usedelectron.Dto.used_boardDto;

public class WriteAction implements CommandPrecess {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setAttribute("tag_num", 8);
			return "khome.jsp";
	}

}
