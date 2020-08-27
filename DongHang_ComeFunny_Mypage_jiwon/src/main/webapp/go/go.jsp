<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>함께가요</title>

<!-- go.css -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/go/go.css" />

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
	//검색 필터 관련 속성
	//클릭하면 클릭한 속성이 추가됨
	function addKeyFilterObj(data) {
		var textNode = $(data).parent();
		var dataName = $(data).attr('name');
		var dataValue = $(data).attr('value');
		var text = $(data).next().html();
		var btn = $('<span class="tag"><span class="delete" name="' + dataName + '" value="' + dataValue + '">'
				+ text
				+ '</span>'
				+ '<a href="#this" class="delete" onclick="removeKeyFilter($(this).parent()); return false;"><span class="glyphicon glyphicon-remove"></span></a></span>');

		if ($(data).prop('checked')) {
			$('.group').prepend(btn);
		} else {
			removeKeyFilter(textNode); //클릭해제되면 필터적용 함수도 사라짐
		}
	}

	//삭제하면 제거됨
	function removeKeyFilter(data) { //$(data).parent()
		var text = $(data).find('span').text();

		$('.searchtb label span:contains(' + text + ')').prev().prop('checked',
				false); //상단필터
		$('.group .tag span:contains(' + text + ')').parent().remove();
	}

	//초기화
	function resetKeyFilter() {
		$('.searchtb input').prop('checked', false);
		$('.group .tag').remove();
	}
	
</script>

<script type="text/javascript">
//드롭다운
$(document).ready(function() {
	
	$('#dropdownMenu1').click(function() { 
	 	$('.dropdown-menu').toggle();
	});	 
	
});
</script>
</head>
<body>
<div class="go-container">
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
	
	<!-- content-top -->
	<!-- 상단안내이미지 -->
	<div id="go-content">
		<div class="go-title">
			<h1>함께가요!</h1>
			<h1>여행을 함께할 친구를 구해보세요!</h1>
			<h4>즐거운 여행 길, 내 취향에 꼭 맞는 동행을 쉽게 구해보세요!</h4>
		</div>	
	</div>
	
	<!-- 상단검색필터 -->
	<div id="go-search">
		<!-- 검색타이틀 -->
		<div>
			<p class="ialign">어떤 동행을 찾으시나요?</p>
			<form action="#" method="post" id="formid" class="ialign pull-right formbox input-group-btn">
				<input type="text" name="search" class="textbox"/>
				<button type="submit" id="gobtn" class="btn btn-default input-lg"><span class="glyphicon glyphicon-search"></span></button>
			</form>
		</div>
	
		<!--검색 필터 그룹-->
		<div id="go-filter">
			<table class="searchtb">
			  <tr>
			    <td>연령대</td>
			    <td><label><input type="checkbox" onclick="addKeyFilterObj(this);" name="go-age" value="20"><span>20대</span></label></td>
			    <td><label><input type="checkbox" onclick="addKeyFilterObj(this);" name="go-age" value="30"><span>30대</span></label></td>
			    <td><label><input type="checkbox" onclick="addKeyFilterObj(this);" name="go-age" value="40"><span>40대</span></label></td>
			  </tr>
			  <tr>
			    <td>성별</td>
			    <td><label><input type="checkbox" onclick="addKeyFilterObj(this);" name="go-gender" value="m"><span>남성</span></label></td>
			    <td><label><input type="checkbox" onclick="addKeyFilterObj(this);" name="go-gender" value="f"><span>여성</span></label></td>
			  </tr>
			  <tr>
			    <td>여행타입</td>
			    <td><label><input type="checkbox" onclick="addKeyFilterObj(this);" name="go-type" value="food"><span>음식</span></label></td>
			    <td><label><input type="checkbox" onclick="addKeyFilterObj(this);" name="go-type" value="photo"><span>사진</span></label></td>
			    <td><label><input type="checkbox" onclick="addKeyFilterObj(this);" name="go-type" value="seeing"><span>관광</span></label></td>
			    <td><label><input type="checkbox" onclick="addKeyFilterObj(this);" name="go-type" value="drink"><span>술</span></label></td>
			    <td><label><input type="checkbox" onclick="addKeyFilterObj(this);" name="go-type" value="shopping"><span>쇼핑</span></label></td>
			  </tr>
			  <tr>
			    <td>지역</td>
			    <td><label><input type="checkbox" onclick="addKeyFilterObj(this);" name="go-area" value="seoul"><span>서울</span></label></td>
			    <td><label><input type="checkbox" onclick="addKeyFilterObj(this);" name="go-area" value="jeju"><span>제주</span></label></td>
			    <td><label><input type="checkbox" onclick="addKeyFilterObj(this);" name="go-area" value="incheon"><span>인천</span></label></td>
			    <td><label><input type="checkbox" onclick="addKeyFilterObj(this);" name="go-area" value="daegu"><span>대구</span></label></td>
			    <td><label><input type="checkbox" onclick="addKeyFilterObj(this);" name="go-area" value="busan"><span>부산</span></label></td>
			    <td><label><input type="checkbox" onclick="addKeyFilterObj(this);" name="go-area" value="daejeon"><span>대전</span></label></td>
			    <td><label><input type="checkbox" onclick="addKeyFilterObj(this);" name="go-area" value="gyang"><span>광주</span></label></td>
			  </tr>
			  <tr>
			    <td>상태</td>
			    <td><label><input type="checkbox" onclick="addKeyFilterObj(this);" name="go-state" value="ing"><span>모집중</span></label></td>
			    <td><label><input type="checkbox" onclick="addKeyFilterObj(this);" name="go-state" value="finish"><span>모집마감</span></label></td>
			  </tr>
			</table>
			
			<!-- 선택필터 추가 -->
			<div>
			<div class="group"></div>
			<div class="filter-reset">
					<a href="#this" onclick="resetKeyFilter(); return false;"><span class="glyphicon glyphicon-refresh"></span></a>
			</div>
		</div>
	</div>
	</div>
	
	<!-- content list -->
	<!-- 하단 리스트 -->
	<div class="go-list">
		
		<div>
		<!-- 정렬 드롭다운 -->
		<div class="dropdown" >
		  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
		    	<span>정렬방식 </span><span class="caret"></span>
		  </button>
		  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
		    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">최신순</a></li>
		    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">찜순</a></li>
		    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">날짜순</a></li>
		  </ul>
		</div>	
		
		<!-- 모집버튼 --> 
		<div class="pull-right">
			<a class="btn btn-default" href="#" role="button">동행 모집하기</a>
		</div>
		</div>
		
		<!-- 정렬 혹은 필터처리된 리스트 -->
		<div id="gobest">
		
		<!-- 이부분 반복 -->
		<div class="gobest">
			<div class="gobest-title">
				<div class="goprofile ialign">
				<a href="../go/goDetail.jsp"> <!-- 사진 클릭시 이동 -->
					<img src="/resources/image/main/profileex.jpg" alt="프로필사진" class="img-circle" />
				</a>
				</div>
				<div class="ialign marginleft">
					<div class="goname">동행러버 <small>제주</small></div>
					<div class="gotitle">
						글제목 2월 같이 여행하실분 !!! 
						어쩌구저쩌구
					</div>
				</div>
			</div>
			<div class="margintop">
				<div><span>2030</span> · <span>성별 무관</span> · <span>인생샷</span></div>
				<div>5명이 찜하고 있습니다</div>
				<div>
				<span class="gotag">모집중</span>
				<span class="goheart"><img src="/resources/image/go/heart.png" alt="찜하트"/></span>
				</div>  <!-- 하트 색 변경 작동 시키기 -->
			</div>
		</div>
		
		<!-- 이부분 반복 -->
		<div class="gobest">
			<div class="gobest-title">
				<div class="goprofile ialign">
				<a href="../go/goDetail.jsp"> <!-- 사진 클릭시 이동 -->
					<img src="/resources/image/main/profileex.jpg" alt="프로필사진" class="img-circle" />
				</a>
				</div>
				<div class="ialign marginleft">
					<div class="goname">동행러버 <small>제주</small></div>
					<div class="gotitle">
						글제목 2월 같이 여행하실분 !!! 
						어쩌구저쩌구
					</div>
				</div>
			</div>
			<div class="margintop">
				<div><span>2030</span> · <span>성별 무관</span> · <span>인생샷</span></div>
				<div>5명이 찜하고 있습니다</div>
				<div>
				<span class="gotag">모집중</span>
				<span class="goheart"><img src="/resources/image/go/heart.png" alt="찜하트"/></span>
				</div>
			</div>
		</div>
		
		<!-- 이부분 반복 -->
		<div class="gobest">
			<div class="gobest-title">
				<div class="goprofile ialign">
				<a href="../go/goDetail.jsp"> <!-- 사진 클릭시 이동 -->
					<img src="/resources/image/main/profileex.jpg" alt="프로필사진" class="img-circle" />
				</a>
				</div>
				<div class="ialign marginleft">
					<div class="goname">동행러버 <small>제주</small></div>
					<div class="gotitle">
						글제목 2월 같이 여행하실분 !!! 
						어쩌구저쩌구
					</div>
				</div>
			</div>
			<div class="margintop">
				<div><span>2030</span> · <span>성별 무관</span> · <span>인생샷</span></div>
				<div>5명이 찜하고 있습니다</div>
				<div>
				<span class="gotag">모집중</span>
				<span class="goheart"><img src="/resources/image/go/heart.png" alt="찜하트"/></span>
				</div>
			</div>
		</div>
		
		<!-- 이부분 반복 -->
		<div class="gobest">
			<div class="gobest-title">
				<div class="goprofile ialign">
				<a href="../go/goDetail.jsp"> <!-- 사진 클릭시 이동 -->
					<img src="/resources/image/main/profileex.jpg" alt="프로필사진" class="img-circle" />
				</a>
				</div>
				<div class="ialign marginleft">
					<div class="goname">동행러버 <small>제주</small></div>
					<div class="gotitle">
						글제목 2월 같이 여행하실분 !!! 
						어쩌구저쩌구
					</div>
				</div>
			</div>
			<div class="margintop">
				<div><span>2030</span> · <span>성별 무관</span> · <span>인생샷</span></div>
				<div>5명이 찜하고 있습니다</div>
				<div>
				<span class="gotag">모집중</span>
				<span class="goheart"><img src="/resources/image/go/heart.png" alt="찜하트"/></span>
				</div>
			</div>
		</div>
		
		<!-- 이부분 반복 -->
		<div class="gobest">
			<div class="gobest-title">
				<div class="goprofile ialign">
				<a href="../go/goDetail.jsp"> <!-- 사진 클릭시 이동 -->
					<img src="/resources/image/main/profileex.jpg" alt="프로필사진" class="img-circle" />
				</a>
				</div>
				<div class="ialign marginleft">
					<div class="goname">동행러버 <small>제주</small></div>
					<div class="gotitle">
						글제목 2월 같이 여행하실분 !!! 
						어쩌구저쩌구
					</div>
				</div>
			</div>
			<div class="margintop">
				<div><span>2030</span> · <span>성별 무관</span> · <span>인생샷</span></div>
				<div>5명이 찜하고 있습니다</div>
				<div>
				<span class="gotag">모집중</span>
				<span class="goheart"><img src="/resources/image/go/heart.png" alt="찜하트"/></span>
				</div>
			</div>
		</div>
		
		
		<!-- 반복끝나고 마지막에 출력하는거 -->
		<div class="gofinish">
			<div class="gobest-title">
				<div class="ialign marginleft">
					<div class="gottile">
						<span class="">찾으시는 동행이 없나요?</span><br>
						<span>동행모집하기</span>
					</div>
					<div class="goarrow">
						<a class="none" href="/go/goForm.jsp"><span class="glyphicon glyphicon-arrow-right"></span></a>
					</div>
				</div>
			</div>
		</div>
		
		
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