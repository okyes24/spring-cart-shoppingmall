package com.maju.biz.member;

import java.util.List;

public interface MemberDao {
	void  insert(MemberVO vo);
	List<MemberVO>  getMemberList(MemberVO vo);
	MemberVO  getSpwd(MemberVO vo);
}
