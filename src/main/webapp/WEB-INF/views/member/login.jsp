<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/include/top.jsp"/>

<section>
<br>
<div align="center" >
<h2> 로그인  </h2>
<form method="post"  action="${path}/member/login.do">
<table border=1 width=500>
<tr> <td width=70  align="center" >아이디 </td> 
<td> <input type=text  name=id  size=40> </td> </tr>

<tr> <td  align="center">암호 </td> 
<td> <input type=text  name=pwd></td> </tr>

<tr> <td colspan=2 align="center">
 <input  type=submit value="로그인" >
 </td> </tr>
</table>
</form>
</div>
<br>
</section>
<c:import url="/include/bottom.jsp"/>