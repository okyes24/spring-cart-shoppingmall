package com.maju.biz.psdboard;

import java.util.List;

public interface PsdBoardDao {
	void  insert(PsdBoardVO vo);
	void  delete(PsdBoardVO vo);
	void  update(PsdBoardVO vo);
	
	PsdBoardVO getSelectONE(PsdBoardVO vo);
	List<PsdBoardVO> getSelectALL(PsdBoardVO vo);
}
