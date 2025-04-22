package com.maju.biz.comment;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDaoImpl implements CommentDao {
	
	@Autowired
	private SqlSessionTemplate  mybatis;
	
	@Override
	public List<CommentVO> list(CommentVO vo) {
		return mybatis.selectList("COMMENT.SELECT", vo);
	}

	@Override
	public void insert(CommentVO vo) {
		mybatis.insert("COMMENT.INSERT", vo);
	}

	@Override
	public void delete(CommentVO vo) {
		mybatis.delete("COMMENT.DELETE", vo);
	}

}
