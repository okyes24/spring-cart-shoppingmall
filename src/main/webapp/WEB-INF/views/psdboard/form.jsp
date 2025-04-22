<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/include/top.jsp"/>

<section>
<br>
<div align="center" >
<h2> 자료실 글쓰기   </h2>
<form method="post"  action="${path}/psdboard/insert.do"
      enctype="multipart/form-data"  >
<table border=1 width=500>
<tr> <td width=70  align="center" >제목 </td> 
<td> <input type=text  name=title  size=40> </td> </tr>
<tr> <td  align="center">이름 </td> 
<td> <input type=text  name=write></td> </tr>
<tr> <td  align="center">내용 </td> <td> 
  <textarea cols=50 rows=6 name=content></textarea>
 </td> </tr>
 
<tr> <td  align="center">사진 </td> 
<td> <input type=file  name=uploadFile ></td> </tr> 

<tr> <td colspan=2 align="center">
 <input  type=submit value="저장하기" >
 </td> </tr>
</table>
</form>
</div>
<br>
</section>
<c:import url="/include/bottom.jsp"/>