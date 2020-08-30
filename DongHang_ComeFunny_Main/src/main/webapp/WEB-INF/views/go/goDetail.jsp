<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>함께가요 :: 상세보기</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/go/goDetail.css" />

<!-- JQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<!-- 부트스트랩 -->
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	
	$('#golist').click(function() { 
	 	$('.contentbox2').fadeToggle(300);
	 	$('html, body').animate({ scrollTop :  $(document).height()}, 100);
	            return false;
	});	 
	
});
//하트 누르면 이미지 변경 //수정하자
	function toggleImg() {
      document.getElementById("change").src="/resources/image/go/heart_pick.png" ;
    }
</script>
<script type="text/javascript">
	function selectUrl(url){
		console.log("클릭됨됨됨됨");
		var root = '<%=request.getContextPath()%>';
		document.querySelector('#form-data').action = root + url;
	}
</script>

<script type="text/javascript">
$(document).ready(function() {
	
	$("#goDhApplyBtn").click(function() {
		console.log("클릭됨");
		
		 $.ajax({
			url: "/go/goApply",
			type: "POST",
			data: {
				gbNo: '${goDetailInfo.goBoardUserInfo.GBNO }' 
			}
			, success: function(result) {
				if(result == 1){
                	alert("동행 신청 완료되었습니다.");
                	location.href=window.document.URL;
             	}else{
                	alert("동행 신청 실패되었습니다.");
                	location.href=window.document.URL;
             	}
			}
			
		});
	
	}); 
	
});
</script>

</head>
<body>
<div class="detail-container">
<!-- header -->
	<!-- 로고 -->
	<div>
	   <div class="logo">
	      <div class="logo-img">
	      <a href="/"><img class="logo-img" alt="로고이미지" src="/resources/image/header/logo.png" ></a>
	      </div>
		</div>
	</div>
  	<!-- 메뉴바 -->
	<div class="main_menu">
		<div class="dropdown">
	 		<div class="dropbtn"><a href="/go">함께가요</a></div>
		</div>			
		<div class="dropdown">
	  		<div class="dropbtn"><a href="/do">함께해요</a></div>
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
	<div class="contentbox">
		<!-- 상단타이틀부분-->
		<div class="contitle">
<!-- 			<div class="gotag"> -->
				<c:choose>
                     <c:when test="${goDetailInfo.goBoardUserInfo.GBRECRUITSTATUS eq 0 }" ><span class="gotag">모집중</span></c:when>
                     <c:when test="${goDetailInfo.goBoardUserInfo.GBRECRUITSTATUS eq 1 }" ><span class="gotag2">모집마감</span></c:when>
                 </c:choose>  
<!-- 			</div> -->
			<div class="float-right"><a href="/go" class="goatag"><span class="glyphicon glyphicon-remove"></span></a></div>
		</div>
		
		<!-- 프로필 부분 -->
		<div class="profile">
			<div class="profile-img">
				<!-- 프로필 기본 이미지 -->
				<c:if test="${empty goDetailInfo.goBoardUserInfo.UFSTOREDFILENAME }">
					<img src="<%=request.getContextPath() %>/resources/upload/default.png" class="img-circle profile-img" />
				</c:if>
				<!-- 사용자가 등록한 프로필 이미지 -->
				<c:if test="${not empty goDetailInfo.goBoardUserInfo.UFSTOREDFILENAME }">
					<img src="<%=request.getContextPath() %>/resources/upload/${goDetailInfo.goBoardUserInfo.UFSTOREDFILENAME }" class="img-circle profile-img" />
				</c:if>
				<div class="goheart"><img id="change" src="/resources/image/go/heart.png" alt="찜하트" onclick="toggleImg()"/></div>
			</div>
			<div class="profile-name">
				<h3>${goDetailInfo.goBoardUserInfo.USERID }
					<small>
						${goDetailInfo.goBoardUserInfo.AGE} · 
						<c:choose>
							<c:when test="${goDetailInfo.goBoardUserInfo.UGENDER eq '1'}">
								남
							</c:when>
							<c:when test="${goDetailInfo.goBoardUserInfo.UGENDER eq '2'}">
								여
							</c:when> 
						</c:choose>
					</small>
				</h3>
			</div>
			<div class="profile-type">
				<!-- 반복으로 체크박스 내용 뿌려주기 -->
				<!-- 성별 -->
				<span class="typelist">
					<c:choose>
							<c:when test="${goDetailInfo.goBoardUserInfo.UGENDER eq '1'}">
								남자
							</c:when>
							<c:when test="${goDetailInfo.goBoardUserInfo.UGENDER eq '2'}">
								여자
							</c:when> 
					</c:choose>
				</span>
				<c:forEach items="${goDetailInfo.goCheck }" var="goCheck">
					<span class="typelist">
						<c:choose>
							<c:when test="${goCheck.gcValue eq '20'}">
								20대
							</c:when>
							<c:when test="${goCheck.gcValue eq '30'}">
								30대
							</c:when>
							<c:when test="${goCheck.gcValue eq '40'}">
								40대
							</c:when>
							
							<c:when test="${goCheck.gcValue eq 'food'}">
								음식
							</c:when>
							<c:when test="${goCheck.gcValue eq 'photo'}">
								사진
							</c:when>
							<c:when test="${goCheck.gcValue eq 'seeing'}">
								관광
							</c:when>
							<c:when test="${goCheck.gcValue eq 'drink'}">
								술
							</c:when>
							<c:when test="${goCheck.gcValue eq 'shopping'}">
								쇼핑
							</c:when>
							<c:when test="${goCheck.gcValue eq 'etc'}">
								기타
							</c:when>
						</c:choose>
						</span>
				</c:forEach>	
				
			</div>
		</div>
		
		<!-- 본문 -->
		<div class="article">
			<!-- 본문제목 -->
			<div class="article-title">
				<span><img src="/resources/image/go/quotes_icon.png" alt="아이콘"/></span>
				<span>${goDetailInfo.goBoardUserInfo.GBTITLE }</span>
			</div>
			<!-- 본문 내용 -->
			<div class="article-text">
				${goDetailInfo.goBoardUserInfo.GBCONTENT }
			</div>
		</div>
		
		<!-- 후기 부분 최대 3개 -->
		<div class="rvtop3">
			<!-- 타이틀-->
			<div class="rvtop3-title"> 
				호스트 후기 <span>★★★★★</span> <span>( ${goDetailInfo.hostReviewCnt } )</span>
				<div class="ialign float-right"><a href="#">더보기</a></div>
			</div>
		
			<div class="rvmargin">
			<!-- 이부분 반복 -->
			<c:forEach items="${goDetailInfo.hostReview }" var="host">
			<div class="rvtop3-mate">
				<div class="rvtitle">
				<div class="rvttitle">
					<!-- 프로필 기본 이미지 -->
					<c:if test="${empty host.UFSTOREDFILENAME }">
						<img src="<%=request.getContextPath() %>/resources/upload/default.png" class="img-circle" />
					</c:if>
					
					<!-- 사용자가 등록한 프로필 이미지 -->
					<c:if test="${not empty host.UFSTOREDFILENAME }">
						<img src="<%=request.getContextPath() %>/resources/upload/${host.UFSTOREDFILENAME }" class="img-circle" />
					</c:if>		
				</div>
				<div class="rvttitle">
					<h4>${host.USERID }</h4>
					<h6><fmt:formatDate var="date" value="${host.RBWRITTENDATE}" pattern="YYYY-MM-dd"/>${date}</h6>
				</div>
				</div>
				<div class="rvtext">
					${host.RBCONTENT }
				</div>
			</div>
			</c:forEach>
			</div>
		</div>
		
		<!-- 마지막 버튼 부분 -->	
		
		<!-- 글쓴이한테만 보임 -->
		<div class="dobtn" style="width: 850px; margin: auto; margin-top: 5%; height: 35px;">
			<a class="btn btn-warning " href="/go/modify?gbNo=${goDetailInfo.goBoardUserInfo.GBNO}" >수정</a> 
	        <a class="btn btn-danger ">삭제</a> 
		</div>
			
		<div class="dobtn" style="width: 850px; margin: auto; margin-top: 1%; text-align: center; height: 35px;">
	        <div class="ialign float-left">  
	            <!-- 신청목록 내용 보여짐 -->
	            <a id="golist" class="btn btn-primary ">신청목록</a>
	            
	            <div class="ialign btncen">
	            <a class="btn btn-default ">쪽지보내기</a>
				<button class="btn btn-primary" id="goDhApplyBtn">신청하기</button>
	            </div>
			</div>
			
			
		
         	<div class="ialign float-right"> <!-- 공유하기 -->
            	<a class="btn btn-default">공유하기</a>
         	</div>
		</div>	
	</div>
	

<!-- content2 -->
	<!-- 신청 목록 박스 -->
	<div class="contentbox2"> 
		<!-- 타이틀 -->
		<div class="contitle"> 신청 목록 </div>
		
		<!-- 신청 목록 -->
		<div class="mate-list">
		
			<!-- 이부분 반복 -->
			<c:forEach items="${goDetailInfo.goDhApplylist }" var="goApplylist">
			<div class="mateone">
				<div class="mtitle">
					<!-- 프로필 기본 이미지 -->
					<c:if test="${empty goApplylist.UFSTOREDFILENAME }">
						<img src="<%=request.getContextPath() %>/resources/upload/default.png" class="img-circle"/>
					</c:if>
					<!-- 사용자가 등록한 프로필 이미지 -->
					<c:if test="${not empty goApplylist.UFSTOREDFILENAME }">
						<img src="<%=request.getContextPath() %>/resources/upload/${goApplylist.UFSTOREDFILENAME }" class="img-circle"/>
					</c:if>
				</div>
				<div class="mtitle">
					<h4>${goApplylist.USERID }</h4>
					<h5>${goApplylist.AGE } ·
						<c:choose>
							<c:when test="${goApplylist.UGENDER eq '1'}">
								남
							</c:when>
							<c:when test="${goApplylist.UGENDER eq '2'}">
								여
							</c:when> 
						</c:choose>
					</h5>
				</div>
				<div class="mbtn"> <!-- 작성자만 볼수 있음 -->
					<a class="btn btn-primary">수락</a>
					<a class="btn btn-default">거절</a>
				</div>
			</div>
			</c:forEach>
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
</body>
</html>