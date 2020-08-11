<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/login.css" />
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<!-- 부트스트랩 -->
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<!-- fontawesome 아이콘 -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">

<!-- semantic ui -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/semantic/semantic.min.css">
<script src="<%=request.getContextPath() %>/resources/css/semantic/semantic.min.js"></script>

  <!-- Standard Meta -->
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

  <!-- Site Properties -->
  <title>Login Example - Semantic</title>
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/semantic/components/reset.css">
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/semantic/components/site.css">

  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/semantic/components/container.css">
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/semantic/components/grid.css">
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/semantic/components/header.css">
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/semantic/components/image.css">
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/semantic/components/menu.css">

  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/semantic/components/divider.css">
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/semantic/components/segment.css">
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/semantic/components/form.css">
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/semantic/components/input.css">
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/semantic/components/button.css">
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/semantic/components/list.css">
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/semantic/components/message.css">
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/semantic/components/icon.css">

  <script src="<%=request.getContextPath() %>/resources/css/semantic/components/form.js"></script>
  <script src="<%=request.getContextPath() %>/resources/css/semantic/components/transition.js"></script>

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
      max-width: 450px;
    }
  </style>
  <script>
  $(document)
    .ready(function() {
      $('.ui.form')
        .form({
          fields: {
            email: {
              identifier  : 'email',
              rules: [
                {
                  type   : 'empty',
                  prompt : 'Please enter your e-mail'
                },
                {
                  type   : 'email',
                  prompt : 'Please enter a valid e-mail'
                }
              ]
            },
            password: {
              identifier  : 'password',
              rules: [
                {
                  type   : 'empty',
                  prompt : 'Please enter your password'
                },
                {
                  type   : 'length[6]',
                  prompt : 'Your password must be at least 6 characters'
                }
              ]
            }
          }
        })
      ;
    })
  ;
  </script>
</head>
<body>

<div class="ui middle aligned center aligned grid " id="login__background__image">
  <div id="login__background"></div>
  <div class="column" id="login__column">
    <h2 class="ui teal image header">
      <img src="<%=request.getContextPath() %>/resources/image/header/logo.png" class="image" id="login__logo__image">
    </h2>
    <form class="ui large form">
      <div class="ui stacked segment">
        <div class="field">
          <div class="ui left icon input">
            <i class="user icon"></i>
            <input type="text" name="email" placeholder="E-mail address">
          </div>
        </div>
        <div class="field">
          <div class="ui left icon input">
            <i class="lock icon"></i>
            <input type="password" name="password" placeholder="Password">
          </div>
        </div>
        <div class="ui fluid large teal submit button">Login</div>
      </div>

      <div class="ui error message"></div>

    </form>

    <div class="ui message">
      New to us? <a href="#">Sign Up</a>
    </div>
  </div>
</div>

</body>

</html>
