package com.maju.biz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maju.biz.board.BoardService;
import com.maju.biz.board.BoardVO;
import com.maju.biz.comment.CommentService;
import com.maju.biz.comment.CommentVO;

@RequestMapping("/board")
@Controller
public class BoardController {
	   
	   @Autowired
	   private BoardService  service;
	   
	   @Autowired
	   private CommentService cservice;
	
	   @GetMapping("/form.do")	
	   public  String form() {
		   System.out.println("===> /board_form.do");
		return "board/form";	   
	   }
	   
	   @GetMapping("/list.do")	
	   public  String list(BoardVO vo, Model model) {		   
		   model.addAttribute("li",  service.getBoardList(vo));	
		   model.addAttribute("map",  service.totalCount(vo));		   
		   System.out.println("===> /board_list.do");
		return "board/list";	   
	   }
	   
	   @GetMapping("/edit.do")	
	   public  String edit(BoardVO vo, Model model, CommentVO cvo ) {
		   service.cnt(vo);
		   // Comment_idx : String , seq : int 
		   // 숫자를 문자로 형변환 
		   cvo.setComment_idx(String.valueOf(vo.getSeq()));
		   model.addAttribute("m",  service.getBoard(vo));	
		   model.addAttribute("li", cservice.list(cvo) );	
		   System.out.println("===> /board_edit.do");
		return "board/edit";	   
	   }
	   
       @PostMapping("/comment.do")	
	   public  String comment(CommentVO cvo) {
		   cservice.insert(cvo);
		   System.out.println("===> /board_insert.do");
		return "redirect:/board/edit.do?seq="+cvo.getComment_idx();	   
	   }
	   
       @GetMapping("/commentDelete.do")	
	   public  String commentDelete(CommentVO cvo) {
    	   
    	   System.out.println("===> idx , comment_idx ");
		   cservice.delete(cvo);
		  
		return "redirect:/board/edit.do?seq="+cvo.getComment_idx();	   
	   }
	   
	   
	   @PostMapping("/insert.do")	
	   public  String insert(BoardVO vo) {
		   service.insert(vo);
		   System.out.println("===> /board_insert.do");
		return "redirect:/board/list.do";	   
	   }	   
	   		   
	   @PostMapping("/update.do")	
	   public  String update(BoardVO vo) {
		   service.update(vo);
		   System.out.println("===> /board_update.do");
		 return "redirect:/board/list.do";		   
	   }
	   
	   @GetMapping("/delete.do")	
	   public  String delete(BoardVO vo) {
		   System.out.println("===> /board_delete.do(seq)" + vo.getSeq());
		   service.delete(vo.getSeq());
		   System.out.println("===> /board_delete.do");
	   return "redirect:/board/list.do";	  
	   }
}
