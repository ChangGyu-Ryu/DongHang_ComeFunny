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

.adminMemberView {
			width: 1200px;
		    margin: 0 auto; 
}

.memberInfoTable {
			width: 700px;
   			text-align: center;
    		table-layout: fixed;
    		text-align-last : center;
    		height: 500px;
   			font-size: 25px;
   			display: inline-table;
			}
			
#adminMemberImage{
			width: 400px;
			height: 400px;
			float: right;
			margin-top: 50px;
}

.adminMemberViewToolbar{
			width: 100px;
			text-align: center;}

</style>

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


<div class="adminMemberView">
	<c:forEach items="${viewUserMap}" var="viewUser" />
		<table class="memberInfoTable" border="1">
		<caption>회원 상세정보</caption>
		<tr>
			<td>아이디</td>
			<td><span>${viewUser.userId}</span></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>${viewUser.uPw}</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${viewUser.uName}</td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td>${viewUser.uBirth}</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>${viewUser.uGender}</td>
		</tr>
		<tr>
			<td>닉네임</td>
			<td>${viewUser.uNick}</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>${viewUser.uPhone}</td>
		</tr>
		<tr>
			<td>메일</td>
			<td>${viewUser.uMail}</td>
		</tr>
		<tr>
			<td>주소</td>
			<td>${viewUser.uAddress}</td>
		</tr>
		<tr>
			<td>동행복권수</td>
			<td>${viewUser.UDHTCNT}</td>
		</tr>
		<tr>
			<td>가입날짜</td>
			<td>${viewUser.uRegDate}</td>
		</tr>
		<tr>
			<td>탈퇴여부</td>
			<td>${viewUser.uIsLeave}</td>
		</tr>
	</table>
	<img src="${userImg.uiSavePath}" class="img-responsive center-block" id="adminMemberImage">
	
	<hr>
	<div style="text-align: center;">
		<div>
			<button class="adminMemberViewToolbar" id="adminMemberModify">수정</button>
			<button class="adminMemberViewToolbar" id="adminMemberList">목록</button>
			<button class="adminMemberViewToolbar" id="adminMemberDelete">삭제</button>
		</div>
	</div>
</div>

<c:import url="/WEB-INF/views/layout/footer.jsp" />    