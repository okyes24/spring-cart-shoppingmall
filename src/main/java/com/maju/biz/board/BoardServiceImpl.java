package com.maju.biz.board;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDaoImpl dao ;
	
	@Override
	public void insert(BoardVO vo) {
		dao.insert(vo);
		
	}

	@Override
	public void update(BoardVO vo) {
		dao.update(vo);
		
	}

	@Override
	public void delete(int seq) {
		dao.delete(seq);
		
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		
		return dao.getBoardList(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		
		return dao.getBoard(vo);
	}

	@Override
	public void cnt(BoardVO vo) {
		dao.cnt(vo);		
	}

	@Override
	public Map<String, Object> totalCount(BoardVO vo) {
		
			return dao.totalCount(vo);
	}



}
