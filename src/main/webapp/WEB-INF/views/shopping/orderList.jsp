<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="path2" value="/shopping/files/" scope="request" />

<c:import url="/include/top.jsp"/>

<section>
<br>
<div  align="center">
<h2> 주문 목록 보기    </h2>

<table border="1" width="600">
  <colgroup>
    <col width="40px" />
    <col width="60px" />
    <col width="100px" />
    <col width="80px" />
    <col width="60px" />
  
  </colgroup>
<thead >
<tr align="center" ><td >주문번호 </td><td> 주문자_id </td><td>이름</td>
<td>전화번호</td><td>주문일자</td>

</tr>
</thead>

 <c:forEach var="m"  items="${li}"  >
 
 <tr>
 <td><a href=${path}/shopping/orderListOne.do?orderg=${m.orderg}>
 ${m.orderg} </a></td>
 <td>
 ${m.mid}
</td>
 <td>
  ${m.name} 
  </td>
 <td>${m.tel} </td>
 <td>${m.today}
 </td>
 
 
 

 </c:forEach>
 </table>
<form action="${path}/shopping/orderList.do">
  <select name="ch1">
    <option value="name" ${param.ch1 == 'name' ? 'selected' : ''}>이 름</option>
    <option value="tel" ${param.ch1 == 'tel' ? 'selected' : ''}>전화번호</option>
  </select>
  <input type="text" name="ch2" value="${param.ch2}">
  <input type="submit" value="검색">
</form>

<br>

</div>
<br>
</section>
<c:import url="/include/bottom.jsp"/>