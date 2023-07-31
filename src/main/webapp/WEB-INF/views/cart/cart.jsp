<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css">
    <!--공용 헤더 푸터 css추가-->
    <link rel="stylesheet" href="/assets/css/common.css">
    <!--버거버튼 동작 자바스크립트 추가-->
    <!--카트 전용 css-->
    <link rel="stylesheet" href="/assets/css/cart.css">
   
  </head>
  <body>
    <!-- =========================헤더 부분 시작===================== -->
    <!-- 헤더 모듈 추가 -->
  	<jsp:include page="/WEB-INF/views/modules/header.jsp"/>	
    <!-- =========================헤더 부분 끝===================== -->

    <!-- =========================장바구니 부분 시작===================== -->
    <main>
      <div  id="cart_title"><span>장바구니</span></div>
      <div id="listbox_wrap">
        <div id="listbox">
          <div id="check-remove">
            <input class="check" id="checkAll" type="checkbox" onclick="checkAll()" ><label for="checkAll"><i class="fa-solid fa-check"></i></label>
            <label for="checkAll"><span> 전체선택</span></label>
            <button id="remove" onclick="remove()">선택삭제</button>
          </div >
          <ul id="list">
            
            <c:forEach items="${cart.cart}" var="cartItem">
            <li>
              <input class="check" type="checkbox" id="check1"><label for="check1"><i class="fa-solid fa-check"></i></label>
              <img src="/assets/image/clockimg/${cartItem.product.categoryName}/${cartItem.product.mainImg}" alt="">
              <p>${cartItem.product.pName}</p>
              <div class="price">${cartItem.product.price}</div>
              <div class="qty">
                <button onclick="minusbutton(this)" value="${cartItem.product.pKey}">-</button>
                <div>${cartItem.productCnt}</div>
                <button onclick="plusbutton(this)" value="${cartItem.product.pKey}">+</button>
              </div>
              <div class="amt">
                ${cartItem.product.price}
              </div>
            </li>
            </c:forEach>

          </ul>
          <div id="check-remove">
            <span>EWC에서 주문하신 모든 제품은 EWC 시그니처 패키징 방법으로 포장되어 배송됩니다</span>
            <button id="gift" ><i class="fas fa-gift"></i> 기프트 메시지 추가</button>
          </div >
        </div>
        <div class="order">
          <div id="calbox">
            <div id="calbox_inner">
              <!-- <div><span>상품금액</span><p><span  id="cal_price">29100</span><span> 원</span></p></div> -->
              <div id="cal_total"><span>결제예정금액</span><p><span id="cal_total_inner" onload="cal()">${cart.totalPay}</span><span>원</span></p></div>
            </div>

          </div>
          <div>
            <!-- <button id="order_btn"><a href="${path}/order">주문하기</a></button> -->
            <a class="btn btn-dark" id="order_btn">주문하기</a>
          </div>

          <!-- <div id="item_base">
           <div>
          <span id="item_base_a">주문하신 모든 제품은 무료로 배송됩니다</span>
          <button id="item_base_b">자세히 보기</button>
        </div>
        <div>
          <span id="item_base_a">반품 및 교환</span>
          <button id="item_base_b">자세히 보기</button>
        </div>
        </div> -->

        </div>
      </div >
	<div class="overlay"></div>
    </main>
    <!-- =========================장바구니 부분 끝===================== -->

    <!-- =========================하단 부분 시작===================== -->
    <!-- 푸터 모듈 추가 -->
    <jsp:include page="/WEB-INF/views/modules/footer.jsp"/>
    <!-- =========================하단 부분 끝===================== -->
    
    <script  src="/assets/js/burgerBT.js"></script>
    <script  src="/assets/js/cart.js"></script>
    <script src="https://kit.fontawesome.com/4ec79785b5.js" crossorigin="anonymous"></script>

  </body>
</html>
