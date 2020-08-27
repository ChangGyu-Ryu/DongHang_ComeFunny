<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/board/boardheader.jsp" />   


<div class = "freeview"> 
	<div class = "freeview__border">
	<div class = "freeview__header">
		<div class = "freeview__header__label">
			<span>자유게시판</span>
		</div>
		<span class = "freeview__header__title">상세보기</span>
	</div>
	<div class = "freeview__table">
		<table>
		<tr>
			<td colspan="2"> 
				<div class= "freeview__table__title">
				제목 : &nbsp;
					<span>${fview.detail.FBTITLE}</span>
				</div>
			</td>
		</tr>
		<tr >			
			<td colspan="2">
			<div class= "freeview__table__header ">
				<div>${fview.detail.UNICK } &nbsp; | &nbsp; ${fview.detail.FBWRITTENDATE}</div>
				<div>조회 &nbsp; : &nbsp; ${fview.detail.FBHITSCNT} &nbsp; | &nbsp; 댓글 &nbsp; : &nbsp; 0 </div>
			</div>
			</td>
			
		</tr>
		<tr>
			<td colspan="2">
			<div class= "freeview__table__content">
				${fview.detail.FBCONTENT }
			</div>
			</td>
		</tr>
			<c:forEach items="${fview.filelist }" var="file" varStatus="status">
		<tr>			
			<td colspan="2">
				<div class="freeview__table__download">
				
				<c:choose>
					<c:when test="${status.first}">
					<span>업로드된 파일 : &nbsp; ${status.count }. &nbsp;</span>
					</c:when>
					<c:otherwise>
					${status.count}. : &nbsp;
					</c:otherwise>
				</c:choose> 
				<span> ${file.FFORIGINFILENAME}</span>
			</div>
			</td>
			
		</tr>
			</c:forEach>

		</table>
		

  		
  		<div class="freeview__comment">
  			<div class="freeview__comment__write">
  				<span>댓글 달기</span>
  			</div>
  		
		    <div class="input-group">
		      <input type="text" class="form-control" placeholder="댓글을 작성해주세요.">
		      <span class="input-group-btn">
		        <button class="btn btn-default" type="button">작성</button>
		      </span>
		    </div>
		</div>
  
	</div>
	
	<div class = "freeview__comment__list">
		<table>
		<tr>
			<td colspan="2"> 
				<div class= "freeview__comment__title">
					<span>댓글 목록</span>
				</div>
			</td>
		</tr>
		
		<tr>			
			<td colspan="2">
			<div class= "freeview__comment__header ">
				<div>donghangId &nbsp; | &nbsp; 2020.08.08 21:55:00</div>
			</div>
			</td>
			
		</tr>
		<tr>
			<td colspan="2">
			<div class= "freeview__comment__content">
			피가 설레는 청춘 약동하다. 천자만홍이 충분히 같이, 듣기만 없는 있을 영원히 생명을 아름다우냐? 소리다.이것은 방황하여도, 충분히 풍부하게 있다. 생의 대고, 원대하고, 천고에 보라. 거선의 보이는 소리다.이것은 부패를 위하여, 못할 가장 때문이다. 없으면 인간의 생생하며, 풀이 가는 얼음과 피부가 든 끓는 것이다. 가진 청춘 사는가 있을 실로 광야에서 그림자는 행복스럽고 교향악이다. 봄바람을 위하여서, 풍부하게 그들은 그것을 돋고, 그들은 든 가치를 보라. 위하여서, 이상 방지하는 있는 아름답고 소리다.이것은 쓸쓸하랴?
			</div>
			</td>
		</tr>
		<c:forEach var="i" begin="0" end="2">
		<tr>			
			<td colspan="2">
			<div class= "freeview__comment__header ">
				<div>donghangId &nbsp; | &nbsp; 2020.08.08 21:55:00</div>
			</div>
			</td>
			
		</tr>
		<tr>
			<td colspan="2">
			<div class= "freeview__comment__content">
				<c:out value="${i}" />
			</div>
			</td>
		</tr>
		</c:forEach>
		</table>
		
		<div class="freeview__button">
			<div>
				<button class ="freeview__button__list" type="button" onclick="location.href='/board/freelist'">목록</button>
			</div>
			
			<div>
				<button class ="freeview__button__modify" type="button" onclick="location.href='#'">수정</button>
				<button class ="freeview__button__delete" type="button" onclick="location.href='#'">삭제</button>
			</div>
			
			
		</div>

	

</div>	
	
</div>	
</div>

<c:import url="/WEB-INF/views/board/boardfooter.jsp" />    



