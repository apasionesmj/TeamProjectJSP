package usedelectron.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CommandPrecess.CommandPrecess;
import usedelectron.Dao.AdminDao;

public class Admin_BenAction implements CommandPrecess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//유저를 벤하는 기능
		try {
			String ben_num = request.getParameter("ur_num_send");
			System.out.println("유저의 고유넘버=>" + ben_num);
			String ur_ben = request.getParameter("ur_ben_num");
			System.out.println("유저의 현재상태 =>" + ur_ben);
			AdminDao ad = AdminDao.getInstance();
			int result = ad.User_Ben(ben_num,ur_ben);
			if(result == 1) System.out.println("벤성공!");else {System.out.println("벤실패 =>admin_BenActionjsva!");}
			request.setAttribute("result", result);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		return "admin_UserList.do";
	}

}
