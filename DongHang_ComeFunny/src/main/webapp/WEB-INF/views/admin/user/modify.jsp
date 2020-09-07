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

.userView {
			width: 1200px;
		    margin: 0 auto; 
}

.userInfoTable {
			width: 700px;
   			text-align: center;
    		table-layout: fixed;
    		text-align-last : center;
    		height: 500px;
   			font-size: 25px;
   			display: inline-table;
			}
			
#userImage{
			width: 400px;
			height: 400px;
			float: right;
			margin-top: 50px;
}

.userViewToolbar{
			width: 100px;
			text-align: center;}
			
input {
    width: 231px;
    border: none;
}

</style>

<script type="text/javascript">
$(document).ready(function(){
	$("#userSubmit").click(function(){
		$("#userModifyForm").submit();
	})
	
	$("#userChangeImg").click(function(){
		$("#imgUpload").click();
	})
	
	
	
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


<div class="userView">
	<c:set value="${viewUserMap.viewUser}" var="viewUser"/>
	<form action="modifyImpl" method="post" enctype="multipart/form-data" id="userModifyForm">
	<input type="text" name="uNo" value="${viewUser.uNo}" hidden="">
	<table class="userInfoTable" border="1">
		<caption>회원 상세정보</caption>
		<tr>
			<th>정보</th>
			<th>수정해주세요</th>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="userId" value="${viewUser.userId}">
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="uPw" value="${viewUser.uPw}">
			</td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="uName" value="${viewUser.uName}">
			</td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td><input type="text" name="uBirth" value="${viewUser.uBirth}">
			</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>
			<c:choose>
			<c:when test="${viewUser.uGender eq 0}">
				<input type="radio" id="man"  name="uGender" value="0" checked="checked">
				<label for="man">남자</label>
				<input type="radio" id="woman" name="uGender" value="1">
				<label for="woman" >여자</label>
			</c:when>
			<c:when test="${viewUser.uGender eq 1}">
				<input type="radio" id="man"  name="uGender" value="0">
				<label for="man">남자</label>
				<input type="radio" id="woman" name="uGender" value="1" checked="checked">
				<label for="woman" >여자</label>
			</c:when>
			</c:choose>
			</td>
		</tr>
		<tr>
			<td>닉네임</td>
			<td><input type="text" name="uNick" value="${viewUser.uNick}">
			</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type="text" name="uPhone" value="${viewUser.uPhone}">
			</td>
		</tr>
		<tr>
			<td>메일</td>
			<td><input type="text" name="uMail" value="${viewUser.uMail}">
			</td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input type="text" name="uAddress" value="${viewUser.uAddress}">
			</td>
		</tr>
		<tr>
			<td>동행복권수</td>
			<td><input type="text" name="uDhtCnt" value="${viewUser.uDhtCnt}">
			</td>
		</tr>
		<tr>
			<td>탈퇴여부</td>
			<td>
			<c:choose>
			<c:when test="${viewUser.uIsLeave eq 0}">
				<input type="radio" id="nout" name="uIsLeave" value="0" checked="checked">
				<label for="nout">활동중</label>
				<input type="radio" id="out" name="uIsLeave" value="1" >
				<label for="out">탈퇴</label>
			</c:when>
			<c:when test="${viewUser.uIsLeave eq 1}">
				<input type="radio" id="nout" name="uIsLeave" value="0" >
				<label for="nout">활동중</label>
				<input type="radio" id="out" name="uIsLeave" value="1" checked="checked">
				<label for="out">탈퇴</label>
			</c:when>
			</c:choose>
			</td>
		</tr>
	</table>
	</form>
	<div style ="
		    float: right;
		    position: absolute;
		    left: 1200px;
		    top: 120px;
		    text-align: center;">
		<img src="/resources/image/admin/Kkami2.jpg" class="img-responsive center-block" id="userImage">
		<br>
		<button class="userViewToolbar" id="userChangeImg">사진 변경</button>
				<input id ="imgUpload" type="file" name="userImg" multiple form="userModifyForm">
	</div>
	<hr><br><br>
	<div style="text-align: center;">
		<div>
			<button class="userViewToolbar" id="userSubmit">수정</button>
			<button class="userViewToolbar" id="userCencle">삭제</button>
		</div>
	</div>
</div>








<c:import url="/WEB-INF/views/admin/layout/footer.jsp" />    