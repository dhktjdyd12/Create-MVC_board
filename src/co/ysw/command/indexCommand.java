package co.ysw.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.ysw.common.Command;

public class indexCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ""안의 .jsp로 이동
		String path = "view/main.jsp";    // request 객체없이 단순하게 페이지만 전달하면 됨
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
//		response.sendRedirect(path);  단순하게 페이지만 전달하면 되는부분은 .do로 돌려준다.
	}

}
