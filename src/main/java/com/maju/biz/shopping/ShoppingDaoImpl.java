package com.maju.biz.shopping;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShoppingDaoImpl implements ShoppingDao {

	@Autowired
	private SqlSessionTemplate  mybatis;
	
	@Override
	public void shoppingInsert(ShoppingVO vo) {
		mybatis.insert("SHOPPING.SHOPPINGINSERT", vo);		
	}

	@Override
	public List<ShoppingVO> shoppingSelect(ShoppingVO vo) {		
		return mybatis.selectList("SHOPPING.SHOPPINGSELECT", vo);
	}

	@Override
	public ShoppingVO shoppingEdit(ShoppingVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("SHOPPING.SHOPPINGEDIT", vo);
	}

	@Override
	public void cartInsert(CartVO vo) {
		// TODO Auto-generated method stub
		mybatis.insert("SHOPPING.CARTINSERT",vo);
	}

	@Override
	public List<ShoppingVO> cartList(CartVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectList("SHOPPING.CARTSELECT",vo);
	}

	@Override
	public List<CartVO> cartOrder(CartVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectList("SHOPPING.CARTORDER",vo);
	}

	@Override
	public void orderInsert(OrderVO vo) {
		// TODO Auto-generated method stub
		mybatis.insert("SHOPPING.ORDERINSERT",vo);
	}

	@Override
	public void cartDelete(CartVO vo) {
		// TODO Auto-generated method stub
		mybatis.delete("SHOPPING.ORDERDELETE",vo);
	}

	@Override
	public void cartOneDelete(CartVO vo) {
		// TODO Auto-generated method stub
		mybatis.delete("SHOPPING.CARTONEDELETE", vo);
	}

	@Override
	public void cartUpdate(CartVO vo) {
		// TODO Auto-generated method stub
		mybatis.update("SHOPPING.CARTUPDATE", vo);
	}

	@Override
	public CartVO cartSelectOne(CartVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("SHOPPING.CARTSELECTONE", vo);
	}

	@Override
	public void cartUpdatePid(CartVO vo) {
		// TODO Auto-generated method stub
		mybatis.update("SHOPPING.CARTUPDATE_BY_PID", vo);
	}

	@Override
	public List<OrderVO> orderList(OrderVO vo) {
		// TODO Auto-generated method stub
		vo.setCh2("%"+vo.getCh2()+"%");
		return mybatis.selectList("SHOPPING.ORDERLIST",vo);
	}

	@Override
	public List<OrderVO> orderListOne(OrderVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectList("SHOPPING.ORDERLISTONE",vo);
	}

}
