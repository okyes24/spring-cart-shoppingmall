package com.maju.biz.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.maju.biz.psdboard.CreateName;
import com.maju.biz.psdboard.PsdBoardService;
import com.maju.biz.psdboard.PsdBoardVO;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

@RequestMapping("/psdboard")
@Controller
public class PsdBoardController {
	
	@Autowired
	HttpServletRequest  request ;
	
	@Autowired // 서블릿 주입하기
	private ServletContext servletContext;
	
	String path ="";
	
    @PostConstruct 
	public void init() {
		System.out.println("===> initialize() 메소드 실행 "); 
		path = servletContext.getRealPath("/psdboard/files/");
		System.out.println("===> path : "+ path);
		
	}

	
	@Autowired
	private PsdBoardService  service;
	
   @GetMapping("/form.do")	
   public  String form() {
	  return "psdboard/form";	   
   }
	  
   @PostMapping("/insert.do")	
   public  String insert(PsdBoardVO vo , CreateName  createName) throws Exception, IOException {
    
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
		   imgNmae ="space.png";
	   }
	   	   
	   // 테이블에 파일명 저장 
	   vo.setUploadFileStr(imgNmae);   
	   service.insert(vo);
	   
	return "redirect:/psdboard/list.do";	   
   }
   
   @GetMapping("/delete.do")	
   public  String delete(PsdBoardVO vo) {
	   PsdBoardVO m = service.getSelectONE(vo);
	   System.out.print("===> delete File : " + m.getUploadFileStr());
	   
	   File f = new File(path + m.getUploadFileStr() );
	   if (! m.getUploadFileStr().equals("space.png")) {
		    f.delete()  ;
	   }
	   
	   service.delete(vo);
	return "redirect:/psdboard/list.do";	   
   }
   
   @GetMapping("/list.do")	
   public  String list(PsdBoardVO vo, Model model) {	
	   model.addAttribute("li",  service.getSelectALL(vo));	
	return "psdboard/list";	   
   }
   
   @GetMapping("/edit.do")	
   public  String edit(PsdBoardVO vo, Model model) {	
	   model.addAttribute("m",  service.getSelectONE(vo));	
	return "psdboard/edit";	   
   }

   @PostMapping("/update.do")	
   public  String update(PsdBoardVO vo, Model model , CreateName createName ) throws Exception {	
	   MultipartFile uploadFile = vo.getUploadFile();
	   String filename =  uploadFile.getOriginalFilename();
	
	   if (!filename.equals("")) {
		  // 첨부파일이 있는 경우  
		   PsdBoardVO m = service.getSelectONE(vo);
		   File mf = new File(path + m.getUploadFileStr() );
		   if (! m.getUploadFileStr().equals("space.png")) {
			    mf.delete()  ;
		   }		    
		   File f = new File(path + filename);
		   String imgNmae ="" ;		   
		   if (! uploadFile.isEmpty() ) {
			   if ( f.exists() ) {
				 imgNmae  = createName.newName(vo) ; 
			   }else {
				 imgNmae = filename;
			   }		   
			   uploadFile.transferTo(new File(path + imgNmae));		   
		   } else {
			   imgNmae ="space.png";
		   }  		   
		   vo.setUploadFileStr(imgNmae);	   
	   }
	   
	   service.update(vo);	
	   
	return "redirect:/psdboard/list.do";
	
   }
}
