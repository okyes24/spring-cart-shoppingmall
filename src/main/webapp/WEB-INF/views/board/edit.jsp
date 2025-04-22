<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/include/top.jsp"/>

<section>
<br>
<div  align="center">
<h2> 상세보기/수정하기   </h2>
<form method="post"  action="${path}/board/update.do">

<input type=hidden  name=seq  size=40  value="${m.getSeq()}">

<table border=1 width=500>
<tr> <td width=70  align="center" >제목 </td> 
<td> <input type=text  name=title  size=40  value="${m.getTitle()}"> </td> </tr>
<tr> <td  align="center">이름 </td> 
<td> <input type=text  name=name   value="${m.getName()}"></td> </tr>
<tr> <td  align="center">내용 </td> <td> 
  <textarea cols=50 rows=6 name=content>${m.getContent()}</textarea>
 </td> </tr>
<tr> <td colspan=2 align="center">
 <input  type=submit value="수정하기" >
 </td> </tr>
</table>
</form>

<form action=${path}/board/comment.do method=post>
<input  type=hidden name=comment_idx  value="${m.getSeq()}"  >
<table  width=500 border=1>
<tr align="center" ><td  >
<input type=text size=55 name=commentContent> 
</td>
<td><input type=submit value="댓글저장"> </td></tr>
</table>
</form>

<table width=500 border=1>
<tr><td>번호</td><td>코맨트 </td><td>날짜 </td><td>삭제 </td>
<c:forEach var="mm" items="${li}">
<tr>
<td>${mm.idx}</td><td>${mm.commentContent} </td>
<td>${mm.commentDate} </td>
<td><input  type=button value="삭제" onClick="delK('${mm.idx}','${m.seq}')"> </td>
</tr>
</c:forEach>
</table>

</div>

<script>
 function delK(idx,seq){
	 // alert("삭제:"+a +","+b)	 
	 location.href="${path}/board/commentDelete.do?idx="+idx+"&comment_idx="+seq
 }

</script>

<br>
</section>
<c:import url="/include/bottom.jsp"/>