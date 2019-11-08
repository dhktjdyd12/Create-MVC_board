package co.ysw.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import co.ysw.dto.boardDTO;

public class boardDAO extends DAO {
	private boardDTO dto;
	private ArrayList<boardDTO> list;
	
	public boardDAO() {
		super();
	}
	
	public ArrayList<boardDTO> select(int id) {   // 전체 리스트  또는 한개 리스트 가져오기
		list = new ArrayList<boardDTO>();      // id = 0이면  전체 아니면 전체
		String sql = "select * from mvc_board";			
		if(id != 0) sql = "select * from mvc_board where bgroup = ?";
		try {
			psmt = conn.prepareStatement(sql);
			if (id != 0) psmt.setInt(1, id);
			rs = psmt.executeQuery();
			while(rs.next()) {
				dto = new boardDTO();
				// 이하 레코드 달기
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int insert(boardDTO dto) {
		int n=0;
		
		return n;
	}
	public int update(boardDTO dto) {
		int n=0;
		
		return n;
	}
	public int delete(int id) {
		int n=0;
		
		return n;
	}
}
