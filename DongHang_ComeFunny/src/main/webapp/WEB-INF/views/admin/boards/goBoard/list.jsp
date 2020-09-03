<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/header.jsp" />

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

.goBoardList{
			width: 1200px;
		    margin: 0 auto;
}

.goBoardListToolbar{
			display: inline-block;
}

#goBoardListSearch{
			display: inline;
		    position: relative;
		    margin-left: 0px;
		    left: 200px;
		    right: 100px;
}

#deleteSelectGoBoard{
			width: 100px;
		    position: relative;
		    display: inline;
		    left: 500px;
}

</style>

<script type="text/javascript">
$(document).ready(function(){
	// 전체선택 체크박스 클릭
	$("#selAllGoBoards").click(function(){
		// 전체선택 체크박스가 체크 되어 있을 경우
		if($("#selAllGoBoards").prop("checked")){
			$(".selGoBoard").prop("checked", true);
		}
		// 전체선택 체크박스가 체크되어 있지 않을 경우 
		else{
			$(".selGoBoard").prop("checked", false);
		}
	});
	
	// 체크박스 클릭
	$(".selGoBoard").click(function(){
		// 전체선택 중, 하나의 체크박스가 체크해제될 경우
		if($("#selAllGoBoards").prop("checked")){
			$("#selAllGoBoards").prop("checked", false);
		}
	});
	
	// 체크 삭제버튼을 클릭했을 경우
	$("#deleteSelectGoBoard").click(function(){
		//  배열선언
		var gbNo = new Array();
		$(".selGoBoard:checked").each(function(){
			gbNo.push(this.value);
// 			console.log(dbNos);
		});
		
// 		해당 위치로 이동한다
		$(location).attr("href","delete?gbNos="+gbNo);
		
	});
	
	// 퀵 삭제버튼을 클릭했을 경우
	$(".deleteGoBoard").click(function(){
		var gbNo = $(this).attr('value');
// 		console.log(dbNos);
		$(location).attr("href","delete?gbNos="+gbNo);
		
		});
	
});
	
	
	

</script>

<div class="menuBar">
    	<ul class="mainMenu">
    		<li><a href="/admin/user/list">회원관리</a></li>
    		<li><a href="/admin/boards/freeBoard/list">파티관리</a></li>
    		<li><a href="#">게시판 관리</a>
    			<ul class="boardMenu">
    				<li><a href="list">함께가요 게시판</a></li>
    				<li><a href="/admin/boards/doBoard/list">함께해요 게시판</a></li>
    				<li><a href="/admin/boards/freeBoard/list">자유 게시판</a></li>
    				<li><a href="/admin/boards/reviewBoard/list">후기 게시판</a></li>
    			</ul>
    		</li>
    		<li><a href="/admin/qeustion/list">1대1문의 관리</a></li>
    		<li><a href="/admin/notice/list">공지사항 관리</a></li>
    		<li><a href="#">결제 관리</a></li>
    	</ul>
    </div>


    
<div class="goBoardList">
    
	<div style="text-align-last: center;">
	<table class="table table-bordered table-hover">
		<caption>현재 함께가요 게시글 목록</caption>
		<thead>
			<tr class="active">
				<th><input type="checkbox" id="selAllGoBoards"></th>
				<th>게시글번호</th>
				<th>게시글제목</th>
				<th>글쓴이</th>
				<th>작성날짜</th>
				<th>모집여부</th>
				<th>삭제여부</th>
				<th>퀵 버튼</th>
			</tr>
		</thead>
			<c:forEach items="${goBoardData.goBoardList}" var="goBoard" >
		<tbody>
			<tr class="goBoardListRow">
				<th><input type="checkbox" class="selGoBoard" value="${goBoard.gbNo}"></th>
				<th>${goBoard.gbNo}</th>
				<td><a href="view?dbNo=${goBoard.gbNo}">${goBoard.gbTitle}</a></td>
				<td>${goBoard.gbWriter}</td>
				<td>${goBoard.gbWrittenDate}</td>
				<td>${goBoard.gbRecruitStatus}</td>
				<td>${goBoard.gbIsDel}</td>
				<td>
					<button class= "deleteGoBoard" value="${goBoard.gbNo}">삭제</button>
				</td>
			</tr>
		</tbody>
			</c:forEach>
	
	</table>
	</div>
	<div class="goBoardListToolbar">
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
	<form action="list" method="get" id="goBoardListSearch">
	
	<select id="goBoardSearch" name="searchKinds">
		<c:if test="${searchKinds eq '' and searchText eq ''}">
			<option value="gbTitle">제목</option>
			<option value="gbWriter">글쓴이</option>
			<option value="gbWrittenDate">작성날짜</option>
			<option value="gbRecruitStatus">모집상태</option>
		</c:if>
		<c:if test="${searchKinds eq 'gbTitle' or searchText eq null}">
			<option value="gbTitle">제목</option>
			<option value="gbWriter">글쓴이</option>
			<option value="gbWrittenDate">작성날짜</option>
			<option value="gbRecruitStatus">모집상태</option>
		</c:if>
		<c:if test="${searchKinds eq 'gbWrittenDate'}">
			<option value="gbTitle">제목</option>
			<option value="gbWriter">글쓴이</option>
			<option value="gbWrittenDate" selected="selected">작성날짜</option>
			<option value="gbRecruitStatus">모집상태</option>
		</c:if>
		<c:if test="${searchKinds eq 'gbWriter'}">
			<option value="gbTitle">제목</option>
			<option value="gbWriter" selected="selected">글쓴이</option>
			<option value="gbWrittenDate">작성날짜</option>
			<option value="gbRecruitStatus">모집상태</option>
		</c:if>
		<c:if test="${searchKinds eq 'gbRecruitStatus'}">
			<option value="gbTitle">제목</option>
			<option value="gbWriter">글쓴이</option>
			<option value="gbWrittenDate">작성날짜</option>
			<option value="gbRecruitStatus" selected="selected">모집상태</option>
		</c:if>
	</select>
	<input type="text" name="searchText" id="goBoardSearchBar" placeholder="검색하기" value="${searchText}">
	<button>검색</button>
	</form>
		<button id="deleteSelectGoBoard">삭제</button>
	</div>


</div>
<c:import url="/WEB-INF/views/layout/footer.jsp" />    