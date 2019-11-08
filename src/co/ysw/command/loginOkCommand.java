package co.ysw.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.ysw.common.Command;
import co.ysw.dao.memberDAO;

public class loginOkCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		memberDAO dao = new memberDAO();

		// 로그인 화면에 입력된 아이디와 비밀번호를 가져온다
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// DB에서 아이디, 비밀번호 확인
		String grant = dao.loginCheck(id, pw);

		if (grant == null) {   // id와 pw가 일치하지않다면
			response.sendRedirect("login.do");  
		} else {   	// 로그인 성공하면 (id와 pw가 일치) ""안의 페이지로 이동
			HttpSession httpsession = request.getSession(); // 자바객체를 이용해서 session객체를 이용할 떄
			httpsession.setAttribute("id", id);
			httpsession.setAttribute("grant", grant);

			response.sendRedirect("index.do");
		}
	}
}
