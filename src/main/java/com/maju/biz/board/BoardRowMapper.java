package com.maju.biz.board;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

class BoardRowMapper implements RowMapper<BoardVO>{

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO m=new BoardVO();
		m.setSeq(rs.getInt("seq"));
		m.setTitle(rs.getString("title"));
		m.setName(rs.getString("name"));
		m.setContent(rs.getString("content"));
		m.setRegdate(rs.getString("regdate"));
		m.setCnt(rs.getInt("cnt"));
		
		return m;
	}
	
}