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




public class Re_Reply implements CommandPrecess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			//한글출력 코드
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=utf-8");
			HttpSession session = request.getSession(true);
			//필요한 정보(댓글 내용,댓글 고유ID,유저 ID) 3개			
				String cm_body = request.getParameter("re_body"); //대댓글 내용
				String ur_ID = (String)session.getAttribute("ur_id");
				String cm_bd_num = request.getParameter("bd_num"); //연동 게시판 번호
				String parientid = request.getParameter("cm_num"); //댓글 고유 번호
				
				System.out.println("cm_body ============" + cm_body);
				System.out.println("ur_ID===========" + ur_ID);
				System.out.println("cm_bd_num===========" + cm_bd_num);
				System.out.println("parientid==========" + parientid);
				
			if( cm_body != "") {
				
				
				//1.DTO에 넣기
				ReplyDto reply = new ReplyDto();
				reply.setCm_ur_id(ur_ID);
				reply.setCm_body(cm_body);
				reply.setCm_bd_num(Integer.parseInt(cm_bd_num));//연동 게시글 번호
				
				//2. 부모 댓글 정보 가져오기
				ReplyDao service = new ReplyDao();
				ReplyDto parinfo = service.getrerelist(Integer.parseInt(parientid));
				
				//3. 답글 등록하기
				service.rereadd(reply,parinfo);
				
				//4. 답글 추가 업데이트
				service.reupdate(parinfo);
				
				
				//5.게시글 보기로 넘어가기
				return "gesiContent.do?bd_num=" + cm_bd_num ;

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
