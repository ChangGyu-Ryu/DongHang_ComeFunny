<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<style>

.joindiv {
	display: inline-block;
	background-color : skyblue;
	width: 1200px;
	padding: 40px;
}

fieldset {
	background-color: gold;
    border: 1px solid black;
    margin: 0 350px;
}

.form-group {
/* 	display: inline-block; */
	text-align: center;
	margin-right: 20px;
	margin-top: 10px;
}

label {
	float: left;
	margin: 0 0 0 20px
}
.text-center {
	margin-top: 20px;
	margin-bottom: 30px;
	text-align: center;
}

.btn {
	float: right;
}

#logoimg {
	width: 150px;
	text-align: center;
}

</style>

<div class="joindiv">
<form action="/login/signup" method="post" class="form">
<fieldset>

	<div class="form-group">
		<img id="logoimg" alt="로고이미지" src="/resources/image/header/logo.png">
	</div>
	
	<div class="form-group">
		<label for="userid" class="control-label">아이디</label>
		<input type="email" id="userId" name="userId" class="form-control" style="margin-left: 25px"/>
		<button class="btn">중복확인</button>
	</div>
	
	<div class="form-group">
		<label for="userpw" class="control-label">비밀번호</label>
		<input type="text" id="userPw" name="userPw" class="form-control" style="margin-right: 60px"/>
	</div>
	
	<div class="form-group">
		<label for="userpw" class="control-label">비밀번호 확인</label>
		<input type="text" id="userPwChk" class="form-control" style="margin-right: 55px"/>
		<button class="btn">확인</button>
	</div>
	
	<div class="form-group">
		<label for="usernick" class="control-label">이름</label>
		<input type="text" id="userName" name="userName" class="form-control" style="margin-right: 29px"/>
	</div>
	
	<div class="form-group">
		<label for="userphone class="control-label">연락처</label>
		<input type="text" id="userPhone" name="userPhone" class="form-control" placeholder="-를 제외하고 입력해주세요" style="margin-right: 45px"/>
	</div>
	
	<div class="form-group">
		<label for="usernick" class="control-label">닉네임</label>
		<input type="text" id="userNick" name="userNick" class="form-control" style="margin-right: 45px"/>
	</div>
	
	<div class="form-group">
		<label for="userbirth" class="control-label">생년월일</label>
		<input type="text" id="userBirth" name="userBirth_yy" class="form-control" maxlength="4" placeholder="년(4자)" size="4" style="margin-left: -62px">
		<select name="userBirth_mm">
                            <option value="">월</option>
                            <option value="01" >1</option>
                            <option value="02" >2</option>
                            <option value="03" >3</option>
                            <option value="04" >4</option>
                            <option value="05" >5</option>
                            <option value="06" >6</option>
                            <option value="07" >7</option>
                            <option value="08" >8</option>
                            <option value="09" >9</option>
                            <option value="10" >10</option>
                            <option value="11" >11</option>
                            <option value="12" >12</option>
         </select>
         <input type="text" name="userBirth_dd" maxlength="2" placeholder="일" size="3" >
	</div><br>
	
	<div class="form-group">
		<label for="usergender" class="control-label">성별</label>
		<input type="radio" name="gender" value="남" checked>남
        <input type="radio" name="gender" value="여" checked>여
	</div><br>
	
	<div class="form-group">
		<label for="useremail" class="control-label">이메일</label>
		<input type="text" id="userEmail" name="userEmail" class="form-control" placeholder="이메일을 입력해 주세요." style="margin-right: 40px"/>
	</div>
	
	<a href="/login">
	<div class="text-center">
		<button type="submit" id="btnSignUp"">
			회원가입
		</button>
	</a>
		
	</div>
	</fieldset>
</form>
</div>

</body>
</html>
<%@ include file="../layout/footer.jsp"%>