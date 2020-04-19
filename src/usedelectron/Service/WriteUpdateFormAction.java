package usedelectron.Service;

import java.io.File;
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

public class WriteUpdateFormAction implements CommandPrecess {
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int fileSize=5*1024*1024;
		//업로드될 폴더 경로
		String uploadPath = request.getServletContext().getRealPath("/saveFile2");
		int result = 0;
		try {
			request.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession(true);
			String id = (String)session.getAttribute("ur_id");
				//파일 업로드
			MultipartRequest multi = new MultipartRequest(request, uploadPath,fileSize, "utf-8",new DefaultFileRenamePolicy());
				//write.jsp에서 보낸 데이터를 board로 묶어서 받음
			
			used_boardDto board = new used_boardDto();
			board.setBd_ur_id(id);
			board.setBd_title(multi.getParameter("bd_title"));
			board.setBd_sellbuy(multi.getParameter("bd_sellbuy"));
			board.setBd_write(multi.getParameter("bd_write"));
			board.setBd_image(multi.getFilesystemName("bd_image"));
			board.setBd_num(Integer.parseInt(multi.getParameter("bd_num")));
			board.setBd_price(multi.getParameter("bd_price"));
			WriteDao con = new WriteDao(); //DB
			result = con.update(board, uploadPath);
			//bd_delimage에 파일이 존재하면 실행
			
			
			request.setAttribute("write_update_result", result);
			request.setAttribute("bd_num", board.getBd_num());
		} catch(Exception e) { 
			System.out.println(e.getMessage());
		}
			return "writeUpdateForm.jsp";
		}


}
