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

.qeustionBoardList{
			width: 1200px;
		    margin: 0 auto;
}

.qeustionBoardListToolbar{
			display: inline-block;
}

#qeustionBoardListSearch{
			display: inline;
		    position: relative;
		    margin-left: 0px;
		    left: 200px;
		    right: 100px;
}

#deleteSelectQeustionBoard{
			width: 100px;
		    position: relative;
		    display: inline;
		    left: 500px;
}

</style>

<script type="text/javascript">
$(document).ready(function(){
	// 전체선택 체크박스 클릭
	$("#selAllQeustionBoards").click(function(){
		// 전체선택 체크박스가 체크 되어 있을 경우
		if($("#selAllQeustionBoards").prop("checked")){
			$(".selQeustionBoard").prop("checked", true);
		}
		// 전체선택 체크박스가 체크되어 있지 않을 경우 
		else{
			$(".selQeustionBoard").prop("checked", false);
		}
	});
	
	// 체크박스 클릭
	$(".selQeustionBoard").click(function(){
		// 전체선택 중, 하나의 체크박스가 체크해제될 경우
		if($("#selAllQeustionBoards").prop("checked")){
			$("#selAllQeustionBoards").prop("checked", false);
		}
	});
	
	// 체크 삭제버튼을 클릭했을 경우
	$("#deleteSelectQeustionBoard").click(function(){
		//  배열선언
		var qbNos = new Array();
		$(".selQeustionBoard:checked").each(function(){
			QbNos.push(this.value);
// 			console.log(qbNos);
		});
		
// 		해당 위치로 이동한다
		$(location).attr("href","delete?qbNos="+qbNos);
		
	});
	
	// 퀵 삭제버튼을 클릭했을 경우
	$(".deleteQeustionBoard").click(function(){
		var qbNos = $(this).attr('value');
// 		console.log(qbNos);
		$(location).attr("href","delete?qbNos="+qbNos);
		
		});
	
});
	
	
	

</script>

<div class="menuBar">
    	<ul class="mainMenu">
    		<li><a href="/admin/user/list">회원관리</a></li>
    		<li><a href="/admin/boards/freeBoard/list">파티관리</a></li>
    		<li><a href="#">게시판 관리</a>
    			<ul class="boardMenu">
    				<li><a href="/admin/boards/goBoard/list">함께가요 게시판</a></li>
    				<li><a href="/admin/baords/doBoard/list">함께해요 게시판</a></li>
    				<li><a href="/admin/boards/freeBoard/list">자유 게시판</a></li>
    				<li><a href="/admin/boards/reviewBoard/list">후기 게시판</a></li>
    			</ul>
    		</li>
    		<li><a href="list">1대1문의 관리</a></li>
    		<li><a href="/admin/notice/list">공지사항 관리</a></li>
    		<li><a href="#">결제 관리</a></li>
    	</ul>
    </div>


    
<div class="qeustionBoardList">
    
	<div style="text-align-last: center;">
	<table class="table table-bordered table-hover">
		<caption>현재 문의글 목록</caption>
		<thead>
			<tr class="active">
				<th><input type="checkbox" id="selAllQeustionBoards"></th>
				<th>문의글번호</th>
				<th>문의글제목</th>
				<th>글쓴이</th>
				<th>작성날짜</th>
				<th>답장여부</th>
				<th>삭제여부</th>
				<th>퀵 버튼</th>
			</tr>
		</thead>
			<c:forEach items="${questionData.questionList}" var="questionList" >
		<tbody>
			<tr class="qeustionBoardListRow">
				<th><input type="checkbox" class="selqeustionBoard" value="${questionList.qbNo}"></th>
				<th>${questionList.qbNo}</th>
				<td><a href="view?qbNo=${questionList.qbNo}">${questionList.qbTitle}</a></td>
				<td>${questionList.qbWriter}</td>
				<td>${questionList.qbWrittenDate}</td>
				<td>${questionList.qbStatus}</td>
				<td>${questionList.qbIsDel}</td>
				<td>
					<button class= "deleteQeustionBoard" value="${questionList.qbNo}">삭제</button>
				</td>
			</tr>
		</tbody>
			</c:forEach>
	
	</table>
	</div>
	<div class="qeustionBoardListToolbar">
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
	<form action="list" method="get" id="qeustionBoardListSearch">
	
	<select id="qeustionBoardSearch" name="searchKinds">
		<c:if test="${searchKinds eq '' and searchText eq ''}">
			<option value="qbTitle">제목</option>
			<option value="qbWriter">글쓴이</option>
			<option value="qbWrittenDate">작성날짜</option>
			<option value="qbStatus">답장여부</option>
		</c:if>
		<c:if test="${searchKinds eq 'qbTitle' or searchText eq null}">
			<option value="qbTitle" selected="selected">제목</option>
			<option value="qbWriter">글쓴이</option>
			<option value="qbWrittenDate">작성날짜</option>
			<option value="qbStatus">답장여부</option>
		</c:if>
		<c:if test="${searchKinds eq 'qbWrittenDate'}">
			<option value="qbTitle">제목</option>
			<option value="qbWriter">글쓴이</option>
			<option value="qbWrittenDate" selected="selected">작성날짜</option>
			<option value="qbStatus">답장여부</option>
		</c:if>
		<c:if test="${searchKinds eq 'qbWriter'}">
			<option value="qbTitle">제목</option>
			<option value="qbWriter" selected="selected">글쓴이</option>
			<option value="qbWrittenDate">작성날짜</option>
			<option value="qbStatus">답장여부</option>
		</c:if>
		<c:if test="${searchKinds eq 'dbRecruitStatus'}">
			<option value="dbTitle">제목</option>
			<option value="dbWriter">글쓴이</option>
			<option value="dbWrittenDate">작성날짜</option>
			<option value="qbStatus" selected="selected">답장여부</option>
		</c:if>
	</select>
	<input type="text" name="searchText" id="qeustionBoardSearchBar" placeholder="검색하기" value="${searchText}">
	<button>검색</button>
	</form>
		<button id="deleteSelectQeustionBoard">삭제</button>
	</div>


</div>
<c:import url="/WEB-INF/views/layout/footer.jsp" />    