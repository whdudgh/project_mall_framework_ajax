<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>시계쇼핑몰</title>
  <script src="https://kit.fontawesome.com/4ec79785b5.js" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="/assets/css/main.css">
  <link rel="stylesheet" href="/assets/css/common.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css">
  <script defer src="/assets/js/burgerBT.js"></script>


</head>

<body>
  <!-------------------------- header 시작---------------------------->
  <jsp:include page="/WEB-INF/views/modules/header.jsp"/>
  <!----------------------------- header 끝------------------------------>

  <!------------------------------ main 시작------------------------------>
  <main>
    <section>
      <div class="mainPage">
        <div class="main_img">
          <img src="/assets/image/main.png" id="main_img">
          <div class="text-inside-image">
            <p>ICONIC<br>IWC<br>CHRONOGRAPHS</p>
          </div>
        </div>
    </section>
    <section>
      <div class="main2">
        <div class="mainContent">
          <h2>OUR<br>LATEST</h2><br>
          <div class="mainText">
            <pre>A Grande Sonnerie Supersonnerie, Minute Repeater,
            Perpetual Calendar, Split-Seconds Flyback </pre>
            <br>
            <pre>Chronograph and Flying Tourbillon come together i
            n this ultra-complicated wristwatch. </pre>
          </div>
        </div>
        <div class="slider">
          <input type="radio" name="slide" id="slide1" checked>
          <input type="radio" name="slide" id="slide2">
          <input type="radio" name="slide" id="slide3">
          <input type="radio" name="slide" id="slide4">
          <ul id="imgholder" class="imgs">
            <li><img src="/assets/image/slide/slide2.png" style="width:700px;" height="550px;">
              <p>크로노그래프</p>
            </li>
            <li><img src="/assets/image/slide/slide3.png" style="width:700px;" height="550px;">
              <p>크로노그래프-갈라파고스 아일랜드</p>
            </li>
            <li><img src="/assets/image/slide/slide5.png" style="width:700px;" height="550px;">
              <p>포르토피노-퍼페추얼</p>
            </li>
            <li><img src="/assets/image/slide/slide6.png" style="width:700px;" height="550px;">
              <p>오토메틱-데이앤나이트34</p>
            </li>
          </ul>
          <div class="bullets">
            <label for="slide1">&nbsp;</label>
            <label for="slide2">&nbsp;</label>
            <label for="slide3">&nbsp;</label>
            <label for="slide4">&nbsp;</label>
          </div>
        </div>
      </div>
    </section>
    <section>
      <div class="main3">
        <div class="main_img2">
          <img src="/assets/image/main-2.png" style="width:700px;" height="550px;">
        </div>
        <div class="mainContent2">
          <h2>AP COVERAGE<br>SERVICE</h2><br>
          <div class="mainText2">
            <pre>A Grande Sonnerie Supersonnerie, Minute Repeater,
      Perpetual Calendar, Split-Seconds Flyback </pre>
            <br>
            <pre>Chronograph and Flying Tourbillon come together i
      n this ultra-complicated wristwatch. </pre>
          </div>
        </div>
      </div>
    </section>
    <section>
      <div class="main4">
        <div class="mainContent3">
          <h2>NEW<br>ROYAL<br>OFFSHORE</h2><br>
          <div class="mainText3">
            <pre>A Grande Sonnerie Supersonnerie, Minute Repeater,
            Perpetual Calendar, Split-Seconds Flyback </pre>
            <br>
            <pre>Chronograph and Flying Tourbillon come together i
            n this ultra-complicated wristwatch. </pre>
          </div>
        </div>
        <div class="main_img3">
          <img src="/assets/image/main-3.png" style="width: 500px;" height="300px">
          <div class="main_img4">
            <img src="/assets/image/main3-2.png" style="width: 500px;" height="300px">
          </div>
        </div>
      </div>
    </section>
        <video muted autoplay loop>
          <source src="/assets/video/video2.mp4" type="video/mp4">
        </video>
      <
    </div>
    <div class="overlay"></div>
  </main>
  <div class="main5">
    <div class="mainContent4">
      <h2> FIND A<br>BOUTIQUE</h2>
    </div>
    <div class="img-5">
      <img src="/assets/image/main5.jpeg">
    </div>
  </div>
  <!------------------------------- main 끝---------------------------->

  <!---------------------------- footer시작 --------------------------->
  <jsp:include page="/WEB-INF/views/modules/footer.jsp"/>
</body>

</html>