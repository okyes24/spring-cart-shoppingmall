package com.maju.biz.shopping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingServiceImpl implements  ShoppingService {

	@Autowired
	private ShoppingDao dao;
	
	@Override
	public void shoppingInsert(ShoppingVO vo) {
		dao.shoppingInsert(vo);
	}

	@Override
	public List<ShoppingVO> shoppingSelect(ShoppingVO vo) {
		return dao.shoppingSelect(vo);
	}

	@Override
	public ShoppingVO shoppingEdit(ShoppingVO vo) {
		// TODO Auto-generated method stub
		return dao.shoppingEdit(vo);
	}

	@Override
	public void cartInsert(CartVO vo) {
		// TODO Auto-generated method stub
		dao.cartInsert(vo);
	}

	@Override
	public List<ShoppingVO> cartList(CartVO vo) {
		// TODO Auto-generated method stub
		return dao.cartList(vo);
	}

	@Override
	public List<CartVO> cartOrder(CartVO vo) {
		// TODO Auto-generated method stub
		return dao.cartOrder(vo);
	}

	@Override
	public void orderInsert(OrderVO vo) {
		// TODO Auto-generated method stub
		dao.orderInsert(vo);
	}

	@Override
	public void cartDelete(CartVO vo) {
		// TODO Auto-generated method stub
		dao.cartDelete(vo);
	}

	@Override
	public void cartOneDelete(CartVO vo) {
		// TODO Auto-generated method stub
		dao.cartOneDelete(vo);
	}

	@Override
	public void cartUpdate(CartVO vo) {
		// TODO Auto-generated method stub
		dao.cartUpdate(vo);
	}

	@Override
	public CartVO cartSelectOne(CartVO vo) {
		// TODO Auto-generated method stub
		return dao.cartSelectOne(vo);
	}

	@Override
	public void cartUpdatePid(CartVO vo) {
		// TODO Auto-generated method stub
		dao.cartUpdatePid(vo);
	}

	@Override
	public List<OrderVO> orderList(OrderVO vo) {
		// TODO Auto-generated method stub
		return dao.orderList(vo);
	}

	@Override
	public List<OrderVO> orderListOne(OrderVO vo) {
		// TODO Auto-generated method stub
		return dao.orderListOne(vo);
	}

}
