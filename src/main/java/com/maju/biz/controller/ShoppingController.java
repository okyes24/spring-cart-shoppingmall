package com.maju.biz.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.maju.biz.psdboard.PsdBoardVO;
import com.maju.biz.shopping.CartVO;
import com.maju.biz.shopping.CreateName;
import com.maju.biz.shopping.OrderVO;
import com.maju.biz.shopping.ShoppingService;
import com.maju.biz.shopping.ShoppingVO;

@RequestMapping("/shopping")
@Controller
public class ShoppingController {

	@Autowired
	HttpServletRequest  request ;
	
	@Autowired // 서블릿 주입하기
	private ServletContext servletContext;
	
	String path ="";
	
    @PostConstruct 
	public void init() {
		path = servletContext.getRealPath("/shopping/files/");
		System.out.println("===> path : "+ path);
	}

	
	@Autowired
	private ShoppingService  service;
	
   @GetMapping("/insert.do")	
   public  String form() {
	  return "shopping/insert";	   
   }
	  
   @PostMapping("/insert.do")	
   public  String insert(ShoppingVO vo , CreateName  createName) throws Exception, IOException {
    
	   MultipartFile uploadFile = vo.getPimgFile();
	   String  filename = uploadFile.getOriginalFilename();	   
	   File f = new File(path + filename);
	   String imgNmae ="" ;
	   
	   if (! uploadFile.isEmpty() ) {
		 // 첨부파일이 있으면 실행 
		   if ( f.exists() ) {
			 imgNmae  = createName.newName(vo) ; 
		   }else {
			 imgNmae = filename;
		   }		   
		   // 파일 저장하기 
		   uploadFile.transferTo(new File(path + imgNmae));		   
	   } else {
		   imgNmae ="space.png";
	   }
	   	   
	   // 테이블에 파일명 저장 
	   vo.setPimg(imgNmae);   
	   service.shoppingInsert(vo);
	   
	return "redirect:/shopping/list.do";	   
   }
   @GetMapping("/list.do")	
   public  String list(ShoppingVO vo, Model model) {	
	   model.addAttribute("li",  service.shoppingSelect(vo));	
	return "shopping/list";	   
   }
   
   @GetMapping("/edit.do")	
   public  String edit(ShoppingVO vo, Model model) {	
	   model.addAttribute("li",  service.shoppingEdit(vo));	
	return "shopping/edit";	   
   }
   @PostMapping("/Cart.do")	
   public  String shoppingCart(CartVO vo, Model model, HttpSession session) {	
//	   mid= 로그인 아이디, pid, amount
	   
	   String id=(String)session.getAttribute("id");
	   vo.setMid(id);
	   CartVO exist = service.cartSelectOne(vo);
	   if (exist!=null) {
		   int newAmount = exist.getAmount() + vo.getAmount();
	        vo.setAmount(newAmount);
		   service.cartUpdatePid(vo);	
	   }
	   else {
		   service.cartInsert(vo);	
	   }
	   
	return "redirect:/shopping/cartList.do";	   
   }
   
   @GetMapping("/cartList.do")	
   public  String cartList(CartVO vo, Model model, HttpSession session) {
	   String id=(String)session.getAttribute("id");
	   vo.setMid(id);
	   
	   model.addAttribute("li",  service.cartList(vo));	
	return "shopping/cartList";	   
   }
   @GetMapping("/OrderInsert.do")	
   public  String OrderInsert(CartVO vo, Model model, HttpSession session, OrderVO ovo) {
	   System.out.println("===>/OrderInsert.do");
	   String partner_order_id=(String) session.getAttribute("partner_order_id");
       String partner_user_id=(String) session.getAttribute("partner_user_id");
	   vo.setMid(partner_user_id);
       List<CartVO> li=service.cartOrder(vo);
       for(CartVO m: li) {
    	       
    	   ovo.setOrderg(partner_order_id);
    	   ovo.setMid(partner_user_id);
    	   ovo.setCart_id(m.getCart_id());
    	   ovo.setPid(m.getPid());
    	   ovo.setAmount(m.getAmount());
    	   service.orderInsert(ovo);
       }
       System.out.println("=========>mid:"+vo.getMid());
       service.cartDelete(vo);
	return "kakao/result";	   
   }
   @GetMapping("/cartOneDelete.do")	
   public  String cartOneDelete(CartVO vo, Model model, HttpSession session) {
//	   vo.setCart_id(vo.getCart_id());
//	   System.out.println("=====================>"+vo.getCart_id());
	   service.cartOneDelete(vo);
	   
	   
	   	
	   return "redirect:/shopping/cartList.do";
   }
   @PostMapping("/cartUpdate.do")	
   public String cartUpdate(@RequestParam("cart_id") String[] cart_id,
                            @RequestParam("amount") String[] amount,
                            HttpSession session) {

       for (int i = 0; i < cart_id.length; i++) {
           CartVO vo = new CartVO();
           vo.setCart_id(Integer.parseInt(cart_id[i]));
           vo.setAmount(Integer.parseInt(amount[i]));
           
           service.cartUpdate(vo); // 각 CartVO에 대해 업데이트
       }

       return "redirect:/shopping/cartList.do";
   }
   @GetMapping("/orderList.do")	
   public  String orderList(OrderVO vo, Model model, HttpSession session) {
	   
	   
	   model.addAttribute("li",  service.orderList(vo));	
	return "shopping/orderList";	   
   }
   @GetMapping("/orderListOne.do")	
   public  String orderListOne(OrderVO vo, Model model, HttpSession session) {
	   
	   
	   model.addAttribute("li",  service.orderListOne(vo));	
	return "shopping/orderListOne";	   
   }
}
