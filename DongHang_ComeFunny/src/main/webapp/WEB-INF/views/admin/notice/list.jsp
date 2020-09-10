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

.noticeList{
			width: 1200px;
		    margin: 0 auto;
}

.noticeListToolbar{
			display: inline-block;
}

#noticeListSearch{
			display: inline;
		    position: relative;
		    margin-left: 0px;
		    left: 200px;
		    right: 100px;
}

#deleteSelectNotice{
			width: 100px;
		    position: relative;
		    display: inline;
		    left: 500px;
}

#writeNotice{
			width: 100px;
		    position: relative;
		    display: inline;
		    left: 500px;
}

</style>

<script type="text/javascript">
$(document).ready(function(){
	// 전체선택 체크박스 클릭
	$("#selAllNotices").click(function(){
		// 전체선택 체크박스가 체크 되어 있을 경우
		if($("#selAllNotices").prop("checked")){
			$(".selNotice").prop("checked", true);
		}
		// 전체선택 체크박스가 체크되어 있지 않을 경우 
		else{
			$(".selNotice").prop("checked", false);
		}
	});
	
	// 체크박스 클릭
	$(".selNotice").click(function(){
		// 전체선택 중, 하나의 체크박스가 체크해제될 경우
		if($("#selAllNotices").prop("checked")){
			$("#selAllNotices").prop("checked", false);
		}
	});
	
	// 체크 삭제버튼을 클릭했을 경우
	$("#deleteSelectNotice").click(function(){
		//  배열선언
		var nbNos = new Array();
		$(".selNotice:checked").each(function(){
			nbNos.push(this.value);
// 			console.log(nbNos);
		});
		
// 		해당 위치로 이동한다
		$(location).attr("href","delete?nbNos="+nbNos);
		
	});
	
	// 퀵 삭제버튼을 클릭했을 경우
	$(".deleteNotice").click(function(){
		var nbNos = $(this).attr('value');
// 		console.log(nbNos);
		$(location).attr("href","delete?nbNos="+nbNos);
		
		});
	
	// 퀵 수정 버튼을 클릭했을 경우
	$(".modifyNotice").click(function(){
		var nbNo = $(this).attr('value');
// 		console.log(nbNo)
		$(location).attr("href","modify?nbNo="+nbNo)
	});
	
	// 작성 버튼을 클릭했을 경우
	$("#writeNotice").click(function(){
		$(location).attr("href","write")
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
    				<li><a href="/admin/boards/doBoard/list">함께해요 게시판</a></li>
    				<li><a href="/admin/boards/freeBoard/list">자유 게시판</a></li>
    				<li><a href="/admin/boards/reviewBoard/list">후기 게시판</a></li>
    			</ul>
    		</li>
    		<li><a href="/admin/qeustion/list">1대1문의 관리</a></li>
    		<li><a href="list">공지사항 관리</a></li>
    		<li><a href="#">결제 관리</a></li>
    	</ul>
    </div>


    
<div class="noticeList">
    
	<div style="text-align-last: center;">
	<table class="table table-bordered table-hover">
		<caption>현재 공지사항 목록</caption>
		<thead>
			<tr class="active">
				<th><input type="checkbox" id="selAllNotices"></th>
				<th>공지사항번호</th>
				<th>공지사항제목</th>
				<th>작성날짜</th>
				<th>조회수</th>
				<th>삭제여부</th>
				<th>퀵 버튼</th>
			</tr>
		</thead>
			<c:forEach items="${NoticeData.noticeList}" var="notice" >
		<tbody>
			<tr class="noticeListRow">
				<th><input type="checkbox" class="selNotice" value="${notice.nbNo}"></th>
				<th>${notice.nbNo}</th>
				<td><a href="view?nbNo=${notice.nbNo}">${notice.nbTitle}</a></td>
				<td>${notice.nbWrittenDate}</td>
				<td>${notice.nbHitsCnt}</td>
				<td>${notice.nbIsDel}</td>
				<td><button class= "modifyNotice" value="${notice.nbNo}">수정</button>
					<button class= "deleteNotice" value="${notice.nbNo}">삭제</button>
				</td>
			</tr>
		</tbody>
			</c:forEach>
	
	</table>
	</div>
	<div class="noticeListToolbar">
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
	<form action="list" method="get" id="noticeListSearch">
	
	<select id="noticeSearch" name="searchKinds">
		<c:if test="${searchKinds eq '' and searchText eq ''}">
			<option value="nbTitle">제목</option>
			<option value="nbWrittenDate">작성날짜</option>
		</c:if>
		<c:if test="${searchKinds eq 'nbTitle' or searchText eq null}">
			<option value="nbTitle" selected="selected">제목</option>
			<option value="nbWrittenDate">작성날짜</option>
		</c:if>
		<c:if test="${searchKinds eq 'nbWrittenDate'}">
			<option value="nbTitle">제목</option>
			<option value="nbWrittenDate" selected="selected">작성날짜</option>
		</c:if>
	</select>
	<input type="text" name="searchText" id="noticeSearchBar" placeholder="검색하기" value="${searchText}">
	<button>검색</button>
	</form>
		<button id="writeNotice">작성</button>
		<button id="deleteSelectNotice">삭제</button>
	</div>


</div>
<c:import url="/WEB-INF/views/admin/layout/footer.jsp" />    