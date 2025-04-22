package com.maju.biz.board;

import java.util.List;
import java.util.Map;

public interface BoardDao {
  void  insert(BoardVO vo); 
  void  update(BoardVO vo); 	
  void  delete(int seq); 	
  List<BoardVO>  getBoardList(BoardVO vo); 	
  BoardVO  getBoard(BoardVO vo); 
  void  cnt(BoardVO vo);
  
  Map<String, Object>  totalCount(BoardVO vo);

}
