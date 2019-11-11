package co.ysw.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.ysw.common.Command;
import co.ysw.dao.memberDAO;

public class memberInputCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// Parameter 추출
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");


		// request가 유지되는 동안 request에 데이터를 저장
		request.setAttribute("id", id);
		

		String path = "view/memberInput.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		
		// request, response 를 주는 이유는 어떤 아이디가 저장되었는지 다시 보여주기 위해 정보를 넘기는 것
		dispatcher.forward(request, response);
	}
}
