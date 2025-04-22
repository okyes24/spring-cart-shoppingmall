<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/include/top.jsp"/>

<section>
<br>
<div align="center" >
<h2> 쇼핑몰 상품등록   </h2>
<form method="post"  action="${path}/shopping/insert.do"
      enctype="multipart/form-data"  >
<table border=1 width=500>

<tr> <td width=70  align="center" >상품이름 </td> 
<td> <input type=text  name=pname  size=40> </td> </tr>

<tr> <td width=70  align="center" >상품가격 </td> 
<td> <input type=text  name=pprice  size=40> </td> </tr>

<tr> <td  align="center">배송비 </td> 
<td> <input type=text  name=pbaesongbi></td> </tr>

<tr> <td  align="center">상품사진 </td> 
<td> <input type=file  name=pimgFile ></td> </tr> 

<tr> <td  align="center">상품설명 </td> <td> 
  <textarea cols=50 rows=6 name=pdesc></textarea>
 </td> </tr>

<tr> <td colspan=2 align="center">
 <input  type=submit value="상품등록" >
 <input  type=reset value="다시작성" >
 </td> </tr>
</table>
</form>
</div>
<br>
</section>
<c:import url="/include/bottom.jsp"/>