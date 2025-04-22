<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/include/top.jsp"/>
<c:set var="path2" value="/ckeditor/files/" scope="request" />
<section>
<br>
<div  align="center">
<h2> 위지윅 게시판 목록보기  </h2>
<table border= 1 width=600>
<tr   align="center"><td>번호 </td><td> 제목 </td><td>글쓴이 </td>
<td>날짜 </td><td>파일명 </td></tr>
 <c:forEach var="m"  items="${li}"  >
  <tr>
 <td>${m.getIdx()} </td>
 <td>
 <a href="${path}/ckeditor/edit.do?idx=${m.idx}">
 ${m.getTitle()}
 </a>
  </td>
 <td>${m.getName()} </td>
 <td>
 <a href="${path}/ckeditor/delete.do?idx=${m.getIdx()}">
 ${m.getToday()} 
 </a>
 </td>
 <td>${m.getFilename()} </td>
 
 
 </tr>
 </c:forEach>

 </table>

 
</div>
<br>
</section>
<c:import url="/include/bottom.jsp"/>