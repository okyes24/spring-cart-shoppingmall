package com.maju.biz.psdboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PsdBoardServiceImpl implements PsdBoardService {

	@Autowired
	private  PsdBoardDao   dao ;
	
	@Override
	public void insert(PsdBoardVO vo) {
		dao.insert(vo);
		
	}

	@Override
	public List<PsdBoardVO> getSelectALL(PsdBoardVO vo) {
		// TODO Auto-generated method stub
		return dao.getSelectALL(vo);
	}

	@Override
	public void delete(PsdBoardVO vo) {
	   dao.delete(vo);		
	}

	@Override
	public PsdBoardVO getSelectONE(PsdBoardVO vo) {

		return dao.getSelectONE(vo);
	}

	@Override
	public void update(PsdBoardVO vo) {
		dao.update(vo);
		
	}

}
