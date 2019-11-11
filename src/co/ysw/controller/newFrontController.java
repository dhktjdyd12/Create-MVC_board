package co.ysw.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.ysw.command.idChCommand;
import co.ysw.command.indexCommand;
import co.ysw.command.loginCommand;
import co.ysw.command.loginOkCommand;
import co.ysw.command.logoutCommand;
import co.ysw.command.memberDeleteCommand;
import co.ysw.command.memberInputCommand;
import co.ysw.command.memberInputOKCommand;
import co.ysw.command.memberListCommand;
import co.ysw.command.memberUpdateCommand;
import co.ysw.command.noticeCommand;
import co.ysw.command.noticeReadCommand;
import co.ysw.command.board.boardListCommand;
import co.ysw.command.notice.noticeListCommand;
import co.ysw.common.Command;

/*
 * FrontController에서 하는 중요한 역할 2개
 *  1. init()메소드로 초기화 작업(한글처리와 list put)
 *  2. service()메소드로 클라이언트가 요청할 때 마다 해당 path으 controller로 이동시켜주는 길잡이 역할
 */

@WebServlet("/newFrontController")
public class newFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String charset = null;
    HashMap<String, Command> cont = new HashMap<String, Command>();
	
    public newFrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		charset = config.getInitParameter("charset");
		
		
		// 해쉬맵 구조를 form()를 통해서 작업한다.
		cont.put("/index.do", new indexCommand());   	   		   // 홈페이지 호출
		cont.put("/login.do", new loginCommand());    	    	   // 로그인
		cont.put("/loginOK.do", new loginOkCommand());      	   // 로그인 체크
		cont.put("/logout.do", new logoutCommand());  	    	   // 로그아웃
		cont.put("/memberInput.do", new memberInputCommand());     // 회원 가입
		cont.put("/memberInputOK.do", new memberInputOKCommand()); // 회원등록 체크
		cont.put("/idCh.do", new idChCommand());                   // 아이디 중복체크
		cont.put("/memberList.do", new memberListCommand());       // 회원 목록보기
		cont.put("/memberUpdate.do", new memberUpdateCommand());   // 회원 수정
		cont.put("/memberDelete.do", new memberDeleteCommand());   // 회원 삭제
		cont.put("/noticeList.do", new noticeListCommand());       // 공지사항 목록보기
		cont.put("/boardList.do", new boardListCommand());        // 자유게시판 목록       
		cont.put("/noticeRead.do", new noticeReadCommand());      // 자유게시판 글 쓰기
//		cont.put("/noticeRead.do", new noticeReadCommand());   // 자유게시판 글 읽기
//		cont.put("/noticeList.do", new noticeListCommand());  
		
	
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 실행할class 객체를 찾아주는 부분, get메소드로
		request.setCharacterEncoding("UTF-8");       // 한글처리
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String path = uri.substring(context.length());
		
		Command commandImpl = cont.get(path);         // 실행 클래스를 선택한다
			commandImpl.excute(request, response);
	}
}
