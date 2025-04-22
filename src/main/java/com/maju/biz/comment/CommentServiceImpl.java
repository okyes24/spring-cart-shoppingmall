package com.maju.biz.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements  CommentService{

	@Autowired
	private CommentDao dao;
	
	@Override
	public List<CommentVO> list(CommentVO vo) {
		return dao.list(vo);
	}

	@Override
	public void insert(CommentVO vo) {
		dao.insert(vo);		
	}

	@Override
	public void delete(CommentVO vo) {
		dao.delete(vo);		
	}

}
