/**
 * 
 */
package co.ysw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * @author 유승우 작성일자: 2019-11-7 상위 DAO 객체
 */
public class DAO {
	// 데이터베이스 접속을 위한 객체 Connection
	Connection conn = null;
	// 접속 후 질의문을 실행시킬 객체 PreparedStatement
	PreparedStatement psmt = null;
	// 질의문에 대한 결과값이 있는 객체 ResultSet
	ResultSet rs = null;
	// 컨넥션 POOL 사용을 위한 데이터연결 생성 객체 DataSource
	DataSource ds = null;    
	

//	private String driver = "oracle.jdbc.driver.OracleDriver";
//	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
//	private String user = "sw";
//	private String passwd = "sw";

	public DAO() {
//		try {
		 	// OracleSQL Driver 를 불러 들인다
//			Class.forName(driver);
		 	// 데이터베이스 커넥션을 위한 정보를 인자로 넘기며 커넥션을 얻는다.
//			conn = DriverManager.getConnection(url, user, passwd);
		
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
	
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/YooSW");     // lookup(안에 있는 것이) context.xml의 컨넥션 풀에 이름과 같아야한다.
			conn = ds.getConnection();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	// try, catch 문 실행 완료 후 실행되는 데 사용객체들을 닫아주는 메소드
	public void close() { 
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
