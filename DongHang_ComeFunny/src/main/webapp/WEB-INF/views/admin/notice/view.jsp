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

.adminNoticeView {
			width: 1200px;
		    margin: 0 auto;
		   	text-align: center;
}

.noticeInfoTable {
			width: 1000px;
   			text-align: center;
    		table-layout: fixed;
    		text-align-last : center;
    		height: 500px;
   			font-size: 25px;
   			display: inline-table;
			}
			
		


.adminNoticeViewToolbar{
			width: 100px;
			text-align: center;}

</style>

<script type="text/javascript">
   
   function submitData(url){
      location.href = url;
   } 
   
   function downloadFile(ofname, rfname){
       location.href = "downloadFile?"
            +"ofname="+ofname
            +"&rfname="+rfname;
 
      
   }
</script>

<div class="menuBar">
    	<ul class="mainMenu">
    		<li><a href="/admin/member/list">회원관리</a></li>
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


<div class="adminNoticeView">

	<table class="noticeInfoTable" border="1">
		<caption>공지사항 상세정보</caption>
		<tr>
			<td>글번호</td>
			<td>${viewNotice.nbNo}</td>
		</tr>
		<tr>
			<td>공지사항 제목</td>
			<td>${viewNotice.nbTitle}</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>관리자</td>
		</tr>
		<tr style="height: 400px;">
			<td>공지사항 내용</td>
			<td>${viewNotice.nbContent}</td>
		</tr>
	<c:forEach items="${viewNoticeFile}" var="noticeFile" varStatus="status">
		<tr>			
			<td colspan="2">
				<div class="freeview__table__download">
					<span>${status.count}. : &nbsp;</span>
				 <a href="javascript:downloadFile('${noticeFile.nfOriginFileName}', '${noticeFile.nfStoredFileName}')">
				 	${noticeFile.nfOriginFileName}</a>
			</div>
			</td>
		</tr>
		</c:forEach>
	</table>
	
	
	<hr>
	<div style="text-align: center;">
		<div>
			<button class="adminNoticeViewToolbar" id="adminNoticeModify">수정</button>
			<button class="adminNoticeViewToolbar" id="adminNoticeList">목록</button>
			<button class="adminNoticeViewToolbar" id="adminNoticeDelete">삭제</button>
		</div>
	</div>
</div>

<c:import url="/WEB-INF/views/layout/footer.jsp" />    