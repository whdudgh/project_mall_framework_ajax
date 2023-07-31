<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 원래 있던 기본 헤더에 햄버거 버튼 추가한 헤더 시작 -->
  <header>
    <div>
      <div class="hamburger-btn active">
        <div class="bar"></div>
        <div class="bar"></div>
        <div class="bar"></div>
      </div>
    </div>
        <!-- 
    <c:choose>
    <c:when test="${empty loginCustomer}">
    <div class="title">
      <a href="index.html" class="title-link" style="text-decoration: none; color: black;">
        <h1>EWC</h1>
        <h4>SCHAFFHAUSEN</h4>
      </a>
    </div>
    </c:when>
    <c:otherwise>
    <div class="title" style="background-position: 40% 50%;">
    </c:otherwise>
    </c:choose>
     -->
     
    <div class="title" style="display: flex !important;">
       <a href="${path}/index" class="title-link" style="text-decoration: none; color: black;">
        <h1>EWC</h1>
        <h4>SCHAFFHAUSEN</h4> 
      </a>
    </div>
    <div class="user">
 
    <c:choose>
   <c:when test="${empty loginCustomer}">
      <a href="${path}/login"><i class="fa-solid fa-user"></i></a>
      </c:when>
      <c:otherwise>
      <span class="badge rounded-pill text me-3 py-2 px-3" style="background-color: #3D7A70; font-size: medium;">${loginCustomer.uName}님</span>
      <a href="${path}/logout" class="btn btn-primary px-3 btm-sm rounded-pill py-1 " data-bs-auto-close="outside" style="background-color: rgb(18, 50, 44);"> 로그아웃</a>
      <a href="${path}/cart"><i class="fa-solid fa-cart-shopping"></i></a>
      </c:otherwise>
      </c:choose>

      
    </div>
  </header>
  <!-- 버거버튼 포함된 헤더 끝 상단 head태그에 burgerBT.js추가하여 동작 가능해짐.-->

  <!-- 평소엔 숨겨져있다가 버거버튼을 누르면 나오는 사이드바 메뉴 임시 -->
  <div class="sidebar">
    <div class="sidebar-header" style="line-height: normal;">
      <span class="close-btn" style="margin-right: 2%">&times;</span>
    </div>
    <div class="sidebar-content">
      <div class="categories" style="flex: 2;">
        <h2>Category</h2>
          <ul>
           <li class="category">
             <form action="${path}/productList" method="post">
                 <input type="hidden" name="category" value="AQ" />
                 <button type="submit">아쿠아타이머</button>
               </form>
           </li>
           <li class="category">
             <form action="${path}/productList" method="post">
                 <input type="hidden" name="category" value="DA" />
                 <button type="submit">다빈치</button>
               </form>
           </li>
           <li class="category">
             <form action="${path}/productList" method="post">
               <input type="hidden" name="category" value="IN" />
               <button type="submit">인제니어</button>
             </form>
          </li>
          <li class="category">
            <form action="${path}/productList" method="post">
              <input type="hidden" name="category" value="TO" />
              <button type="submit">포르토피노</button>
            </form>
          </li>
          <li class="category">
            <form action="${path}/productList" method="post">
              <input type="hidden" name="category" value="TU" />
              <button type="submit">포르투기저</button>
            </form>
          </li>
      </ul>
      </div>
      <div class="divider-vertical"></div>

      <div class="product-container" style="flex: 8;">
        <div class="products">
          <img src="/assets/image/product6.jpg">
          <img src="/assets/image/product2.png">
        </div>
      </div>
    </div>
  </div>