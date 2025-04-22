package com.maju.biz.psdboard;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class PsdBoardVO {
  private  int seq;
  private  String write;
  private  String title;
  private  int age;
  private  String regdate;
  private  String content;
    
  private  MultipartFile uploadFile;  
  private  String  uploadFileStr; 
  
  private  int cnt;
}
