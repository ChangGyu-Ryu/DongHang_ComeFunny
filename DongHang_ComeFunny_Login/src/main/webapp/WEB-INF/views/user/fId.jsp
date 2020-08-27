<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
</head>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/fId.css" />

<!-- fontawesome 아이콘 -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">

<!-- semantic ui -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css" integrity="sha512-8bHTC73gkZ7rZ7vpqUQThUDhqcNFyYi2xgDgPDHc+GXVGHXq+xPjynxIopALmOPqzo9JZj0k6OqqewdGO3EsrQ==" crossorigin="anonymous" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.js" integrity="sha512-dqw6X88iGgZlTsONxZK9ePmJEFrmHwpuMrsUChjAw1mRUhUITE5QU9pkcSox+ynfLhL15Sv2al5A0LVyDCmtUw==" crossorigin="anonymous"></script>

  <!-- Standard Meta -->
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

<div class="ui middle aligned center aligned grid " id="fId__background__image">
  <div id="fId__background"></div>
  <div class="column" id="fId__column">
    <h2 class="ui teal image header">
      <img src="<%=request.getContextPath() %>/resources/image/header/logo.png" class="image" id="fId__logo__image">
    </h2>
    <form class="ui large form">
    
      <div class="ui stacked segment">
      
        <div class="field">
            <input type="text" name="uName" placeholder="User Name">
        </div>
        
        <div class="field">
            <input type="text" name="email" placeholder="E-mail address">
        </div>
		</div>
      <div class="ui error message"></div>

    </form>

    <div>
    	<button id=subBtn class="ui teal button">아이디 찾기</button>
    	<button id=cancelBtn class="ui teal button">돌아가기</button>
    </div>
  </div>
</div>
</html>
