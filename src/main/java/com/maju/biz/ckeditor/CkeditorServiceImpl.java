package com.maju.biz.ckeditor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maju.biz.board.BoardDaoImpl;
import com.maju.biz.ckeditor.CkeditorVO;
@Service
public class CkeditorServiceImpl implements CkeditorService{
	@Autowired
	private CkeditorDaoImpl dao ;

	@Override
	public void insert(CkeditorVO vo) {
		// TODO Auto-generated method stub
		dao.insert(vo);
	}

	@Override
	public List<CkeditorVO> getCkeditorVOList(CkeditorVO vo) {
		// TODO Auto-generated method stub
		return dao.getCkeditorVOList(vo);
	}

	@Override
	public CkeditorVO getCkeditorVO(CkeditorVO vo) {
		// TODO Auto-generated method stub
		return dao.getCkeditorVO(vo);
	}

	@Override
	public void update(CkeditorVO vo) {
		// TODO Auto-generated method stub
		dao.update(vo);
	}

	@Override
	public void delete(CkeditorVO vo) {
		// TODO Auto-generated method stub
		dao.delete(vo);
	}
}
