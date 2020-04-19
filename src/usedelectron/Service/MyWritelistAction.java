package usedelectron.Service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CommandPrecess.CommandPrecess;
import usedelectron.Dao.WriteDao;
import usedelectron.Dto.used_boardDto;

public class MyWritelistAction implements CommandPrecess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
		used_boardDto board = new used_boardDto();
		WriteDao con = new WriteDao();
		int totCnt = con.getTotalCnt();
		
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null || pageNum.equals("")) { pageNum = "1"; }
		int currentPage = Integer.parseInt(pageNum); 
		int pageSize = 40, blockSize=10;
		int startRow = (currentPage - 1) * pageSize + 1; 
		int endRow = startRow + pageSize - 1;	
		int startNum = totCnt - startRow + 1;
		List<used_boardDto> list = con.list(startRow, endRow);
		int pageCnt = (int)Math.ceil((double)totCnt/pageSize);
		request.setAttribute("totCnt", totCnt);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("startNum", startNum);
		request.setAttribute("MW_list", list);
		request.setAttribute("blockSize", blockSize);
		request.setAttribute("pageCnt", pageCnt);	
		
		request.setAttribute("tag_num", 2);
		} catch(Exception e) { System.out.println(e.getMessage());}
		return "khome.jsp";	
	}
}
