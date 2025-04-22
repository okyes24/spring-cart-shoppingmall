package com.maju.biz.shopping;

import lombok.Data;

@Data
public class CartVO {
	private  int cart_id;  // P.K
	private  String mid;   // 주문자 P.K
	private  String pid;   // 상품의 P.K
	private  int  amount;  // 수량
	private  String pay;   // 상품의 P.K
}
