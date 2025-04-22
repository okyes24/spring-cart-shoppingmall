<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="path2" value="/shopping/files/" scope="request" />

<c:import url="/include/top.jsp"/>

<section>
<br>
<div  align="center">
<h2> 상품 목록 보기    </h2>
<table border= 1 width=600>

<thead>
<tr   align="center"><td>번호 </td><td> 상품번호 </td><td>상품이름 </td>
<td>상품가격 </td><td>배송비 </td><td>상품사진 </td>
</tr>
</thead>

 <c:forEach var="m"  items="${li}"  >
 <c:set var="idx"  value="${idx=idx+1}" />
 <tr>
 <td>${idx} </td>
 <td>${m.pid} </td>
 <td>
  <a href=${path}/shopping/edit.do?pid=${m.pid}>
  ${m.pname} 
  </a>
  </td>
 <td>${m.pprice} </td>
 <td>${m.pbaesongbi} </td>
 <td><img src ="${path}${path2}${m.pimg}" width=50 height=50 > </td>
 </tr>
 </c:forEach>

 </table>
  
</div>
<br>
</section>
<c:import url="/include/bottom.jsp"/>