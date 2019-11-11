package co.ysw.command.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.ysw.common.Command;
import co.ysw.dao.boardDAO;
import co.ysw.dto.boardDTO;

public class boardListCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// dto 선언
		boardDTO dto = new boardDTO();
		// dao 호출
		boardDAO dao = new boardDAO();
		// 돌려줄 페이지 선택
		String path = "view/boardList.jsp";
		
		// 디스패치
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
}
