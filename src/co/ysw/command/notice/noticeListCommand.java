package co.ysw.command.notice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.ysw.common.Command;
import co.ysw.dao.noticeDAO;
import co.ysw.dto.noticeDTO;

public class noticeListCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		noticeDAO dao = new noticeDAO();
		ArrayList<noticeDTO> list = new ArrayList<noticeDTO>();

		// 전체 리스트 갖고오기
		list = dao.select();
		
		request.setAttribute("list", list);
		
		String path = "view/noticeList.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
}
