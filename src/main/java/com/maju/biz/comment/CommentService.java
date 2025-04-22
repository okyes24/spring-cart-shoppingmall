package com.maju.biz.comment;

import java.util.List;

public interface CommentService {
	  List<CommentVO> list(CommentVO vo);
	  void insert(CommentVO vo);
	  void delete(CommentVO vo);
}
