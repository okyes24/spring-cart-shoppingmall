<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/include/top.jsp"/>
<section>
<br>
<div  align="center">
<h2> 목록보기 ( ${map.get("totalCount")}  개 ) , 
     작성자: ${map.get("admin")} ,
     관리자나이: ${map.get("age")}   </h2>
<table border= 1 width=600>
<tr   align="center"><td>번호 </td><td> 제목 </td><td>글쓴이 </td>
<td>날짜 </td><td>날짜(fmt) </td><td>조회수(D) </td></tr>
 <c:forEach var="m"  items="${li}"  >
  <tr>
 <td>${m.getSeq()} </td>
 <td>
 <a href="${path}/board/edit.do?seq=${m.seq}">
 ${m.getTitle()}
 </a>
  </td>
 <td>${m.getName()} </td>
 <td>${m.regdate} </td>
 <td> 
 <fmt:parseDate value="${m.regdate}" pattern="yy/MM/dd" var="parsedDate" />
 <fmt:formatDate value="${parsedDate}" pattern="yyyy년MM월dd일" />
 </td>
 <td>
 <a href="${path}/board/delete.do?seq=${m.getSeq()}">
 ${m.getCnt()}
 </a>
 </td>
 </tr>
 </c:forEach>

 </table>
 <form action="${path}/board/list.do" >
 <select name=ch1>
  <option value="name"> 이 름 </option>
  <option value="title"> 제 목 </option>
 </select>
 <input  type=text  name=ch2 >
 <input  type=submit  value="검색">
 </form>
 
</div>
<br>
</section>
<c:import url="/include/bottom.jsp"/>