package com.maju.biz.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private  MemberDao  dao;
	
	@Override
	public void insert(MemberVO vo) {
		dao.insert(vo);		
	}

	@Override
	public List<MemberVO> getMemberList(MemberVO vo) {
		return dao.getMemberList(vo);
	}

	@Override
	public MemberVO getSpwd(MemberVO vo) {
		return dao.getSpwd(vo);
	}

}
