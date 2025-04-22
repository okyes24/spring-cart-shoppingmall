package com.maju.biz.ckeditor;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class CkeditorVO {
	private int idx;
	private String title;
	private String name;
	private String etc;
	private String today;
	private String filename;
	private  MultipartFile uploadFile;
	
}
