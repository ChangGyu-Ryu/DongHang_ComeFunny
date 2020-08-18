<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="loginheader.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- 부트스트랩 3.3.2 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style>
#finddiv {
	width: 800px;
	border: 1px solid black;
	margin: 0px auto;
}

#fIdfield {
	margin: 10px 0 20px 15%;
	background-color: #03588C;
	border-radius: 10px;
	width: 70%;
}

#fIdfield2 {
	margin: 0 35px 0 0;
	text-align: center;
}

legend {
color: white;
margin: 0;
}

ol {
	list-style: none;
	margin: auto;
	padding: 0px;
}

li {
	text-align: center;
}

.findli {
	width: 70%;
	height: 5%;
	margin: 10px auto;
}

button {
	width: 150px;
	height: 40px;
	margin: 0 5% 0 75px;
}

.form-group {
    margin-bottom: 40px;
    text-align: center;
}

#logoimg {
	width: 200px;
}
</style>

<body>
	<div id="finddiv">
	<div class="form-group">
		<img id="logoimg" alt="로고이미지" src="/resources/image/header/logo.png">
	</div>
		<form action="#">
			<fieldset id="fIdfield">
				<center>
					<legend>비밀번호 찾기</legend>
				</center>
				<ol>
					<li><input type="text" class="findli" name="name"
						placeholder="이름"></li>
					<li><input type="text" class="findli" name="id"
						placeholder="아이디"></li>
					<li><input type="email" class="findli" name="email"
						placeholder="이메일"></li>
				</ol>
			</fieldset>
		</form>
		<form>
			<fieldset id="fIdfield2">
				<!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
				<button type="button" class="btn btn-primary">찾기</button>
				<button type="button" class="btn btn-primary">돌아가기</button>
			</fieldset>
		</form>
	</div>

</body>
</html>
<%@ include file="loginfooter.jsp"%>