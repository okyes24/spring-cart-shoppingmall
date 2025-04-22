package com.maju.biz.shopping;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ShoppingVO {
  private  String pid   ;
  private  String pname   ;
  private  String pprice   ;
  private  String pbaesongbi   ;
  private  String pdesc   ;
  private  String pimg   ; // 테이블 컬럼명
  private  MultipartFile pimgFile   ; // 파일
  private  int     idxOrder ;
  private  String  orderG ;
  private  int     cart_id ;
  private  String  mid ;  
  private  int     amount ;
  private  String  today ;  
}
