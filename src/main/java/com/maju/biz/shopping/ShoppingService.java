package com.maju.biz.shopping;

import java.util.List;

public interface ShoppingService {
	
  void shoppingInsert(ShoppingVO vo);
  List<ShoppingVO> shoppingSelect(ShoppingVO vo);
  ShoppingVO shoppingEdit(ShoppingVO vo);
  void cartInsert(CartVO vo); 
  List<ShoppingVO> cartList(CartVO vo);
  
//  장바구니 카트의 mid 값 모두 가져오기. 
  List<CartVO> cartOrder(CartVO vo);
//  장바구니 cart의 mid값을 이용하여 저장하기
  void orderInsert(OrderVO vo);
//장바구니 cart의 mid값을 이용하여 삭제하기
  void cartDelete(CartVO vo);
  
//  장바구니에서 카트아이디를 기준으로 삭제. cart_id
  void cartOneDelete(CartVO vo);
  
//  장바구니에서 수량 수정. (전체.)
  void cartUpdate(CartVO vo);
//  중복체크
  CartVO cartSelectOne(CartVO vo);
  void cartUpdatePid(CartVO vo);
  
  List<OrderVO> orderList(OrderVO vo);
  List<OrderVO> orderListOne(OrderVO vo);
}
