package com.maju.biz.psdboard;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

class PsdBoardRowMapper implements RowMapper<PsdBoardVO>{

	@Override
	public PsdBoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		PsdBoardVO m=new PsdBoardVO();
		m.setSeq(rs.getInt("seq"));
		m.setTitle(rs.getString("title"));
		m.setWrite(rs.getString("write"));
		m.setContent(rs.getString("content"));
		m.setRegdate(rs.getString("regdate"));
		m.setAge(rs.getString("age"));
		m.setCnt(rs.getInt("cnt"));
		m.setUploadFilestr(rs.getString("uploadFilestr"));
		
		
		return m;
	}
	
}