package usedelectron.Service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import CommandPrecess.CommandPrecess;
import usedelectron.Dao.ConnectionDao;
import usedelectron.Dto.used_boardDto;

public class KhomeAction implements CommandPrecess {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConnectionDao cd = ConnectionDao.getInstance();
		try {
			HttpSession session = request.getSession(true);
			
			/*totCnt에 DB의 총 갯수를 넣는다*/
			int totCnt = cd.getTotalCnt();
			/*pageNum에 pageNum의 값을 넣는다*/
			String pageNum = request.getParameter("pageNum");
			/*pageNum이 널이거나 없으면 pageNum에 1을 넣는다*/ 
			if(pageNum==null || pageNum.equals("")) {
				pageNum="1";
			}
			
			/*pageNum을 Integer로 변환해서 currentPage에 넣는다*/
			int currentPage = Integer.parseInt(pageNum);			
			int pageSize = 10;
			int blockSize = 10;
			/*DB에서 between(검색)의 값으로 startRow과 startRow을 지정
			행의 갯수 지정*/
			int startRow = (currentPage - 1) * pageSize + 1;
			int endRow = startRow + pageSize -1;
			int startNum = totCnt - startRow + 1;

			// list 함수에 startRow, endRow의 매개 변수에 값을 넘겨준다.
			List<used_boardDto> board_list = cd.board_list(startRow, endRow);
			
			/*page 수*/
			int pageCnt = (int) Math.ceil((double)totCnt/pageSize);
			int startPage = (int)(currentPage-1)/blockSize*blockSize+1;
			int endPage = startPage + blockSize - 1;

			if(endPage>pageCnt)
				endPage = pageCnt;
			
			//totCnt 값을 totCnt로 저장한다.
			request.setAttribute("totCnt", totCnt);
			//pageNum 값을 pageNum로 저장한다.
			request.setAttribute("pageNum", pageNum);
			//currentPage 값을 currentPage로 저장한다.
			request.setAttribute("currentPage", currentPage);
			//startNum 값을 startNum로 저장한다.
			request.setAttribute("startNum", startNum);
			//list 값을 list로 저장한다.
			request.setAttribute("board_list", board_list);
			//blockSize 값을 blockSize로 저장한다.
			request.setAttribute("blockSize", blockSize);
			//pageCnt 값을 pageCnt로 저장한다.
			request.setAttribute("pageCnt", pageCnt);
			//paging 시작 변수 startPage를 startPage로 저장한다.
			request.setAttribute("startPage", startPage);
			//paging 끝 변수 endPage를 endPage로 저장한다.
			request.setAttribute("endPage", endPage);
			int loginResult = (int)session.getAttribute("loginResult");
			if(loginResult == 1) {
				request.setAttribute("loginResult", loginResult);
			}else {
				request.setAttribute("loginResult", 0);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		return "khome.jsp";
	}
}
