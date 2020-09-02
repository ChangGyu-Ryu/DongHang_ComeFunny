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

.userList{
			width: 1200px;
		    margin: 0 auto;
}

.userListToolbar{
			display: inline-block;
}

#userListSearch{
			display: inline;
		    position: relative;
		    margin-left: 0px;
		    left: 200px;
		    right: 100px;
}

#deleteSelectUser{
			width: 100px;
		    position: relative;
		    display: inline;
		    left: 500px;
}

</style>

<script type="text/javascript">
$(document).ready(function(){
	// 전체선택 체크박스 클릭
	$("#selAllUsers").click(function(){
		// 전체선택 체크박스가 체크 되어 있을 경우
		if($("#selAllUsers").prop("checked")){
			$(".selUser").prop("checked", true);
		}
		// 전체선택 체크박스가 체크되어 있지 않을 경우 
		else{
			$(".selUser").prop("checked", false);
		}
	});
	
	// 체크박스 클릭
	$(".selUser").click(function(){
		// 전체선택 중, 하나의 체크박스가 체크해제될 경우
		if($("#selAllUsers").prop("checked")){
			$("#selAllUsers").prop("checked", false);
		}
	});
	
	// 체크 삭제버튼을 클릭했을 경우
	$("#deleteSelectUser").click(function(){
		// selUsers 배열선언
		var uNos = new Array();
		$(".selUser:checked").each(function(){
			uNos.push(this.value);
// 			console.log(selUnos);
		});
		
// 		해당 위치로 이동한다
		$(location).attr("href","delete?delUnos="+uNos);
		
	});
	
	// 퀵 삭제버튼을 클릭했을 경우
	$(".deleteUser").click(function(){
		var uNos = $(this).attr('value');
// 		console.log(delUno);
		$(location).attr("href","delete?delUnos="+uNos);
		
		});
	
	// 퀵 수정 버튼을 클릭했을 경우
	$(".modifyUser").click(function(){
		var uNo = $(this).attr('value');
// 		console.log(modiUno)
		$(location).attr("href","modify?uNo="+uNo)
	});
});
	

</script>


<div class="menuBar">
    	<ul class="mainMenu">
    		<li><a href="list">회원관리</a></li>
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
    		<li><a href="/admin/notice/list">공지사항 관리</a></li>
    		<li><a href="#">결제 관리</a></li>
    	</ul>
    </div>


    
<div class="userList">
    
	<div style="text-align-last: center;">
	<table class="table table-bordered table-hover">
		<caption>현재 가입중인 회원의 목록</caption>
		<thead>
			<tr class="active">
				<th><input type="checkbox" id="selAllUsers"></th>
				<th>회원번호</th>
				<th>회원아이디</th>
				<th>회원닉네임</th>
				<th>회원이름</th>
				<th>가입날짜</th>
				<th>탈퇴여부</th>
				<th>퀵 버튼</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${userData.userList}" var="user">
			<tr class="userListRow">
				<td><input type="checkbox" class="selUser" value="${user.uNo}" name="uNo"></td>
				<td>${user.uNo}</td>
				<td>
				<a href="view?uNo=${user.uNo}">
				${user.userId}
				</a>
				</td>
				<td>${user.uNick}</td>
				<td>${user.uName}</td>
				<td>${user.uRegDate}</td>
				<c:choose>
				<c:when test="${user.uIsLeave eq 0}">
				<td></td>
				</c:when>
				<c:when test="${user.uIsLeave eq 1}">
				<td>대기중</td>
				</c:when>
				</c:choose>
				<td><button class= "modifyUser" value="${user.uNo}">수정</button>
					<button class= "deleteUser" value="${user.uNo}">삭제</button>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	
	</table>
	</div>
	<div class="userListToolbar">
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
	 
	<form action="list" method="get" id="userListSearch">
	 <!-- 제이쿼리 이용해서 기본값을 검색한 값으로 설정하기 -->
		 	<select id="userSearch" name="searchKinds" >
		 		<c:if test="${searchKinds eq '' and searchText eq ''}">
					<option value="userId" >아이디</option>
					<option value="userName">이름</option>
					<option value="userNick">닉네임</option> 
		 		</c:if>
		 		<c:if test="${searchKinds eq 'userId' or searchText eq null}">
					<option value="userId" selected="selected">아이디</option>
					<option value="userName">이름</option>
					<option value="userNick">닉네임</option> 
		 		</c:if>
		 		<c:if test="${searchKinds eq 'userName'}">
		 			<option value="userId" >아이디</option>
					<option value="userName" selected="selected">이름</option>
					<option value="userNick">닉네임</option> 
				</c:if>
				<c:if test="${searchKinds eq 'userNick'}">
					<option value="userId" >아이디</option>
					<option value="userName">이름</option>
					<option value="userNick" selected="selected">닉네임</option>  
				</c:if>
			</select>
				<input type="text" name="searchText" id="searchText" placeholder= "검색하기" value="${searchText }">
			<button>검색</button>
	</form>
		<button id="deleteSelectUser">삭제</button>
	</div>
	

</div>
<c:import url="/WEB-INF/views/layout/footer.jsp" />    