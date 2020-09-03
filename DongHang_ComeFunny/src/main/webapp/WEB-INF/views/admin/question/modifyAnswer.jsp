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
	
});
   
</script>

<script type="text/javascript">
      function deleteFile(afNo){
         var url = 'deleteFile';
         var xhr = new XMLHttpRequest();
         //통신을 위한 시작줄 작성
         xhr.open('POST',url);
         //http request header 설정
         xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
         //http request body 설정
         //xhr.send() : 전송할 데이터가 있다면 파라미터에 넣어서 보내주면 된다.
         xhr.send('afNo='+afNo);
         console.dir(xhr.response);
         xhr.addEventListener('load',function(){
             var cssSelector = xhr.response;
             if(cssSelector != 'fail'){
             console.dir(document.querySelector(cssSelector));
             document.querySelector(cssSelector).outerHTML = '';
          } else {
             alert("파일 삭제에 실패하였습니다.");
          }   
       })
    }
</script>

<script type="text/javascript">
$(document).ready(function() {
	
	//작성버튼 동작
	$("#adminAnswerModify").click(function() {
		
		// form submit
		$("#modify").submit();
	});
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
<form action="modifyAnswerImpl" method="post" id="modify" enctype="multipart/form-data">
			<table class="questionInfoTable" border="1">
				<caption>문의사항 답장정보</caption>
				<tr>
					<td>답장번호</td>
					<td><input type="text" value="${viewQuestion.ABNO}" name="abNo" hidden="" />${viewQuestion.ABNO}</td>
				</tr>
				<tr>
					<td>답장글 제목</td>
					<td><input type="text" value="${viewQuestion.ABTITLE}" name="abTitle" /></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td>관리자</td>
				</tr>
				<tr style="height: 400px;">
					<td>공지사항 내용</td>
					<td><input type="text" value="${viewQuestion.ABCONTENT}" name="abContent" /></td>
				</tr>
				<tr>
				<td>파일업로드</td>
				<td><input type="file" name="answerFiles" multiple/></td>
				</tr>
			<c:forEach items="${viewAnswerFile}" var="answerFile" varStatus="status">
				<tr id='f${answerFile.afNo}'>			
					<td colspan="2">
						<div class="freemodify__table__download">
							<span>${status.count}. : &nbsp;</span>
							
						 <a href="javascript:deleteFile('${answerFile.afNo}')" style="text-decoration: none;">
							${answerFile.afOriginFileName} &nbsp; <i class="fas fa-times"></i></a>
						</div>
					</td>
				</tr>
				</c:forEach>
			</table>
		</form>
	
	
	
	
	
	<hr>
	<div style="text-align: center;">
		<div>
			<c:choose>
				<c:when test="${viewQuestion.QBSTATUS ne 1}">
			<button class="adminQuestionViewToolbar" id="adminAnswerWrite">작성</button>
			<button class="adminQuestionViewToolbar" id="adminQuestionList">목록</button>
			<button class="adminQuestionViewToolbar" id="adminAnswerDelete">삭제</button>
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

<c:import url="/WEB-INF/views/layout/footer.jsp" />    