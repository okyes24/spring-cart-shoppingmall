<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="path2" value="/shopping/files/" scope="request" />

<c:import url="/include/top.jsp"/>

<section>
<br>
<div  align="center">
<h2> 장바구니 목록 보기    </h2>

<form name=f1 action="${path}/kakao/PaymentServlet.do" method="post">

<table border="1" width="600">
  <colgroup>
    <col width="40px" />
    <col width="60px" />
    <col width="100px" />
    <col width="80px" />
    <col width="60px" />
    <col width="60px" />
    <col width="100px" />
    <col width="40px" />
  </colgroup>
<thead >
<tr align="center" ><td >번호 </td><td> cart_id </td><td>pname </td>
<td>상품가격 </td><td>수량 </td><td>배송비 </td><td>상품사진 </td>
<td>삭제</td>
</tr>
</thead>
<c:set var="totalprice" value="0" />
 <c:forEach var="m"  items="${li}"  >
 <c:set var="mid"  value="${m.mid}" />
 <c:set var="idx"  value="${idx=idx+1}" />
 <c:set var="totalprice"  value="${totalprice=totalprice+m.amount*m.pprice}" />
 <c:set var="mpb"  value="0" />
 
 
 <c:if test="${mpb<m.pbaesongbi }">
 <c:set var="mpb"  value="${mpb=m.pbaesongbi}" />
 </c:if>
 <tr>
 <td>${idx} </td>
 
 <td>
 <input type=text name=cart_id value="${m.cart_id}" style="width:40px;"></td>
 <td>
  <a href=${path}/shopping/edit.do?pid=${m.pid}>
  ${m.pname} 
  </a>
  </td>
 <td>${m.pprice} </td>
 <td><input type=text name=amount value="${m.amount}" style="width:40px;">
 </td>
 <td>${m.pbaesongbi} </td>
 <td><img src ="${path}${path2}${m.pimg}" width=50 height=50 > </td>
 <td><input type=button onClick="cartDelOne('${m.cart_id}')" value="삭제"></td>
 </tr>
 

 </c:forEach>
 </table>
총 구매가격:${totalprice} 원 + 배송비:${mpb} 원 &emsp; = &emsp;총 결제 금액:${totalprice+mpb }원
<br>
<input type=hidden name=pay value=${totalprice+mpb }>
<input type=hidden name=mid value=${mid}>
<input type=submit value=결제하기(주문하기)>
<input type=button onClick="updateK()" value=수정하기(수량)>
  </form>
</div>
<br>
<script>
function cartDelOne(k){
	alert(k)
	location.href="${path}/shopping/cartOneDelete.do?cart_id="+k
}
function updateK(){
	alert("전체수정")
	f1.action="${path}/shopping/cartUpdate.do"
	f1.submit()
}
</script>
</section>
<c:import url="/include/bottom.jsp"/>