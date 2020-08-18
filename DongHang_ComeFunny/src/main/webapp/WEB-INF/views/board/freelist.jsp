<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/board/boardheader.jsp" />    
<div class = "freelist"> 
	<div class = "freelist__header">
		<div class = "freelist__header__label">
			<span>Community</span>
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
			<th>조회수</th>
			
		</tr>
		<c:forEach items="${freeData.flist }" var="free">
		<tr>
			<td>${free.FBNO}</td>
			<td><a href="<%=request.getContextPath() %>/board/freeview?fbno=${free.FBNO }">${free.FBTITLE }</a></td>
			<td>${free.UNICK }</td>
			<td>${free.FBWRITTENDATE }</td>
			<td>${free.FBHITSCNT }</td>
		</tr>
		</c:forEach>
		</table>
	</div>
	<div class="freelist__button">
		<button class ="freelist__button__write" type="button" onclick="location.href='/board/freewrite'">글쓰기</button>
	</div>
	<nav class = "text-center">
		<ul class="pagination">
			<li>
				<a href="<%=request.getContextPath() %>/board/freelist" aria-label="Previous">
					<span aria-hidden="true"><i class="fas fa-angle-double-left"></i></span>
				</a>
			</li>
			
			<c:choose>	
				<c:when test="${paging.cPage > 1 }">
					<li><a href="<%=request.getContextPath() %>/board/freelist?cPage=${paging.cPage-1}"> <i class="fas fa-angle-left"></i> </a></li>
				</c:when>
				<c:otherwise>
					<li><a href="<%=request.getContextPath() %>/board/freelist?cPage=${paging.cPage}"> <i class="fas fa-angle-left"></i> </a></li>
				</c:otherwise>
			</c:choose>
				
<%-- 				<li class="active"><a href="<%=request.getContextPath() %>/board/freelist?cPage=${page}"><span>${page }</span></a></li> --%>
			<c:forEach begin="${paging.blockStart }" end="${paging.blockEnd }" var="page">
				<c:choose>
					<c:when test="${paging.cPage eq page}">
						<li class="active"><a href="<%=request.getContextPath() %>/board/freelist?cPage=${page}"><span>${page}</span></a></li>
					</c:when>
					<c:otherwise>
						<li><a href="<%=request.getContextPath() %>/board/freelist?cPage=${page}"><span>${page}</span></a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:choose>
				<c:when test="${paging.cPage eq paging.lastPage }">
					<li><a href="<%= request.getContextPath() %>/board/freelist?cPage=${paging.cPage}"><i class="fas fa-angle-right"></i></a></li>
				</c:when>
				<c:otherwise>
					<li><a href="<%= request.getContextPath() %>/board/freelist?cPage=${paging.cPage+1}"><i class="fas fa-angle-right"></i></a></li>
				</c:otherwise>
			</c:choose>
			<li><a href="<%= request.getContextPath() %>/board/freelist?cPage=${paging.lastPage }" aria-label="Next"><i class="fas fa-angle-double-right"></i></a></li>
		</ul>
	</nav>
	

	<div class="col-lg-offset-4 col-lg-4">
		<div class="input-group">
			<div class="input-group-btn">
    	  		<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">전체 <span class="caret"></span></button>
      			<ul class="dropdown-menu" role="menu">
	        		<li><a href="#">글쓴이+제목</a></li>
    	    		<li><a href="#">글쓴이</a></li>
        			<li><a href="#">제목</a></li>
      			</ul>
    		</div>
    		<input type="text" class="form-control" aria-label="...">
    		<span class="input-group-btn">
	        	<button class="btn btn-default" type="button"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
        	</span>
  		</div>
	</div>
	
	
	
</div>

	
	


<c:import url="/WEB-INF/views/board/boardfooter.jsp" />    