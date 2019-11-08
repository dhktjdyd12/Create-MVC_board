package co.ysw.common;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;  
}
