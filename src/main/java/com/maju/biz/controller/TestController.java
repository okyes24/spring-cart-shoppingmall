package com.maju.biz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
   
   @GetMapping("/test.do")	
   public  String test() {
	   System.out.println("===> /test.do");
	return "test";	   
   }	
}
