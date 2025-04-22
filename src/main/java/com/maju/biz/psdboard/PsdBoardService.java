package com.maju.biz.psdboard;

import java.util.List;

public interface PsdBoardService {
   void  insert(PsdBoardVO vo);
   void  delete(PsdBoardVO vo);
   void  update(PsdBoardVO vo);
   
   List<PsdBoardVO> getSelectALL(PsdBoardVO vo);
   PsdBoardVO getSelectONE(PsdBoardVO vo);
}
