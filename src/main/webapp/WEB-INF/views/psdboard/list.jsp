<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="path2" value="/psdboard/files/" scope="request" />

<c:import url="/include/top.jsp"/>

<section>
<br>
<div  align="center">
<h2> 자료실 목록보기    </h2>
<table border= 1 width=600>
<tr   align="center"><td>번호 </td><td> 제목 </td><td>글쓴이 </td>
<td>파일명 </td><td>사진 </td>
<td>날짜(fmt) </td><td>조회수(D) </td></tr>
 <c:forEach var="m"  items="${li}"  >
  <tr>
 <td>${m.getSeq()} </td>
 <td>
 <a href="${path}/psdboard/edit.do?seq=${m.seq}">
 ${m.getTitle()}
 </a>
  </td>
 <td>${m.write} </td>
 <td>${m.uploadFileStr} </td>
 <td><img src ="${path}${path2}${m.uploadFileStr}" width=50 height=50 > </td>
 
 <td> 
 <fmt:parseDate value="${m.regdate}" pattern="yyyy-MM-dd" var="parsedDate" />
 <fmt:formatDate value="${parsedDate}" pattern="yyyy년MM월dd일" />
 </td>
 <td>
 <a href="${path}/psdboard/delete.do?seq=${m.getSeq()}">
 ${m.getCnt()}
 </a>
 </td>
 </tr>
 </c:forEach>

 </table>
  
</div>
<br>
</section>
<c:import url="/include/bottom.jsp"/>