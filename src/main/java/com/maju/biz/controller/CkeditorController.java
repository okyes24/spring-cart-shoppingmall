package com.maju.biz.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.maju.biz.board.BoardService;
import com.maju.biz.board.BoardVO;
import com.maju.biz.ckeditor.CkeditorService;
import com.maju.biz.ckeditor.CkeditorVO;
import com.maju.biz.comment.CommentVO;
import com.maju.biz.ckeditor.CreateName;
@RequestMapping("/ckeditor")
@Controller
public class CkeditorController {
	@Autowired
	HttpServletRequest  request ;
	
	@Autowired // 서블릿 주입하기
	private ServletContext servletContext;
	
	String path ="";
	
    @PostConstruct 
	public void init() {
		System.out.println("===> initialize() 메소드 실행 "); 
		path = servletContext.getRealPath("/ckeditor/files/");
		System.out.println("===> path : "+ path);
		
	}
	@Autowired
	   private CkeditorService  service;
	
	@GetMapping("/form.do")	
	   public  String form() {
		   System.out.println("===> /ckeditor_form.do");
		return "ckeditor/form";	   
	   }
	@GetMapping("/list.do")	
	   public  String list(CkeditorVO vo, Model model) {		   
		   model.addAttribute("li",  service.getCkeditorVOList(vo));	
		   	   
		   System.out.println("===> /Ckeditor_list.do");
		return "ckeditor/list";	   
	   }
	
	@PostMapping("/insert.do")	
	   public  String insert(CkeditorVO vo, CreateName  createName) throws Exception, IOException {
		MultipartFile uploadFile = vo.getUploadFile();
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
			   imgNmae =" ";
		   }
		   	   
		   // 테이블에 파일명 저장 
		   vo.setFilename(imgNmae);   
		   service.insert(vo);
		   
		return "redirect:/ckeditor/list.do";	   
	   }	
	@GetMapping("/edit.do")	
	   public  String edit(CkeditorVO vo, Model model) {
		   service.getCkeditorVO(vo);
		   vo.setIdx(vo.getIdx());
		   
		   model.addAttribute("m",  service.getCkeditorVO(vo));	
		   	
		   
		return "ckeditor/edit";	   
	   }
	@PostMapping("/update.do")
	public String update(CkeditorVO vo, HttpServletRequest request) throws Exception {

	    MultipartFile uploadFile = vo.getUploadFile();

	    if (uploadFile != null && !uploadFile.isEmpty()) {
	    	String path = request.getSession().getServletContext().getRealPath("/ckeditor/files");

	        File dir = new File(path);
	        if (!dir.exists()) dir.mkdirs();

	        String originalFilename = uploadFile.getOriginalFilename();
	        File dest = new File(dir, originalFilename);
	        uploadFile.transferTo(dest);

	        vo.setFilename(originalFilename);  // DB에 저장할 파일명 세팅
	    }


	    service.update(vo);
	    System.out.println("===> /ckeditor_update.do");
	    return "redirect:/ckeditor/list.do";
	}
	@GetMapping("/delete.do")	
	   public  String delete(CkeditorVO vo) {
		   
		   service.delete(vo);
		   System.out.println("===> /ckeditor_delete.do");
	   return "redirect:/ckeditor/list.do";	  
	   }
}
