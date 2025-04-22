package com.maju.biz.shopping;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class OrderVO {
	  private  int     idxOrder ;
	  private  String  orderg ;
	  private  int     cart_id ;
	  private  String  mid ;
	  private  String  pid ;
	  private  int     amount ;
	  private  String  today ;
	  
	  private  String  name ;
	  private  String  tel ;
	  private  String pimg   ; // 테이블 컬럼명
	  private  MultipartFile pimgFile   ; // 파일
	  private  String pname   ;
	  private  String pprice   ;
	  private  String pdesc   ;
	  private  String addr;
	  private  String ch1;
	  private  String ch2;
	  
}
