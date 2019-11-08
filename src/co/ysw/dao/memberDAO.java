/**
 * 
 */
package co.ysw.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import co.ysw.dto.memberDTO;

/**
 * @author 유승우 상위 DAO 클래스를 상속받아서 memberDAO를 생성
 *
 */
public class memberDAO extends DAO {
	private memberDTO dto;
	private ArrayList<memberDTO> list;

	public memberDAO() {
		super();
	}

	public ArrayList<memberDTO> select() { // 전체회원 목록갖고오기
		list = new ArrayList<memberDTO>();
		memberDTO dto = new memberDTO();
		String sql = "select * from member";

		try {
			psmt = conn.prepareStatement(sql);
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public memberDTO select(String id) { // 1명의 회원정보를 갖고오기
		dto = new memberDTO();
		String sql = "select * from member where = ?";

		close();
		return dto;
	}

	public int insert(memberDTO dto) { // 회원 추가(회원가입)
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

	public int update(memberDTO dto) { // 회원정보 수정
		int n = 0;
//		String sql = "update member set  ";

		close();
		return n;
	}

	public int delete(String id) { // 회원 삭제
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

	public boolean isIdCheck(String id) { // id 중복체크를 함
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

	public String loginCheck(String id, String password) { // 로그인 체크
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
