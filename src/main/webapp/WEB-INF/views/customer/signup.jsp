<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>회원가입</title>

  <!-- signup css추가-->
  <link rel="stylesheet" href="/assets/css/bi3.css">
  <script src="https://kit.fontawesome.com/4ec79785b5.js" crossorigin="anonymous"></script>
  <script defer src="/assets/js/signup.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

</head>

<body>
    <div class="container">
      <h1>회원가입</h1>
      <p>회원이 되어 다양한 해택을 경험해보세요!</p>
      <br>
       <form class="needs-validation" novalidate action="${path}/customer/signup" method="post">
      <label><b> 이름</b></label>
      <input id="name" type="text" name="name" placeholder="Enter Username" required>

      <label><b> 이메일</b></label>
      <br>
      <input type="text" id="fEmail" name="fEmail" placeholder="Enter Email" style="width: 35% !important;" required>
      @
      <input type="email" name="bEmail" id="bEmail" Style="width: 30%;
  		padding: 15px;
  		margin: 5px 0 22px 0;
  		display: inline-block;
  		border: none;
  		background: #f7f7f7;
		font-family: Montserrat,Arial, Helvetica, sans-serif;">
      <select name="" id="eee" onchange="em(this)">
        <option value="">직접입력</option>
        <option value="naver.com">naver.com</option>
        <option value="gmail.com">gmail.com</option>
        <option value="hanmail.net">hanmail.net</option>
      </select>
      <br>
      <label><b> 비밀번호 </b></label>
      <input type="password" id="pw" onblur="pwch1(pw)" placeholder="Enter Password ( 영문, 숫자 혼합하여 6~20자리 이내 )"
        name="psw" required>
      <!-- <span id="pwcheck1">양식에 맞게 입력해주세요.</span> -->

      <label><b>비밀번호 재확인</b></label>
      <input type="password"  id="checkpw" onblur="pwch2(checkpw)" placeholder="Enter Password ( 비밀번호 재입력 )" name="psw"
        required>
      <!-- <span id="pwcheck2">비밀번호가 다릅니다.</span> -->

      <label><b>전화번호</b></label>
      <br>

      <input type="text"  id="phone" name="phone" onblur="phonech(phone)" placeholder="Phone Number ( '-' 자 제외 11자리 입력 )"
        required>

      <b>생년월일</b>
      <div>
        <input type="text" id="birth" name="birthday" onblur="birthch(birth)" placeholder="생년월일( 예: 20020115 )">
        <!-- <span id="birthcheck">양식에 맞게 입력해주세요</span> -->
      </div>
      <p><a href="#" style="color:dodgerblue" onclick="sweetAlert()">개인약관 수집 및 이용 동의</a>
        <input id="checkBox" type="checkbox"
          style="height: 15px; vertical-align: middle; text-align: center; margin-right: 5px;" onchange="this.checked && sweetAlert()" >
      </p>
      
      <div class="clearfix">
        <button type="button" onclick="submitForm()" id="signbtn">가입하기</button>
      </div>
      </form>
      <!-- <button type="button" onclick="back()" id="backbtn"><a href="${path}/login">돌아가기</a></button>
      <!-- <a href="${path}/login" type="button" onclick="back()" id="backbtn">돌아가기</a> -->
       <button type="button" onclick="location.href='${path}/login'" id="backbtn">돌아가기</a>
    </div>

  </form>
  </div>
</body>

</html>