<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/admin/layout/header.jsp" />

<style type="text/css">

.adminMain {
			width: 1200px;
		    margin: 0 auto;
		    height: 625px;
}

#adminMainImage{
			 width: 566px;
	    	 height: 655px;
	  		 margin-right : 170px;
}

.menuBar {
			position : relative;
			left : 120px;
			bottom : 660px;
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

#adminMainListInfo{
			position: relative;
}





</style>



<div class="adminMain">
	<p style="text-align: center;">관리자OOO님 환영합니다</p>
     <img src="/resources/image/admin/Kkami2.jpg" class="img-responsive center-block" id="adminMainImage">
    <div class="menuBar">
    	<ul class="mainMenu">
    		<li><a href="user/list">회원관리</a></li>
    		<li><a href="boards/freeBoard/list">파티관리</a></li>
    		<li><a href="#">게시판 관리</a>
    			<ul class="boardMenu">
    				<li><a href="boards/goBoard/list">함께가요 게시판</a></li>
    				<li><a href="boards/doBoard/list">함께해요 게시판</a></li>
    				<li><a href="boards/freeBoard/list">자유 게시판</a></li>
    				<li><a href="boards/reviewBoard/list">후기 게시판</a></li>
    			</ul>
    		</li>
    		<li><a href="qeustion/list">1대1문의 관리</a></li>
    		<li><a href="notice/list">공지사항 관리</a></li>
    		<li><a href="">결제 관리</a></li>
    	</ul>
		<div id="adminMainListInfo">
			<p>해당 기능에 대한 설명입니다</p>
		</div>
    </div>
</div>
<c:import url="/WEB-INF/views/admin/layout/footer.jsp" />    