<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/header.jsp" />    
<div class = "freelist"> 
<div class = "freelist__header">
	<div class = "freelist__header__label">
		<h2>Community</h2>
	</div>
	<span class = "freelist__header__title">자유게시판</span>

</div>
<div class = "freelist__table">
	<table>
	<tr>
		<th>글번호</th>
		<th>글제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>댓글수</th>
		
	</tr>
	<c:forEach var="i" begin="0" end="20">
	<tr>
		<td><a href="#"><c:out value="${i}" /></a></td>
		<td><a href="#"><c:out value="${i}" /></a></td>
		<td><c:out value="${i}" /></td>
		<td><c:out value="${i}" /></td>
		<td><c:out value="${i}" /></td>
	</tr>
	</c:forEach>
</table>
</div>
</div>
<c:import url="/WEB-INF/views/layout/footer.jsp" />    