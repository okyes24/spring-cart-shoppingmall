package com.maju.biz.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSessionTemplate  mybatis;

	@Override
	public void insert(BoardVO vo) {		
		mybatis.insert("Board.INSERT", vo);		
	}

	@Override
	public void update(BoardVO vo) {	
		
		mybatis.update("Board.UPDATE", vo);			
	}

	@Override
	public void delete(int  seq) {		
		mybatis.delete("Board.DELETE", seq);			
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		vo.setCh2("%"+vo.getCh2()+"%");
		return mybatis.selectList("Board.SELECTALL", vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {		
		return  mybatis.selectOne("Board.SELECTONE", vo);
	}

	@Override
	public void cnt(BoardVO vo) {
		mybatis.update("Board.CNT", vo);	
	}

	@Override
	public Map<String, Object> totalCount(BoardVO vo) {
		vo.setCh2("%"+vo.getCh2()+"%");		
		int k = mybatis.selectOne("Board.TOTALCOUNT", vo);	

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalCount", k);
		map.put("admin", "영심이");
		map.put("age", 11);
		return map ;
	}

}

