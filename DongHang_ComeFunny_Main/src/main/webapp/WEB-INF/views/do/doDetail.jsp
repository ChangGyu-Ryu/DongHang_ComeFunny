<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>함께해요 :: 상세보기</title>

<!-- doDetail.css -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/do/doDetail.css" />

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
   
   //버튼 누르면 toggle되고 스크롤 하단으로 내리기
   $('#dolist').click(function() { 
       $('.contentbox2').fadeToggle(300);
       $('html, body').animate({ scrollTop :  $(document).height()}, 100);
               return false;
   });    
   
});

//하트 누르면 이미지 변경 //수정하자
   function toggleImg() {
      document.getElementById("change").src="/resources/image/do/heart_pick.png" ;
    }

</script>
</head>
<body>

<div class="detail-container">
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
	<div class="contentbox">
		<div class="tour">
   	 		<div class = "tourinfo"> 
	        	<div class="tour-img">
		         	<!-- 장소사진 -->
		            <img src="/resources/image/do/korea-2777849_1280.jpg"/>
		            <div class="goheart"><img id="change" src="/resources/image/do/heart.png" alt="찜하트" onclick="toggleImg()"/></div>
	         	</div>
	         
	         	<div class="gotag">모집중</div>
	         	<div class="float-right"><a href="#" class="goatag"><span class="glyphicon glyphicon-remove"></span></a></div>
	        
	        
		         <!-- 컨텐츠  제목 내용 -->
		         <div id="contents">
	        		 <div id="contentsTitle">먹자 골목 투어</div><div id="contentsDate">2020-08-10</div> 
		 		 </div>
		 		 
		 		 <div class="article-text">
				            같이 대구 관광하면서 맛난거 먹고 사진남겨요!!!
				            같이 숙소도 쉐어할  한두명만 구해여 ㅎ ㅎ ㅎ
				            궁금하신거 있으면 쪽지로 연락주세요~~!! 등등 자유롭게 작성
				            작성한 양식대로 올라가야하는데 말이지...          
	        	 </div>
		 		
		 		 <!-- 가격및 카테고리 -->
		 		 <div id="categoryBox">
		 		 	<div id="cost">15000 ￦</div>
	 		 		
	 		 		
	 		 		<div class="profile-type">
					            <span class="typelist">20대</span>
					            <span class="typelist">30대</span>
					            <span class="typelist">대구</span>
					            <span class="typelist">여성</span>
					            <span class="typelist">사진</span>
					            <span class="typelist">음식</span>
					            <span class="typelist">쇼핑</span>
	       			</div>
	         
					<button id="sendMsgBtn">쪽지 보내기</button>	
					<button id="applyBtn">신청하기</button>	
		 		 </div>
	 		 
			</div>
		</div>
		
		<!-- 호스트 소개 -->
		<div id="hostInfoBox">
			<div class="rvtop3-title">호스트 소개</div>
			
			<div id="hostInfo">
				<div class="profile">
         			<div class="profile-img">
            		<img src="/resources/image/main/profileex.jpg" class="img-circle" />
            		</div>
            		
            		<div class="profile-name">
            			<h3>동행러버 </h3>
            			<small>20대 · 여</small>
            			<p>★★★★★</p>
         			</div>
         			
				</div>
				
				<!-- 호스트 후기 -->
				<div id="hostcomment">
				         <!-- 이부분 반복 -->
				         <div class="rvtop3-mate">
				            <div class="rvtitle">
					            <div class="rvtimg"><img src="/resources/image/main/profileex.jpg" class="img-circle"/></div>
					            <div class="rvttitle">
					               <h4>동행lover</h4>
					               <h6>2020-05-12</h6>
					            </div>
				            </div>
				            <div class="rvtext">
				               	너무좋았어요 호스트분도 친절하고 최고 ㅎㅎ
				               	후기좀더 길게써본다 과연..
				            </div>
				         </div>
				         
				         <!-- 이부분 반복 -->
				         <div class="rvtop3-mate">
				            <div class="rvtitle">
					            <div class="rvtimg"><img src="/resources/image/main/profileex.jpg" class="img-circle"/></div>
					            <div class="rvttitle">
					               <h4>동행lover</h4>
					               <h6>2020-05-12</h6>
					            </div>
				            </div>
				            <div class="rvtext">
				               	너무좋았어요 호스트분도 친절하고 최고 ㅎㅎ
				               	후기좀더 길게써본다 과연..
				            </div>
				         </div>
				         
				         <!-- 이부분 반복 -->
				         <div class="rvtop3-mate">
				            <div class="rvtitle">
					            <div class="rvtimg"><img src="/resources/image/main/profileex.jpg" class="img-circle"/></div>
					            <div class="rvttitle">
					               <h4>동행lover</h4>
					               <h6>2020-05-12</h6>
					            </div>
				            </div>
				            <div class="rvtext">
				               	너무좋았어요 호스트분도 친절하고 최고 ㅎㅎ
				               	후기좀더 길게써본다 과연..
				            </div>
				         </div>
				         
				</div><!-- hostcomment end -->

         	</div><!-- hostInfo end -->
		</div><!-- hostInfoBox end -->
	
		
		<div id="inform">
			<div class="rvtop3-title">유의사항</div>
			<p>이상을 품었기 때문이다 그러므로 그들은 길지 아니한 목숨을 사는가 싶이 살았으며 그들의 그림자는 천고에 사라지지 않는 것이다 이것은 현저하게 일월과 같은 예가 되려니와 그와 같지 못하다 할지라도 창공에 반짝이는 뭇 별과 같이관리자가 미리 등록해논 유의사항이 뜹니다 간단히 안내사항같은느낌 </p>
		</div>
		
		<!-- 마지막 버튼 부분 -->		
		<div class="dobtn">
	        <div class="ialign float-left btn1">  
	            <!-- 신청목록 내용 보여짐 -->
	            <a id="dolist" class="btn btn-primary ">신청목록</a>
	            <a class="btn btn-warning ">수정</a> 
	        	<a class="btn btn-danger ">삭제</a> 
			</div>
		
         	<div class="ialign float-right btn3"> <!-- 공유하기 -->
            	<a class="btn btn-default">공유하기</a>
         	</div>
		</div>
		
		
	</div><!-- contentbox -->
	
	
	<!-- content2 -->
<!-- 신청 목록 박스 -->
<div class="contentbox2"> 
    <!-- 타이틀 -->
	<div class="contitle"> 신청 목록 </div>
      
    <!-- 신청 목록 -->
	<div class="mate-list">
      
		<!-- 이부분 반복 -->
		<div class="mateone">
			<div class="mtitle"><img src="/resources/image/main/profileex.jpg" class="img-circle"/></div>
			<div class="mtitle">
				<h4>lover</h4>
				<h5>20대 · 여자</h5>
			</div>
		
			<div class="mbtn"> 
				<!-- 작성자만 볼수 있음 -->
				<a class="btn btn-primary">수락</a>
				<a class="btn btn-default">거절</a>
			</div>
		</div>
		
		<!-- 이부분 반복 -->
		<div class="mateone">
			<div class="mtitle"><img src="/resources/image/main/profileex.jpg" class="img-circle"/></div>
			<div class="mtitle">
				<h4>lover</h4>
				<h5>20대 · 여자</h5>
			</div>
		
			<div class="mbtn"> 
				<!-- 작성자만 볼수 있음 -->
				<a class="btn btn-primary">수락</a>
				<a class="btn btn-default">거절</a>
			</div>
		</div>
		
		<!-- 이부분 반복 -->
		<div class="mateone">
			<div class="mtitle"><img src="/resources/image/main/profileex.jpg" class="img-circle"/></div>
			<div class="mtitle">
				<h4>lover</h4>
				<h5>20대 · 여자</h5>
			</div>
		
			<div class="mbtn"> 
				<!-- 작성자만 볼수 있음 -->
				<a class="btn btn-primary">수락</a>
				<a class="btn btn-default">거절</a>
			</div>
		</div>
		
	</div><!-- mate-list end -->        
         	
         
         
</div>
	
	
	
	
	
	
</div><!-- detail-container -->
	
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
	
</body>
</html>
