package com.maju.biz.member;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	private SqlSessionTemplate  mybatis;

	@Override
	public void insert(MemberVO vo) {
		mybatis.insert("MEMBER.INSERT", vo);
		
	}

	@Override
	public List<MemberVO> getMemberList(MemberVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectList("MEMBER.LIST", vo);
	}

	@Override
	public MemberVO getSpwd(MemberVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("MEMBER.SPWD", vo);
	}

}
