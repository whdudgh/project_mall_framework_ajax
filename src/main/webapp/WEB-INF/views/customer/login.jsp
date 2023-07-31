<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
 <meta charset="UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title>로그인</title>
 
 <script src="https://kit.fontawesome.com/2b070e02a1.js" crossorigin="anonymous"></script>
 <script src="https://kit.fontawesome.com/4ec79785b5.js" crossorigin="anonymous"></script>
  
  <!--login css추가-->
  <link rel="stylesheet" href="/assets/css/bi.css">
    <!--<script defer src="/assets/js/login.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18/dist/sweetalert2.min.css">
  <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18/dist/sweetalert2.min.js"></script>-->
  <script>

    //로그인버튼 제약 함수

    function login_check() {
      let userId = document.querySelector("#username");
      let userPw = document.querySelector("#password");

      if (userId.value == "") {
        alert("이메일을 입력해주세요");
        userId.focus();
      } else if (userPw.value == "") {
        alert("비밀번호를 입력해주세요");
        userPw.focus();
      } //else {
        //alert("로그인 되었습니다.");
        //location.href = "mypage.html"
      //}
    }

    //가입버튼 함수

    function signup() {
      location.href = "signup.html"
    }
  </script>
  
  
</head>

<body>

<!----------------------------------------메인-------------------------------------------------->

 <div class="container">
 <div class="login-box">
 <!--  login Form Start -->

 <div class="user-icon">
 <i class="far fa-user"></i>
 </div>
 <form class="login" class="needs-validation" novalidate action="${path}/customer/login" method="post">
 <div class="form-group" >
 <input type="text" placeholder="email" id="username" name="email" class="form-control">
 </div>
 <div class="form-group">
 <input type="password" placeholder="Password" id="password" name="uPwd" class="form-control">
 </div>
 <div class="form-group">
 <div class="form-check">
<!--  <label for="rememberme">  -->
<!-- 
 <input type="checkbox" name="rememberme" id="rememberme" 
 <c:if test="${not empty cookie.rememberme}">checked</c:if>> 
 <label class="form-check-label" for="flexCheckDefault">
 아이디 저장
 </label>
 </div>
  

 <div id="findIwPw">
  <a id="findId" href="">아이디 찾기</a>
  <a id="findPw" href="">비밀번호 찾기</a>
</div>
-->

 </div>
 <div class="form-group">
 <button class="full-btn" id="login" onclick="login_check()">Login</button>
 </div>
 </form>
 <div class="form-group">
 <p>회원이 아니신가요? <a href="${path}/signup" onclick="signup()" style="cursor: pointer;">회원가입</a></p>
 </div>
 <div class="serparater">
social links로 로그인하기
 </div>
 <div class="social-login">
 <a href="facebook">
 <i class="fab fa-facebook-square"></i>
 Facebook
 </a>
 <a href="google">
 <i class="fab fa-google"></i>
 Google
 </a>
 </div>
 </div>
 </div>
 
</body>


</html>
