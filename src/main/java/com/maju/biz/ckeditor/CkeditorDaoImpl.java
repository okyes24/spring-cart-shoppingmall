package com.maju.biz.ckeditor;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CkeditorDaoImpl implements CkeditorDao{
	@Autowired
	private SqlSessionTemplate  mybatis;

	@Override
	public void insert(CkeditorVO vo) {
		// TODO Auto-generated method stub
		mybatis.insert("Ckeditor.INSERT", vo);
	}

	@Override
	public List<CkeditorVO> getCkeditorVOList(CkeditorVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectList("Ckeditor.SELECTALL", vo);
	}

	@Override
	public CkeditorVO getCkeditorVO(CkeditorVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("Ckeditor.SELECTONE", vo);
	}

	@Override
	public void update(CkeditorVO vo) {
		// TODO Auto-generated method stub
		
		if (vo.getFilename() == null) {
			mybatis.update("Ckeditor.UPDATE", vo);	
			System.out.println("파일 없는 경우");
		}else{
			mybatis.update("Ckeditor.UPDATEFILE", vo);
			System.out.println("파일 있는 경우");
		}		
	}

	@Override
	public void delete(CkeditorVO vo) {
		// TODO Auto-generated method stub
		mybatis.delete("Ckeditor.DELETE", vo);
	}
}
