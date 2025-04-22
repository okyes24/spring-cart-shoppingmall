<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" 
       scope="request" />
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마주스토리</title>
<link  href="${path}/include/top.css"  
       rel="stylesheet" type="text/css" />
<style type="text/css">

</style>

</head>
<body>

<header> 마주스토리 골프 회원관리 프로그램  </header>
<nav > &emsp;&emsp;
<c:if test="${id=='admin2'}">
<a href="${path}/test.do"> Test </a> &emsp;&emsp;
<a href="${path}/board/form.do"> 게시판저장 </a> &emsp;&emsp;
<a href="${path}/board/list.do"> 게시판목록 </a> &emsp;&emsp;
</c:if>

<c:if test="${id=='admin' or  id =='member'}">
<a href="${path}/psdboard/form.do"> 자료실저장 </a> &emsp;&emsp;
<a href="${path}/psdboard/list.do"> 자료실목록 </a> &emsp;&emsp;
</c:if>

<c:if test="${id=='admin'}">
<a href="${path}/member/form.do"> 회원가입 </a> &emsp;&emsp;
<a href="${path}/member/list.do"> 회원목록 </a> &emsp;&emsp;
</c:if>

<c:if test="${empty id}">
<a href="${path}/member/login.do">로그인</a> &emsp;&emsp;
</c:if>
<c:if test="${not empty id}">
 <a href="${path}/shopping/insert.do">상품등록</a> &emsp;&emsp;
<a href="${path}/shopping/list.do">상품목록</a> &emsp;&emsp;

<a href="${path}/shopping/cartList.do">장바구니</a> &emsp;&emsp;
 <a href="${path}/member/logout.do">로그아웃</a> &emsp;&emsp;
 <a href="${path}/kakao/kakao.do">카카오결제 테스트</a> &emsp;&emsp;
</c:if>

 <a href="${path}/shopping/orderList.do">주문목록</a> &emsp;&emsp;
 <a href="${path}/ckeditor/form.do">ckeditor</a> &emsp;&emsp;
 <a href="${path}/ckeditor/list.do">ckeditor list</a> &emsp;&emsp;
 
&emsp;<a href="${path}/index.jsp">홈으로</a> 
 
 </nav>