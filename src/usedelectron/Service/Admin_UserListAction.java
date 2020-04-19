package usedelectron.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CommandPrecess.CommandPrecess;
import usedelectron.Dao.AdminDao;
import usedelectron.Dto.MemberDto;

public class Admin_UserListAction implements CommandPrecess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//유저 리스트를 뽑아오는 기능
		try {
			List<MemberDto> list = new ArrayList<MemberDto>();
			AdminDao ad = AdminDao.getInstance();
			list = ad.memberSelect();
			request.setAttribute("member_list",list );
			request.setAttribute("tag_num", 3);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		return "khome.jsp";
	}

}
