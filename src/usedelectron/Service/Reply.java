package usedelectron.Service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import CommandPrecess.CommandPrecess;
import usedelectron.Dao.ReplyDao;
import usedelectron.Dto.ReplyDto;




public class Reply implements CommandPrecess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			HttpSession session = request.getSession(true);
			
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=utf-8");
		
		
			//필요한 정보(댓글 내용,댓글 고유ID,유저 ID) 3개			
			String cm_body = request.getParameter("replycontent"); //댓글내용
			String ur_ID = (String)session.getAttribute("ur_id");
			String cm_bd_num = request.getParameter("bd_num");
				
			
			if( cm_body != "") {
				
				
				//1.DTO에 넣기
				ReplyDto reply = new ReplyDto();
				reply.setCm_ur_id(ur_ID);
				reply.setCm_body(cm_body);
				reply.setCm_bd_num(Integer.parseInt(cm_bd_num));//연동 게시글 번호
				
				//2.댓글 삽입 DAO 실행
				ReplyDao service = new ReplyDao();
				service.readd(reply);  //파라미터로 넣기
				
				//3.게시글 보기로 넘어가기
				return "gesiContent.do?num=" + cm_bd_num ;
			
			} else {
				//댓글 내용이 공백
				PrintWriter out  = response.getWriter();
				
				out.print("<script>");
				out.print("alert('댓글 내용에 공백이 존재합니다.');");
				out.print("window.history.back();");
				out.print("</script>");
				out.close();
			}
			//리턴으로 content 넘어가는 것 확인 쿼리스트링 값 넣어주기
		return "gesiContent.do";
	}

}
