package usedelectron.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CommandPrecess.CommandPrecess;
import usedelectron.Dao.reBoardDao;
import usedelectron.Dto.savelist_reportDto;

public class ReportProAction implements CommandPrecess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");

			savelist_reportDto board = new savelist_reportDto();
			// board.setS_r_num(request.getParameter(arg0)); -----------찜목록 및 신고게시글 id 는 고유번호이므로 나중에 sql의 도움을 받아서 설정
			
			board.setBd_num(Integer.parseInt(request.getParameter("bd_num")));//중고게시판 게시글번호
			board.setUr_id(request.getParameter("ur_id"));//회원 아이디
			board.setS_r_title(request.getParameter("s_r_title"));//게시판 제목
			board.setS_r_body(request.getParameter("s_r_body"));//게시글 내용
			board.setS_r_division(Integer.parseInt(request.getParameter("s_r_division")));//찜목록 및 신고게시판 구분
		
			//image 랑date는 없음


			reBoardDao rbd = reBoardDao.getInstance();
			int result = rbd.insert(board);
			
			request.setAttribute("num", request.getParameter("bd_num")); //form에서 넘어옴
			request.setAttribute("result", result);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "reportPro.jsp";
	}

}
