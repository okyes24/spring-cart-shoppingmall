package com.maju.biz.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maju.biz.shopping.CartVO;
@RequestMapping("/kakao")
@Controller
public class kakaoController {
	private static final long serialVersionUID = 1L;
    private static final String KAKAO_API_KEY = "2ef9127419b0219a5a6ee526d90e82bb";  //  발급받은 Admin 키
    private static final String CID = "TC0ONETIME"; // 테스트 CID
       
	@GetMapping("/kakao.do")	

		public  String kakao() {
		   System.out.println("===> /kakao.do");
		return "kakao/kakao";	   
	   }
	@GetMapping("/pay.do")	
		public  String pay() {
		   System.out.println("===> /pay.do");
		return "kakao/pay";	   
	   }
	
	@PostMapping("PaymentServlet.do")
		public  String PaymentServlet(HttpServletRequest request,String pay,String mid, HttpSession session) throws Exception {
		   System.out.println("===> /PaymentServlet.do");
//		   String pay=request.getParameter("pay");
//			String mid=request.getParameter("mid");
	        String path = "http://localhost:8888/biz";   // 필히 문자열로 넘겨주어야 한다.  (중요)
			
			
	        String apiUrl = "https://kapi.kakao.com/v1/payment/ready";
	        URL url = new URL(apiUrl);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Authorization", "KakaoAK " + KAKAO_API_KEY);
	        conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
	        conn.setDoOutput(true);
	        
	        System.out.println("conn:" + conn);
	        
	        String Ordercode=UUID.randomUUID().toString();
			String order_id=Ordercode.substring(1,7);
			String partner_order_id=order_id;
			String partner_user_id=mid;
			String total_amount=String.valueOf(pay);
			session.setAttribute("partner_order_id", partner_order_id);
			session.setAttribute("partner_user_id", partner_user_id);
			session.setAttribute("total_amount", total_amount);
			
	        
	        String params = "cid=" + CID +
	                        "&partner_order_id=" +  partner_order_id+     //  order_id (상품 id)
	                        "&partner_user_id=" + partner_user_id+    //  user_id  (사용자 id)
	                        "&item_name=시리즈상품" +      //  item_name ( 상품명 ) 
	                        "&quantity=1" +                  //  quantity ( 수량 )
	                        "&total_amount=" + total_amount+             //  total_amount ( 가격 )
	                        "&vat_amount=1" +                //  vat_amount ( 부가가치세 : 세금 )
	                        "&tax_free_amount=0" +           //  tax_free_amount ( 면세 )
	                        "&approval_url=" + path + "/kakao/ApproveServlet.do" +
	                        "&cancel_url=" + path + "/cancel" +
	                        "&fail_url="+ path +"/fail";

	        try (OutputStream os = conn.getOutputStream()) {
	            byte[] input = params.getBytes("utf-8");
	            os.write(input, 0, input.length);
	        }

	        int code = conn.getResponseCode();
	        Scanner sc;
	        if (code == 200) {
	            sc = new Scanner(conn.getInputStream());
	            System.out.println("conn1:" + sc);
	        } else {
	            sc = new Scanner(conn.getErrorStream());
	            System.out.println("conn2:" + sc);
	        }
	        
	        StringBuilder result = new StringBuilder();
	        while (sc.hasNext()) {
	            result.append(sc.nextLine());
	        }
	        System.out.println("result:" + result);
	        sc.close();
	     
	         
	        String tid = result.toString().split("\"tid\":\"")[1].split("\"")[0];
	        
	        // 방법1.
	        session.setAttribute("tid", tid);
	        
	        
	        String redirectUrl = result.toString().split("\"next_redirect_pc_url\":\"")[1].split("\"")[0];
	        System.out.println("===>redirectUrl 확인:" + redirectUrl);
	       
		return "redirect:"+redirectUrl;	   
	   }
	@GetMapping("/ApproveServlet.do")	
	public  String ApproveServlet(HttpServletRequest request,CartVO vo, HttpSession session) throws Exception {
	   System.out.println("===> /ApproveServlet.do");
	   
	   System.out.println("===> ApproveServlet 넘어옴 !!" );
		
       String pgToken = request.getParameter("pg_token");
       
       String tid = (String) session.getAttribute("tid");
       
       String partner_order_id=(String) session.getAttribute("partner_order_id");
       String partner_user_id=(String) session.getAttribute("partner_user_id");
       
       
       System.out.println("===> ApproveServlet pgToken 확인" +  pgToken);
       System.out.println("===> ApproveServlet tid 확인:" + tid );
       
       
       String apiUrl = "https://kapi.kakao.com/v1/payment/approve";
       URL url = new URL(apiUrl);
       HttpURLConnection conn = (HttpURLConnection) url.openConnection();
       conn.setRequestMethod("POST");
       conn.setRequestProperty("Authorization", "KakaoAK " + KAKAO_API_KEY);
       conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
       conn.setDoOutput(true);

       System.out.println("===>ApproveServlet conn 확인: " + conn );
       
       String params = "cid=" + CID +
                       "&tid=" + tid +
                       "&partner_order_id=1001" +
                       "&partner_user_id=user_123" +
                       "&pg_token=" + pgToken;

       try (OutputStream os = conn.getOutputStream()) {
           byte[] input = params.getBytes("utf-8");
           os.write(input, 0, input.length);
       }

       int code = conn.getResponseCode();
       Scanner sc;
       if (code == 200) {
           sc = new Scanner(conn.getInputStream());
           System.out.println("===>ApproveServlet sc 성공 확인: " + sc );
       } else {
           sc = new Scanner(conn.getErrorStream());
           System.out.println("===>ApproveServlet sc 실패 확인: " + sc );
       }
       
       StringBuilder result = new StringBuilder();
       while (sc.hasNext()) {
           result.append(sc.nextLine());
       }
       
       System.out.println("===>ApproveServlet result 확인: " + result );
//       response.sendRedirect("shopping/OrderInsert.do");
       sc.close();
       
//       response.setContentType("application/json;charset=UTF-8");
//       response.getWriter().print(result.toString());

	   
	return "redirect:/shopping/OrderInsert.do";	   
   }
}
