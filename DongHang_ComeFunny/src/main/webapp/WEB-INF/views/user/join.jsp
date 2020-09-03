<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/login/join.css" />
<script src="/resources/bower_components/jquery/dist/jquery.min.js"></script>  

<!-- fontawesome 아이콘 -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">

<!-- semantic ui -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
<script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>


  <!-- Standard Meta -->
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

  <!-- Site Properties -->
  <title>DHComeFunny :: 회원가입</title>

  <style type="text/css">
    body {
      background-color: #DADADA;
    }
    body > .grid {
      height: 100%;
    }
    .image {
      margin-top: -100px;
    }
    .column {
      max-width: 800px;
    }
    .join__logo {
      text-align: center;
    }
    .form__label {
      width : 100px;
    }
  </style>

</head>
<body>

<div class="ui middle aligned grid " id="join__background__image">
	<div id="join__background"></div>
		<div class="column" id="join__column">
			<div class="join__logo">
				<h2 class="ui teal image header">
					<img src="<%=request.getContextPath() %>/resources/image/header/logo.png" class="image" id="join__logo__image">
				</h2>
			</div>
		    <div class="ui container"> 
		        <h2>Sign In</h2> 
		        <form class="ui form"
		        	action="<%=request.getContextPath()%>/user/joinimple"
		        	method="post">  
			            <div class="inline fields"> 
			            	<div class="three wide field"></div>
			            	<div class="nine wide field">
			                	<label id="join__label">아이디</label> 
			                	<input type="text" name="userId"
			                        placeholder="아이디를 입력해주세요.">
			                </div>
			                <div class="five wide field"> 
					            <button class="ui button" type="submit"> 
					                중복확인
					            </button>  
			            	</div> 
			            </div> 
			            <div class="inline fields"> 
			            	<div class="three wide field"></div>
			            	<div class="nine wide field">
			                	<label id="join__label">비밀번호</label> 
			                	<input type="password" name="uPw"
			                        placeholder="비밀번호를 입력해 주세요.">
			                </div>
			                <div class="five wide field"> 
					              
			            	</div> 
			            </div> 
			            <!-- 비밀번호확인 메소드 구현시 활성화
			            <div class="inline fields"> 
			            	<div class="three wide field"></div>
			            	<div class="nine wide field">
			                	<label id="join__label">비밀번호 확인</label> 
			                	<input type="text" name="upwconfirm"
			                        placeholder="다시 한번 입력해주세요.">
			                </div>
			                <div class="five wide field"> 
					            <button class="ui button" type="submit"> 
					                확인 
					            </button>  
			            	</div> 
			            </div> 
			             -->
			            <div class="inline fields"> 
			            	<div class="three wide field"></div>
			            	<div class="nine wide field">
			                	<label id="join__label">이름</label> 
			                	<input type="text" name="uName"
			                        placeholder="이름을 입력해 주세요.">
			                </div>
			                <div class="five wide field"> 
			            	</div> 
			            </div> 
			            <div class="inline fields"> 
			            	<div class="three wide field"></div>
			            	<div class="nine wide field">
			                	<label id="join__label">연락처</label> 
			                	<input type="text" name="uPhone"
			                        placeholder="-를 제외하고 입력해주세요.">
			                </div>
			                <div class="five wide field"> 
			            	</div> 
			            </div> 
			            <div class="inline fields"> 
			            	<div class="three wide field"></div>
			            	<div class="nine wide field">
			                	<label id="join__label">닉네임</label> 
			                	<input type="text" name="uNick"
			                        placeholder="닉네임을 입력해 주세요.">
			                </div>
			                <div class="five wide field"> 
			            	</div> 
			            </div> 
			            <div class="inline fields"> 
		            		<div class="three wide field">
		                	</div>
		                	<div class="nine wide field">
	                			<label id="join__label__birth">생년월일</label>
	                			<input id = "yy" type="text" name="ubirthyy" placeholder="년(4자)" maxlength="4">	
	                			<select id = "mm" class="ui fluid dropdown" name="ubirthmm">
			                		<option value="">월</option>
			                		<option value="01">1</option>
			                		<option value="02">2</option>
			                		<option value="03">3</option>
			                		<option value="04">4</option>
			                		<option value="05">5</option>
			                		<option value="06">6</option>
			                		<option value="07">7</option>
			                		<option value="08">8</option>
			                		<option value="09">9</option>
			                		<option value="10">10</option>
			                		<option value="11">11</option>
			                		<option value="12">12</option>
			                	</select>
	                			<input id = "dd" type="text" name="ubirthdd" placeholder="일" maxlength="2">
	                				
	                		</div>
	                		<div class="five wide field"> 
		            		</div> 
			            </div>
			            <div class="inline fields"> 
			            	<div class="three wide field"></div>
			            	<div class="nine wide field">
			                	<label id="join__label__gender">성별</label>
			                	<div class="five wide field"> 
			                		<div class="ui radio checkbox">
			                			<input type="radio" name="uGender" value="1" class="hidden">
			                        </div>
			                        <label>남</label>
			                    </div>
			                	<div class="five wide field"> 
			                		<div class="ui radio checkbox">
			                			<input type="radio" name="uGender" value="2" class="hidden">
			                        </div>
			                        <label>여</label>
			                    </div>
			                </div>
			                <div class="five wide field"> 
			            	</div> 
			            </div> 
			            <div class="inline fields"> 
			            	<div class="three wide field"></div>
			            	<div class="nine wide field">
			                	<label id="join__label">이메일</label> 
			                	<input type="email" name="uMail"
			                        placeholder="donghang@donghang.com">
			                </div>
			                <div class="five wide field"> 
			            	</div> 
			            </div> 
			            <div class="inline fields"> 
			            	<div class="three wide field"></div>
			            	<div class="nine wide field">
			                	<label id="join__label">주소</label> 
			                	<input type="text" name="uAddress"
			                        placeholder="donghang@donghang.com">
			                </div>
			                <div class="five wide field"> 
			            	</div> 
			            </div> 
			            <div class="inline fields"> 
			            	<div class="five wide field"></div>
			            	<div class="seven wide field">
			                	<button id="join__signin" class="ui button" type="submit"> 
					                회원가입 
					            </button> 
			                </div>
			                <div class="five wide field"> 
			            	</div> 
			            </div>
		        </form> 
		    </div> 
		    	
		</div>
	
</div>
  <script>
   $('*.checkbox').checkbox();
   $('*.dropdown').dropdown();
  </script>
</body>

</html>
