package co.ysw.common;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Command 인터페이스의 excute()는 모든 Command 클래스들의 반드시 재정의해야함  
 */
public interface Command {
	
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;  
}
