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

public class WriteFormAction implements CommandPrecess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//업로드 파일 사이즈
				int fileSize=5*1024*1024;
				//업로드될 폴더 경로
				String uploadPath = request.getServletContext().getRealPath("/saveFile2");
				try {
					request.setCharacterEncoding("utf-8");
					HttpSession session = request.getSession(true);
					String id = (String)session.getAttribute("ur_id");
					int ur_num = (int)session.getAttribute("ur_num");
					//파일 업로드 (리퀘스트, 경로, 사이즈, 중복시 뒤에 번호 붙여서 새로히 저장)
					MultipartRequest multi = new MultipartRequest(request, uploadPath,fileSize, "utf-8",new DefaultFileRenamePolicy());
					
					//write.jsp에서 보낸 데이터를 board로 묶어서 받음
					used_boardDto board = new used_boardDto();
					board.setBd_ur_id(id);
					board.setUr_num(ur_num);
					board.setBd_title(multi.getParameter("bd_title"));
					board.setBd_sellbuy(multi.getParameter("bd_sellbuy"));
					board.setBd_write(multi.getParameter("bd_write"));
					board.setBd_image(multi.getFilesystemName("bd_image"));
					board.setBd_price(multi.getParameter("bd_price"));
					WriteDao con = new WriteDao(); //DB
					int result = con.WriteInsert(board);
					request.setAttribute("result", result);
				} catch(Exception e) { System.out.println(e.getMessage());}
				return "WriteForm.jsp";
	}

}
