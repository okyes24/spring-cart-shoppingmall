package com.maju.biz.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maju.biz.member.MemberService;
import com.maju.biz.member.MemberVO;

@RequestMapping("/member")
@Controller
public class MemberController {
	   @Autowired
	   private MemberService  service;
	
	   @GetMapping("/form.do")	
	   public  String form() {
		   System.out.println("===> /member_form.do");
		return "member/form";	   
	   }
	   
	   @GetMapping("/login.do")	
	   public  String login() {
		   System.out.println("===> /member_login.do");
		return "member/login";	   
	   }
	   
	   @PostMapping("/login.do")	
	   public  String loginOK(MemberVO vo, HttpSession session) {
		   MemberVO m = service.getSpwd(vo);
		   
		   if (m == null) {
			   return "redirect:/member/login.do";  
		   }
		   
		   String spwd = m.getSpwd();
		   
		   if (BCrypt.checkpw(vo.getPwd(), spwd) ) {
			   session.setAttribute("id", vo.getId());
			   return "/member/success";
		   }else {
			   return "redirect:/member/login.do";
		   } 
	   }
	   
	   @GetMapping("/logout.do")	
	   public  String logout(MemberVO vo, HttpSession session) {
		    session.invalidate();
			return "redirect:/member/login.do";
	   }
	   
	   @PostMapping("/insert.do")	
	   public  String insert(MemberVO vo) {
		   
		   String spwd = BCrypt.hashpw(vo.getPwd(), BCrypt.gensalt());
		   vo.setSpwd(spwd);
		   service.insert(vo);
		   System.out.println("===> /Member_insert.do");
		   
		return "redirect:/member/list.do";	   
	   }
	   
	   @GetMapping("/list.do")	
	   public  String list(MemberVO vo, Model model) {		   
		   model.addAttribute("li",service.getMemberList(vo) );
		   System.out.println("===> /Member_list.do");
		return "member/list";	   
	   }
	   
	   
}
