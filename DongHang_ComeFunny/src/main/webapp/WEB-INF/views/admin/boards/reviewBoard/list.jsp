<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/admin/layout/header.jsp" />

<style type="text/css">

.menuBar {
			position : fixed;
			
}

.mainMenu {	
			text-align : center;
			list-style: none;
			margin: 0px;
			padding : 0px;
			position: relative;
}

.mainMenu li {
	width: 130px;
    border-top: 5px solid white;
    background-color: rgb(189,209,234);
}

.mainMenu li:hover {
			background-color: rgb(156,181,183);}

.mainMenu li:hover > .boardMenu {
			display:block}
			
.mainMenu li a {
			text-decoration: none;
		    display: block;
		    width: 140px;
		    height: 60px;
		    line-height: 60px;
		    font-size: 20px;
		    color: rgb(49,86,126);
		    padding-right: 10px;
}

.boardMenu {
			list-style: none;
		    display: none;
		    position: absolute;
		    left: 140px;
		    top: 135px;
			}
			
.boardMenu li { 
			width: 184px;
			background-color: rgb(189,209,234); 
}

.boardMenu li:first-child{
			border-top: none;}

.boardMenu li a { 
			width: 186px;
    		display: block;
}

.reviewBoardList{
			width: 1200px;
		    margin: 0 auto;
}

.reviewBoardListToolbar{
			display: inline-block;
}

#reviewBoardListSearch{
			display: inline;
		    position: relative;
		    margin-left: 0px;
		    left: 200px;
		    right: 100px;
}

#deleteSelectReviewBoard{
			width: 100px;
		    position: relative;
		    display: inline;
		    left: 500px;
}

</style>

<script type="text/javascript">
$(document).ready(function(){
	// 전체선택 체크박스 클릭
	$("#selAllReviewBoards").click(function(){
		// 전체선택 체크박스가 체크 되어 있을 경우
		if($("#selAllReviewBoards").prop("checked")){
			$(".selReviewBoard").prop("checked", true);
		}
		// 전체선택 체크박스가 체크되어 있지 않을 경우 
		else{
			$(".selReviewBoard").prop("checked", false);
		}
	});
	
	// 체크박스 클릭
	$(".selReviewBoard").click(function(){
		// 전체선택 중, 하나의 체크박스가 체크해제될 경우
		if($("#selAllReviewBoards").prop("checked")){
			$("#selAllReviewBoards").prop("checked", false);
		}
	});
	
	// 체크 삭제버튼을 클릭했을 경우
	$("#deleteSelectReviewBoard").click(function(){
		//  배열선언
		var rbNo = new Array();
		$(".selReviewBoard:checked").each(function(){
			rbNo.push(this.value);
// 			console.log(rbNo);
		});
		
// 		해당 위치로 이동한다
		$(location).attr("href","delete?rbNo="+rbNo);
		
	});
	
	// 퀵 삭제버튼을 클릭했을 경우
	$(".deleteReviewBoard").click(function(){
		var rbNo = $(this).attr('value');
// 		console.log(rbNo);
		$(location).attr("href","delete?rbNo="+rbNo);
		
		});
	
});
	
	
	

</script>

<div class="menuBar">
    	<ul class="mainMenu">
    		<li><a href="/admin/user/list">회원관리</a></li>
    		<li><a href="/admin/boards/reviewBoard/list">파티관리</a></li>
    		<li><a href="#">게시판 관리</a>
    			<ul class="boardMenu">
    				<li><a href="/admin/boards/goBoard/list">함께가요 게시판</a></li>
    				<li><a href="/admin/boards/doBoard/list">함께해요 게시판</a></li>
    				<li><a href="/admin/boards/freeBoard/list">자유 게시판</a></li>
    				<li><a href="list">후기 게시판</a></li>
    			</ul>
    		</li>
    		<li><a href="/admin/qeustion/list">1대1문의 관리</a></li>
    		<li><a href="/admin/notice/list">공지사항 관리</a></li>
    		<li><a href="#">결제 관리</a></li>
    	</ul>
    </div>


    
<div class="reviewBoardList">
    
	<div style="text-align-last: center;">
	<table class="table table-bordered table-hover">
		<caption>현재 후기 게시글 목록</caption>
		<thead>
			<tr class="active">
				<th><input type="checkbox" id="selAllReviewBoards"></th>
				<th>게시글번호</th>
				<th>게시글제목</th>
				<th>글쓴이</th>
				<th>작성날짜</th>
				<th>추천수</th>
				<th>찜수</th>
				<th>조회수</th>
				<th>삭제여부</th>
				<th>퀵 버튼</th>
			</tr>
		</thead>
			<c:forEach items="${reviewBoardData.reviewBoardList}" var="reviewBoard" >
		<tbody>
			<tr class="reviewBoardListRow">
				<th><input type="checkbox" class="selreviewBoard" value="${reviewBoard.rbNo}"></th>
				<th>${reviewBoard.rbNo}</th>
				<td><a href="view?fbNo=${reviewBoard.rbNo}">${reviewBoard.rbTitle}</a></td>
				<td>${reviewBoard.rbWriter }</td>
				<td>${reviewBoard.rbWrittenDate}</td>
				<td>${reviewBoard.rbRecommendCnt}</td>
				<td>${reviewBoard.rbLikeCnt}</td>
				<td>${reviewBoard.rbHitsCnt}</td>
				<td>${reviewBoard.rbIsDel}</td>
				<td>
					<button class= "deletereviewBoard" value="${reviewBoard.rbNo}">삭제</button>
				</td>
			</tr>
		</tbody>
			</c:forEach>
	
	</table>
	</div>
	<div class="reviewBoardListToolbar">
	<ul class="pagination" style="text-align: center; display: inline;">
	    <li>
	      <a href="#" aria-label="Previous">
	        <span aria-hidden="true">«</span>
	      </a>
	     </li>
	    <li><a href="list?searchKinds=${searchKinds}&searchText=${searchText}&cPage=${paging.blockStart }">1</a></li>
	    <li><a href="list?searchKinds=${searchKinds}&searchText=${searchText}&cPage=2">2</a></li>
	    <li><a href="list?searchKinds=${searchKinds}&searchText=${searchText}&cPage=3">3</a></li>
	    <li><a href="list?searchKinds=${searchKinds}&searchText=${searchText}&cPage=4">4</a></li>
	    <li><a href="#">5</a></li>
	    <li>
	      <a href="#" aria-label="Next">
	        <span aria-hidden="true">>></span>
	      </a>
	    </li>
	  </ul>
	<form action="list" method="get" id="reviewBoardListSearch">
	
	<select id="reviewBoardSearch" name="searchKinds">
		<c:if test="${searchKinds eq '' and searchText eq ''}">
			<option value="rbTitle">제목</option>
			<option value="rbWriter">글쓴이</option>
			<option value="rbWrittenDate">작성날짜</option>
		</c:if>
		<c:if test="${searchKinds eq 'rbTitle' or searchText eq null}">
			<option value="rbTitle" selected="selected">제목</option>
			<option value="rbWriter">글쓴이</option>
			<option value="rbWrittenDate">작성날짜</option>
		</c:if>
		<c:if test="${searchKinds eq 'rbWrittenDate'}">
			<option value="rbTitle">제목</option>
			<option value="rbWriter">글쓴이</option>
			<option value="rbWrittenDate" selected="selected">작성날짜</option>
		</c:if>
		<c:if test="${searchKinds eq 'rbWriter'}">
			<option value="rbTitle">제목</option>
			<option value="rbWriter" selected="selected">글쓴이</option>
			<option value="rbWrittenDate">작성날짜</option>
		</c:if>
	</select>
	<input type="text" name="searchText" id="reviewBoardSearchBar" placeholder="검색하기" value="${searchText}">
	<button>검색</button>
	</form>
		<button id="deleteSelectReviewBoard">삭제</button>
	</div>


</div>
<c:import url="/WEB-INF/views/admin/layout/footer.jsp" />    