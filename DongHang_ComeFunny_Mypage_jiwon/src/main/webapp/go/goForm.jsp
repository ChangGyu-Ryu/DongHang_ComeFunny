<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>함께가요 :: 글쓰기</title>
<!-- goForm.css -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/go/goForm.css" />

<!-- JQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<!-- 부트스트랩 -->
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<!-- 스마트 에디터2 라이브러리 -->
<script type="text/javascript"
 src="/resources/se2/js/service/HuskyEZCreator.js" charset="utf-8"></script>
</head>

<!-- <form>태그의 submit을 수행하면 editor에 작성한 내용을 <textarea>에 반영 -->
<script type="text/javascript">
function submitContents(elClikedObj) {
   
   //에디터의 내용을 #content에 반영
   oEditors.getById["goContent"].exec("UPDATE_CONTENTS_FIELD", []);
   
   try {
      elClikedObj.form.submit();
   } catch(e) {
      
   }
   
   
}
</script> 

<body>
<div class="body-container">
<!-- header -->
	<!-- 로고 -->
	<div>
	   <div class="logo">
	      <div class="logo-img">
	      <a href="/main/main.jsp"><img class="logo-img" alt="로고이미지" src="/resources/image/header/logo.png" ></a>
	      </div>
		</div>
	</div>
		
  	<!-- 메뉴바 -->
	<div class="main_menu">
		<div class="dropdown">
	 		<div class="dropbtn"><a href="../go/go.jsp">함께가요</a></div>
		</div>			
		<div class="dropdown">
	  		<div class="dropbtn"><a href="../do/do.jsp">함께해요</a></div>
		</div>
		<div class="dropdown">
	  		<div class="dropbtn"><a href="#">커뮤니티</a></div>
	 	 	<div class="dropdown-content">
	    		<a href="../board/freelist">자유게시판</a>
	    		<a href="../board/reviewlist">후기게시판</a>
	 	 	</div>
		</div>
		<div class="dropdown">
	  		<div class="dropbtn"><a href="#">고객센터</a></div>
	  		<div class="dropdown-content">
	    		<a href="#">공지사항</a>
	    		<a href="#">문의게시판</a>
	  		</div>
		</div>
		<div class="dropdown">
	  		<div class="dropbtn"><a href="#">실시간채팅</a></div>
		</div>
	</div>

<!-- content -->
	<div class = "gowrite"> 
		<div class = "gowritebox">
			<!-- title -->
			<div class = "gowrite-title">
				<div class = "gowrite-label"><span>함께가요</span></div>
				<span class="gowrite-text">동행 모집하기</span>
			</div>
			
			<!-- table -->
			<table class="gowrite-table">
			<tr>
				<td>카테고리</td>
				<td colspan="3">
				<div class="tdleft">
					<select name="godate" class="selectbox">
	                     <option value="none" selected="selected" disabled="disabled">날짜</option>
	                     <option value="1">1월-3월</option>
	                     <option value="2">4월-6월</option>
	                     <option value="3">7월-9월</option>
	                     <option value="4">10월-12월</option>
	                </select>
	                
	                <select name="goarea" class="selectbox">
	                     <option value="none" selected="selected" disabled="disabled">지역</option>
	                     <option value="seoul">서울</option>
	                     <option value="jeju">제주</option>
	                     <option value="incheon">인천</option>
	                     <option value="daegu">대구</option>
	                     <option value="busan">부산</option>
	                     <option value="daejeon">대전</option>
	                     <option value="gyang">광주</option>
	                </select>
	                
	                <select name="gostate" class="selectbox">
	                     <option value="none" selected="selected" disabled="disabled">상태</option>
	                     <option value="ing">모집중</option>
	                     <option value="finish">모집마감</option>
	                </select>
	            </div>
				</td>
			</tr>
			<tr>
				<td>글 제목</td>
				<td>
					<input type="text" name="go-title" class="form-control" placeholder="제목을 입력하세요.">
				</td>
				<td>인원</td>
				<td>
					<input type="number" max="10" min="1" name="go-count" class="form-control" placeholder="인원을 입력하세요.">
				</td>
			</tr>
			<tr>
				<td>성별</td>
				<td colspan="3">
					<div class="tdleft">
						<span><input type="radio" name="go-gender" value="n"><span>무관</span></span>
						<span><input type="radio" name="go-gender" value="f"><span>남성</span></span>
						<span><input type="radio" name="go-gender" value="m"><span>여성</span></span>
					</div>
				</td>
			</tr>
			<tr>
				<td>연령대</td>
				<td colspan="3">
					<div class="tdleft">
						<span><label><input type="checkbox" name="go-age" value="all"><span>전체</span></label></span>
						<span><label><input type="checkbox" name="go-age" value="20"><span>20대</span></label></span>
		            	<span><label><input type="checkbox" name="go-age" value="30"><span>30대</span></label></span>
		            	<span><label><input type="checkbox" name="go-age" value="40"><span>40대</span></label></span>
					</div>
				</td>
			</tr>
			<tr>
				<td>여행타입</td>
				<td colspan="3">
					<div class="tdleft">
						<span><label><input type="checkbox" name="go-type" value="food"><span>음식</span></label></span>
				    	<span><label><input type="checkbox" name="go-type" value="photo"><span>사진</span></label></span>
				    	<span><label><input type="checkbox" name="go-type" value="seeing"><span>관광</span></label></span>
				    	<span><label><input type="checkbox" name="go-type" value="drink"><span>술</span></label></span>
				    	<span><label><input type="checkbox" name="go-type" value="shopping"><span>쇼핑</span></label></span>
				    	<span><label><input type="checkbox" name="go-type" value="etc"><span>쇼핑</span></label></span>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<textarea id="goContent" name="go-text" class="gotextarea"></textarea>
				</td>
			</tr>
			<tr>		
				<td colspan="4">
				<div class="tdright">
					<span><input type="submit" class ="btn btn-warning btnsize"  value="수정"></span>
					<span><input type="submit" class ="btn btn-danger btnsize"  value="삭제"></span>
					<span><input type="submit" class ="btn btn-primary btnsize"  value="등록"></span>
					<span><input type="button" value="이전으로" class="btn btn-default btnsize"/></span>
				</div>
				</td>
			</tr>
			</table>
		</div>
	</div>
		
	<!-- footer -->
	<div id="footer">
	   <ul class="links">
	         <li><a href="">서비스소개</a></li>
	         <li class="footer_menu"><a href="">이용약관</a></li>
	         <li class="footer_menu"><a href=""><strong>개인정보처리방침</strong></a></li>
	         <li class="footer_menu"><a href="">채용</a></li>
	         <li class="footer_menu"><a href="">고객센터</a></li>
	         <li class="footer_menu"><a href="">개발자센터</a></li>
	         <li class="footer_menu"><a href=""><strong>ⓒ ComeFunny internet Corp.</strong></a></li>
	   </ul>
	</div>
	
	
</div>
<script type="text/javascript">
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
	oAppRef: oEditors,
	elPlaceHolder: "goContent", // 에디터가 적용되는 <textarea>의 id
	sSkinURI: "/resources/se2/SmartEditor2Skin.html", // 에디터 스킨
	fCreator: "createSEditor2",
	htParams: {
		bUseToolbar: true, //툴바 사용여부
		bUseVerticalResizer: false, //입력창 크기 조절 바
		bUseModeChanger: true //글쓰기 모드 탭
	}
	
});
</script>



</body>
</html>