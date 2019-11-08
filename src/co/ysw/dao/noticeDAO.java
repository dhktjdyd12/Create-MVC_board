package co.ysw.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import co.ysw.dto.noticeDTO;

public class noticeDAO extends DAO {
	ArrayList<noticeDTO> list;
	noticeDTO dto;
	
	public noticeDAO() {
		super();
	}
	public ArrayList<noticeDTO> select() {   // 전체 리스트  또는 한개 리스트 가져오기
		list = new ArrayList<noticeDTO>();      // id = 0이면  전체 아니면 전체
		String sql = "select * from notice";			
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				dto = new noticeDTO();
				dto.setId(rs.getInt("nid"));
				dto.setTitle(rs.getString("ntitle"));
				dto.setContents(rs.getString("ncontents"));
				dto.setnDate(rs.getDate("ndate"));
				dto.setHit(rs.getInt("nhit"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public noticeDTO select(int id) {   // 세부내용 보기
		return dto;
	}
	public int insert(noticeDTO dto) {
		int n=0;
		
		return n;
	}
	public int update(noticeDTO dto) {
		int n=0;
		
		return n;
	}
	public int delete(int id) {
		int n=0;
		
		return n;
	}

}
