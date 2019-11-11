/**
 * 
 */
package co.ysw.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import co.ysw.dto.memberDTO;

/**
 * @author 유승우 상위 DAO 클래스를 상속받아서 memberDAO를 생성
 * 1. 목록전체 조회
 * 2. 상세 조회           조회의 경우 executeQuery();
 * 3. 회원 등록           등록,수정,삭제의 경우 executeUpdate();
 * 4. 회원 정보 수정
 * 5. 회원 정보 삭제
 * 6. 회원가입창에서 아이디 중복체크
 * 7. 로그인 체크
 *
 */
public class memberDAO extends DAO {
	private memberDTO dto;
	private ArrayList<memberDTO> list;

	public memberDAO() {
		super();
	}

	public ArrayList<memberDTO> select() { // 1. 전체회원 목록갖고오기
		list = new ArrayList<memberDTO>();
		memberDTO dto = new memberDTO();
		String sql = "select * from member";

		try {
			// 커넥션 객체를 얻은 후 sql문을 데이터베이스에 요청 한다.
			psmt = conn.prepareStatement(sql);
			// 요청한 질의문을 실행 후 결과값을 받는다.
			rs = psmt.executeQuery();

			while (rs.next()) {
				dto.setId(rs.getString("memberid"));
				dto.setName(rs.getString("membername"));
				dto.setPassword(rs.getString("memberpw"));
//				dto.setGrant(rs.getc("membergrant"));
				dto.seteDate(rs.getDate("memberenterd"));
				dto.setAddress(rs.getString("memberaddress"));
				dto.setId(rs.getString("membertel"));
				list.add(dto);
			}
		// try 문 내에서 예외상황이 발생 했을 시 catch문 실행	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public memberDTO select(String id) { // 2. 1명의 회원정보를 갖고오기
		dto = new memberDTO();
		String sql = "select * from member where = ?";

		close();
		return dto;
	}

	public int insert(memberDTO dto) { // 3. 회원 등록(회원가입)
		int n = 0;
		String sql = "insert into member(memberid, membername, memberpw, memberaddress, membertel)"
				+ " values(?, ?, ?, ?, ?)";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getPassword());
			psmt.setString(4, dto.getAddress());
			psmt.setString(5, dto.getTel());
			n = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return n;
	}

	public int update(memberDTO dto) { // 4.회원정보 수정
		int n = 0;
//		String sql = "update member set  ";

		close();
		return n;
	}

	public int delete(String id) { // 5. 회원 삭제
		int n = 0;
		String sql = "delete from member where memberid=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return n;
	}

	public boolean isIdCheck(String id) { // 6. 회원가입시 id 중복체크를 함
		boolean bol = true;
		String sql = "select * from member where memberid = ?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				bol = false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bol;
	}

	public String loginCheck(String id, String password) { // 7. 로그인 체크
		String grant = null;
		String sql = "select membergrant from member where memberid=? and memberpw=?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, password);
			rs = psmt.executeQuery();

			if (rs.next()) {
				grant = rs.getString("membergrant");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return grant; // 로그인 성공시 권한을 넘겨준다
	}
}
