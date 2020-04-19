package CommandPrecess;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandPrecess {
	//Service를 만들때 꼭 상속할것!
	public String requestPro(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException;
}
