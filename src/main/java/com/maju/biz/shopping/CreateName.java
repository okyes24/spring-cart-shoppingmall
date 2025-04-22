package com.maju.biz.shopping;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.web.multipart.MultipartFile;

public class CreateName {
   	public  String newName( ShoppingVO vo ) {
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
			String k = sdf.format(now);
		
			int ran=(int)(Math.random()*100)+101 ;
			
			MultipartFile uploadFile =vo.getPimgFile();
			String  fileName = uploadFile.getOriginalFilename();
			
			int lastIndex = fileName.lastIndexOf('.');
			String extension = fileName.substring(lastIndex);
		    String img = "img" + ran + k + extension;
			
			return img;
	  }
}
