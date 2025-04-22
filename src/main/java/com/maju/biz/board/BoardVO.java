package com.maju.biz.board;

import lombok.Data;

@Data
public class BoardVO {
  private  int seq;
  private  String name;
  private  String title;
  private  String regdate;
  private  String content;
  private  int cnt;
  
  private  String ch1;
  private  String ch2;
}
