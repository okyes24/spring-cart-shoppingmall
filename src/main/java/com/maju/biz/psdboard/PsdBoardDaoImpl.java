package com.maju.biz.psdboard;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PsdBoardDaoImpl implements PsdBoardDao {

	@Autowired
	private SqlSessionTemplate  mybatis;

	@Override
	public void insert(PsdBoardVO vo) {		
		mybatis.insert("PsdBoard.INSERT", vo);		
	}

	@Override
	public List<PsdBoardVO> getSelectALL(PsdBoardVO vo) {
		return mybatis.selectList("PsdBoard.SELECTALL", vo);
	}

	@Override
	public void delete(PsdBoardVO vo) {
		mybatis.delete("PsdBoard.DELETE", vo);		
	}

	@Override
	public PsdBoardVO getSelectONE(PsdBoardVO vo) {
		return mybatis.selectOne("PsdBoard.SELECTONE", vo);
	}

	@Override
	public void update(PsdBoardVO vo) {		
		System.out.println("===> update(PsdBoardVO vo)" + vo);		
		if (vo.getUploadFileStr() == null) {
			mybatis.update("PsdBoard.UPDATE", vo);	
			System.out.println("파일 없는 경우");
		}else{
			mybatis.update("PsdBoard.UPDATEFILE", vo);
			System.out.println("파일 있는 경우");
		}		
	}

}
