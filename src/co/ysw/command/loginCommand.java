package co.ysw.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.ysw.common.Command;
import co.ysw.dao.memberDAO;

public class loginCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "view/loginForm.jsp";  // 로그인 폼 호출
		
//		ServletRequest의 getRequestDispatcher()메소드는 Request를 넘길(foward) 자원에 대한 경로(String)를
//		인자로 한다. 경로가 /로 시작하는 경우 컨테이너는 "웹 애플리케이션의 루트로 시작하는군" 이라고 생각하며,
//		/로 시작하지 않으면 "원래 Request의 경로에  상대경로로 시작하는 군" 이라고 생각한다.
//		또한 현재 웹 애플리케이션의 루트 경로보다 상위 경로로 빠져 나가 다른 곳으로 경로를 지정할수 없다
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		
//		Request로부터 리턴받았든, 컨텍스트로부터 리턴받았든지간에 RequestDispatcher는 Request를 넘길 자원이 무엇인지
//		이미 알고있다. 이미 getRequestDispatcher() 메소드의 인자로 이를 넘겼기떄문이다.
//		그렇기떄문에 단지 forward()에 request와 response를 넣어 명시한 컴포넌트로 넘기기만 하면 된다
		dispatcher.forward(request, response);
	}

}
