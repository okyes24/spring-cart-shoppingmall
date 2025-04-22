<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/include/top.jsp"/>
<c:set var="path2" value="/shopping/files/" scope="request" />
<section>
<br>
<div align="center" >
<h2> 상품 구매하기   </h2>

<form method="post"  action="${path}/shopping/Cart.do">
<table border=1 width=500>
<tr>
 <td colspan=4 align="center">
  <img src ="${path}${path2}${li.pimg}" width=300 height=150>
  </td>
</tr>

<tr> <td width=70  align="center" >상품 번호 </td> 
<td> <input type=text  name=pid size=40 value="${li.pid}" readonly> </td> </tr>

<tr> <td width=70  align="center" >상품이름 </td> 
<td> <input type=text  name=pname  size=40 value="${li.pname}" readonly> </td> </tr>

<tr> <td width=70  align="center" >상품가격 </td> 
<td> <input type=text  name=pprice  size=40 value="${li.pprice}" readonly> </td> </tr>

<tr> <td  align="center">배송비 </td> 
<td> <input type=text  name=pbaesongbi value="${li.pbaesongbi}" readonly></td> </tr>

<tr> <td  align="center">상품설명 </td> <td> 
  <textarea cols=50 rows=6 name=pdesc readonly>${li.pdesc}</textarea>
 </td> </tr>

<tr> <td  align="center">구매수량</td> 
<td> 
<select name=amount>
<option value=1> 1개</option>
<option value=2> 2개</option>
<option value=3> 3개</option>
</select>

</td> </tr>

<tr> <td colspan=2 align="center">
 <input  type=submit value="상품구매" >
 
 </td> </tr>
</table>
</form>
</div>
<br>
</section>
<c:import url="/include/bottom.jsp"/>