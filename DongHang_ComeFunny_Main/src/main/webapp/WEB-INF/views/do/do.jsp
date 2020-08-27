<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>함께해요</title>

<!-- do.css -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/do/do.css" />

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
	 	$('.dropdown-menu').toggle(200, function(){
	 		$('.dropdown-menu a').click(function(){
	 			$('.dropdown-menu').hide()
	 			return false; //현재 페이지 고정
	 		});
	 	});
	});	 
	
});
</script>


</head>
<body>
<div class="do-container">
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
	  		<div class="dropbtn">커뮤니티</div>
	 	 	<div class="dropdown-content">
	    		<a href="/board/freelist">자유게시판</a>
	    		<a href="/board/reviewlist">후기게시판</a>
	 	 	</div>
		</div>
		<div class="dropdown">
	  		<div class="dropbtn">고객센터</div>
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
	<div id="do-content">
		<div class="do-title">
			<h1>함께해요!</h1>
			<h1>특별한 활동을 같이 해요</h1>
			<h4>
			새로운 사람들과 특별한 것을 해보고 싶지 않으신가요? <br>
			현재 모집중인 취향 맞춤 활동을 찾아보세요!
			</h4>
		</div>	
	</div>
	
	<!-- 상단검색필터 -->
	<div id="do-search">
		<!-- 검색타이틀 -->
		<div>
			<p class="ialign">어떤 활동을 찾으시나요?</p>
			<form action="#" method="post" id="formid" class="ialign pull-right formbox input-group-btn">
				<input type="text" name="search" class="textbox"/>
				<button type="submit" id="gobtn" class="btn btn-default input-lg"><span class="glyphicon glyphicon-search"></span></button>
			</form>
		</div>
	
		<!--검색 필터 그룹-->
		<div id="do-filter">
			<table class="searchtb">
			  <tr>
			    <td>연령대</td>
			    <td><label><input type="checkbox" onclick="addKeyFilterObj(this);" name="do-age" value="20"><span>20대</span></label></td>
			    <td><label><input type="checkbox" onclick="addKeyFilterObj(this);" name="do-age" value="30"><span>30대</span></label></td>
			    <td><label><input type="checkbox" onclick="addKeyFilterObj(this);" name="do-age" value="40"><span>40대</span></label></td>
			  </tr>
			  <tr>
			    <td>성별</td>
			    <td><label><input type="checkbox" onclick="addKeyFilterObj(this);" name="do-gender" value="m"><span>남성</span></label></td>
			    <td><label><input type="checkbox" onclick="addKeyFilterObj(this);" name="do-gender" value="f"><span>여성</span></label></td>
			  </tr>
			  <tr>
			    <td>여행타입</td>
			    <td><label><input type="checkbox" onclick="addKeyFilterObj(this);" name="do-type" value="food"><span>맛집</span></label></td>
			    <td><label><input type="checkbox" onclick="addKeyFilterObj(this);" name="do-type" value="activity"><span>액티비티</span></label></td>
			    <td><label><input type="checkbox" onclick="addKeyFilterObj(this);" name="do-type" value="meseum"><span>전시/박물관</span></label></td>
			  </tr>
			  <tr>
			    <td>지역</td>
			    <td><label><input type="checkbox" onclick="addKeyFilterObj(this);" name="do-area" value="seoul"><span>서울</span></label></td>
			    <td><label><input type="checkbox" onclick="addKeyFilterObj(this);" name="do-area" value="jeju"><span>제주</span></label></td>
			    <td><label><input type="checkbox" onclick="addKeyFilterObj(this);" name="do-area" value="incheon"><span>인천</span></label></td>
			    <td><label><input type="checkbox" onclick="addKeyFilterObj(this);" name="do-area" value="daegu"><span>대구</span></label></td>
			    <td><label><input type="checkbox" onclick="addKeyFilterObj(this);" name="do-area" value="busan"><span>부산</span></label></td>
			    <td><label><input type="checkbox" onclick="addKeyFilterObj(this);" name="do-area" value="daejeon"><span>대전</span></label></td>
			    <td><label><input type="checkbox" onclick="addKeyFilterObj(this);" name="do-area" value="gyang"><span>광주</span></label></td>
			  </tr>
			  <tr>
			    <td>상태</td>
			    <td><label><input type="checkbox" onclick="addKeyFilterObj(this);" name="do-ing" value="ing"><span>모집중</span></label></td>
			    <td><label><input type="checkbox" onclick="addKeyFilterObj(this);" name="do-ing" value="finish"><span>모집마감</span></label></td>
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
	<div class="do-list">
		<!-- 정렬 드롭다운 --> <!-- 제대로 작동 안하니 다시 확인하자 -->
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
		<div class="float-right">
			<a class="btn btn-default" href="/do/doform" role="button">인원 모집하기</a>
		</div> 
		
		
		<!-- 정렬 혹은 필터된 리스트 -->
		<div id="dobest">
		
		<!-- 이부분 반복 -->
		<div class="dobest">
			<div class="doprofile">
			<a href="../do/doDetail.jsp">
				<img src="/resources/image/do/sunset-3664096_1280.jpg" alt="대표사진" />
			</a>
			</div>
			
			<div class="dobest-title">
				<div class="ialign">
					<div class="doname">
						제주 <small>맛집</small>
					</div>
					<div class="dotitle">글제dfsdfsdf목 먹자sdsd골목투어하dsdsgsdgsdgdsgsdg실분</div>
					<div class="margintop">
						<div><span>2030</span> · <span>성별 무관</span> · <span>회비 </span><span>15000원</span> </div>
						<div></div>
						<div>5명이 찜하고 있습니다</div>
						<div class="dobox">
						<span class="gotag">모집중</span>
						<span class="goheart"><img src="/resources/image/do/heart.png" alt="찜하트"/></span>
						</div>
					</div>  
				</div>
			</div>
		</div>
		
		<!-- 이부분 반복 -->
		<div class="dobest">
			<div class="doprofile">
			<a href="../do/doDetail.jsp">
				<img src="/resources/image/do/sunset-3664096_1280.jpg" alt="대표사진" />
			</a>
			</div>
			
			<div class="dobest-title">
				<div class="ialign">
					<div class="doname">
						제주 <small>맛집</small>
					</div>
					<div class="dotitle">글제dfsdfsdf목 먹자sdsd골목투어하dsdsgsdgsdgdsgsdg실분</div>
					<div class="margintop">
						<div><span>2030</span> · <span>성별 무관</span> · <span>회비 </span><span>15000원</span> </div>
						<div></div>
						<div>5명이 찜하고 있습니다</div>
						<div class="dobox">
						<span class="gotag">모집중</span>
						<span class="goheart"><img src="/resources/image/do/heart.png" alt="찜하트"/></span>
						</div>
					</div>  
				</div>
			</div>
		</div>
		
		<!-- 이부분 반복 -->
		<div class="dobest">
			<div class="doprofile">
			<a href="../do/doDetail.jsp">
				<img src="/resources/image/do/sunset-3664096_1280.jpg" alt="대표사진" />
			</a>
			</div>
			
			<div class="dobest-title">
				<div class="ialign">
					<div class="doname">
						제주 <small>맛집</small>
					</div>
					<div class="dotitle">글제dfsdfsdf목 먹자sdsd골목투어하dsdsgsdgsdgdsgsdg실분</div>
					<div class="margintop">
						<div><span>2030</span> · <span>성별 무관</span> · <span>회비 </span><span>15000원</span> </div>
						<div></div>
						<div>5명이 찜하고 있습니다</div>
						<div class="dobox">
						<span class="gotag">모집중</span>
						<span class="goheart"><img src="/resources/image/do/heart.png" alt="찜하트"/></span>
						</div>
					</div>  
				</div>
			</div>
		</div>
		
		<!-- 이부분 반복 -->
		<div class="dobest">
			<div class="doprofile">
			<a href="../do/doDetail.jsp">
				<img src="/resources/image/do/sunset-3664096_1280.jpg" alt="대표사진" />
			</a>
			</div>
			
			<div class="dobest-title">
				<div class="ialign">
					<div class="doname">
						제주 <small>맛집</small>
					</div>
					<div class="dotitle">글제투어 하실분 ㅎ</div>
					<div class="margintop">
						<div><span>2030</span> · <span>성별 무관</span> · <span>회비 </span><span>15000원</span> </div>
						<div></div>
						<div>5명이 찜하고 있습니다</div>
						<div class="dobox">
						<span class="gotag">모집중</span>
						<span class="goheart"><img src="/resources/image/do/heart.png" alt="찜하트"/></span>
						</div>
					</div>  
				</div>
			</div>
		</div>
		
		<!-- 반복끝나고 마지막에 출력하는거 -->
		<div class="dofinish">
			<div class="dobest-title">
				<div class="ialign marginleft">
					<div class="dottile">
						<span class="">원하는 활동이 없나요?</span><br>
						<span>내가 인원모집하기</span>
					</div>
					<div class="doarrow">
						<a class="none" href="/do/doform"><span class="glyphicon glyphicon-arrow-right"></span></a>
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