package co.ysw.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.ysw.common.Command;
import co.ysw.dao.boardDAO;
import co.ysw.dto.boardDTO;

public class noticeReadCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// dto 선언
		boardDTO dto = new boardDTO();
		// dao 호출
		boardDAO dao = new boardDAO();

		String path = "view/boardRead.jsp";
//		request.setAttribute("dto", do);  // DB에서 조회글 달기
		
		
		// 처리 결과 페이지로 이동하기 위해 Requestdipatcher 객체를 생성한후
		// forward() 메소드로 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

}
