package com.maju.biz.ckeditor;

import java.util.List;

public interface CkeditorService {
	void  insert(CkeditorVO vo); 
	List<CkeditorVO>  getCkeditorVOList(CkeditorVO vo);
	CkeditorVO  getCkeditorVO(CkeditorVO vo); 
	void  update(CkeditorVO vo); 
	void  delete(CkeditorVO vo);
}
