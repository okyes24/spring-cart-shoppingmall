<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/include/top.jsp"/>

<c:if test="${id!='admin'}">
  <c:redirect url="login.do" />
</c:if>

<section>
<br>
<div  align="center">

<table border= 1 width=1000>
<tr   align="center"><td>번호 </td><td> 아이디 </td><td>암호1 </td>
<td>암호2 </td></tr>
 <c:forEach var="m"  items="${li}"  >
  <tr>
   
  <td>${m.getSeq()} </td>
  <td>${m.getId()} </td>
  <td>${m.getPwd()} </td>
  <td>${m.getSpwd()} </td>
 
 </tr>
 </c:forEach>

 </table>
 
</div>
<br>
</section>
<c:import url="/include/bottom.jsp"/>