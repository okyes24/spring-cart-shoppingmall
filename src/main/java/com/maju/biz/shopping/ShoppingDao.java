package com.maju.biz.shopping;

import java.util.List;

public interface ShoppingDao {
	
	  void shoppingInsert(ShoppingVO vo);
	  List<ShoppingVO> shoppingSelect(ShoppingVO vo);
	  ShoppingVO shoppingEdit(ShoppingVO vo);
	  void cartInsert(CartVO vo); 
	  List<ShoppingVO> cartList(CartVO vo);
	  List<CartVO> cartOrder(CartVO vo);
	  void orderInsert(OrderVO vo);
	  void cartDelete(CartVO vo);
	  void cartOneDelete(CartVO vo);
	  void cartUpdate(CartVO vo);
	  CartVO cartSelectOne(CartVO vo);
	  void cartUpdatePid(CartVO vo);
	  List<OrderVO> orderList(OrderVO vo);
	  List<OrderVO> orderListOne(OrderVO vo);
}
