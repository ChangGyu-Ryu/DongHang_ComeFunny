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

.adminQuestionView {
			width: 1200px;
		    margin: 0 auto;
		   	text-align: center;
}

.questionInfoTable {
			width: 1000px;
   			text-align: center;
    		table-layout: fixed;
    		text-align-last : center;
    		height: 500px;
   			font-size: 25px;
   			display: inline-table;
			}
			
		


.adminQuestionViewToolbar{
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
   
   $(document).ready(function(){
   $("#adminAnswerModify").click(function(){
		var qbNo = ${viewQuestion.QBNO};
		console.log(qbNo);
		$(location).attr("href","modifyAnswer?qbNo="+qbNo);
		
		});
   
   
   $("#adminAnswerWrite").click(function(){
		var qbNo = ${viewQuestion.QBNO};
		console.log(qbNo);
		$(location).attr("href","writeAnswer?qbNo="+qbNo);
		
		});
	
   if(${viewQuestion.QBSTATUS} == 1){
   $("#adminAnswerDelete").click(function(){
		var abNo = ${viewQuestion.ABNO}+"";
		console.log(abNo);
		$(location).attr("href","deleteAnswer?abNo="+abNo);
		
		});
   }
});
   
</script>

<div class="menuBar">
    	<ul class="mainMenu">
    		<li><a href="/admin/member/list">회원관리</a></li>
    		<li><a href="#">게시판 관리</a>
    			<ul class="boardMenu">
    				<li><a href="/admin/boards/goBoard/list">함께가요 게시판</a></li>
    				<li><a href="/admin/boards/doBoard/list">함께해요 게시판</a></li>
    				<li><a href="/admin/boards/freeBoard/list">자유 게시판</a></li>
    				<li><a href="/admin/boards/reviewBoard/list">후기 게시판</a></li>
    			</ul>
    		</li>
    		<li><a href="list">1대1문의 관리</a></li>
    		<li><a href="/admin/notice/list">공지사항 관리</a></li>
    		<li><a href="#">결제 관리</a></li>
    	</ul>
    </div>


<div class="adminQuestionView">

	<table class="questionInfoTable" border="1">
		<caption>문의사항 상세정보</caption>
		<tr>
			<td>글번호</td>
			<td>${viewQuestion.QBNO}</td>
		</tr>
		<tr>
			<td>문의글 제목</td>
			<td>${viewQuestion.QBTITLE}</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${viewQuestion.UNAME}</td>
		</tr>
		<tr style="height: 400px;">
			<td>공지사항 내용</td>
			<td>${viewQuestion.QBCONTENT}</td>
		</tr>
	<c:forEach items="${viewQuestionFile}" var="QuestionFile" varStatus="status">
		<tr>			
			<td colspan="2">
				<div class="freeview__table__download">
					<span>${status.count}. : &nbsp;</span>
				 <a href="javascript:downloadFile('${QuestionFile.qfOriginFileName}', '${QuestionFile.qfStoredFileName}')">
				 	${QuestionFile.qfOriginFileName}</a>
			</div>
			</td>
		</tr>
		</c:forEach>
	</table>
	<hr>
	<c:choose>
		<c:when test="${viewQuestion.QBSTATUS ne 1 }">
			<h2>답변 대기중입니다.</h2>
		</c:when>
			
		<c:when test="${viewQuestion.QBSTATUS eq 1 }">
			<table class="questionInfoTable" border="1">
				<caption>문의사항 답장정보</caption>
				<tr>
					<td>답장번호</td>
					<td>${viewQuestion.ABNO}</td>
				</tr>
				<tr>
					<td>답장글 제목</td>
					<td>${viewQuestion.ABTITLE}</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td>관리자</td>
				</tr>
				<tr style="height: 400px;">
					<td>공지사항 내용</td>
					<td>${viewQuestion.ABCONTENT}</td>
				</tr>
			<c:forEach items="${viewAnswerFile}" var="AnswerFile" varStatus="status">
				<tr>			
					<td colspan="2">
						<div class="freeview__table__download">
							<span>${status.count}. : &nbsp;</span>
						 <a href="javascript:downloadFile('${AnswerFile.afOriginFileName}', '${AnswerFile.afStoredFileName}')">
						 	${AnswerFile.afOriginFileName}</a>
					</div>
					</td>
				</tr>
				</c:forEach>
			</table>
		</c:when>
	</c:choose>
	
	
	
	
	
	<hr>
	<div style="text-align: center;">
		<div>
			<c:choose>
				<c:when test="${viewQuestion.QBSTATUS eq 0}">
			<button class="adminQuestionViewToolbar" id="adminAnswerWrite">작성</button>
			<button class="adminQuestionViewToolbar" id="adminQuestionList">목록</button>
				</c:when>
				
				<c:when test="${viewQuestion.QBSTATUS eq 1}">
			<button class="adminQuestionViewToolbar" id="adminAnswerModify">수정</button>
			<button class="adminQuestionViewToolbar" id="adminQuestionList">목록</button>
			<button class="adminQuestionViewToolbar" id="adminAnswerDelete">삭제</button>
				</c:when>
			</c:choose>
		</div>
	</div>
</div>

<c:import url="/WEB-INF/views/admin/layout/footer.jsp" />    