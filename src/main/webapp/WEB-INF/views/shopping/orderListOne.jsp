<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="path2" value="/shopping/files/" scope="request" />

<c:import url="/include/top.jsp"/>

<section>
<br>
<div  align="center">

<h2> 주문자 정보</h2>
<table border="1" width="600">
<tr><td>이름</td>
<td>전화번호</td>
<td>배송주소</td>
</tr>
<c:forEach var="m" items="${li}" varStatus="loop">
 <c:if test="${loop.first}">
        <tr>
            <td>${m.name}</td>
            <td>${m.tel}</td>
            <td>${m.addr}</td>
        </tr>
    </c:if>
</c:forEach>
</table>


<h2> 주문 상품 목록 보기    </h2>

<table border="1" width="600">
  <colgroup>
    <col width="40px" />
    <col width="60px" />
    <col width="100px" />
    <col width="80px" />
    <col width="60px" />
  
  </colgroup>
<thead >
<tr align="center" ><td >상품이름</td><td> 가격</td><td>수량</td>
<td>이미지</td><td>주문일자</td>

</tr>
</thead>
<c:set var="totalprice" value="0" />
<c:set var="addr" value=" " />
<c:forEach var="m" items="${li}" varStatus="loop">
<c:if test="${loop.first && not empty m.addr}">
    <c:set var="addr" value="${m.addr}" />
</c:if>
 <c:set var="totalprice"  value="${totalprice=totalprice+m.amount*m.pprice}" />
 
 <tr>
 <td>${m.pname} </td>
 <td>
 ${m.pprice}
</td>
 <td>
  ${m.amount} 
  </td>
 <td><img src ="${path}${path2}${m.pimg}" width=50 height=50 > </td>
 <td>${m.today}
 </td>
  </c:forEach>
 </table>
 가격: <fmt:formatNumber value="${totalprice}" pattern="#,###"/>원 배송:${addr}

<br>

<h2>사업자 정보</h2>
<table border="1" width="600">
<tr><td>주소</td>
<td>전화번호</td>
</tr>
<tr>
<td>서울 관악구 신림동 신림로 340 르네상스 쇼핑몰 9층 마주스토리</td>
<td>010-1111-2222</td>
</tr>
</table>
</div>
<br>
</section>
<c:import url="/include/bottom.jsp"/>