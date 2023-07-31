<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Document</title>
<link rel="stylesheet" href="/assets/css/order.css">
<!--공용 헤더 푸터 css추가-->
<link rel="stylesheet" href="/assets/css/common.css">
<!--버거버튼 동작 자바스크립트 추가-->
<script defer src="/assets/js/burgerBT.js"></script>
<script src="https://kit.fontawesome.com/4ec79785b5.js"
	crossorigin="anonymous"></script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<link rel="stylesheet" href="/assets/js/postCode.js">

<script defer src="/assets/js/postCode.js"></script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<script>
	function lastbtn() {
		Swal.fire({
			icon : 'success',
			title : '결제되었습니다',
			text : '2~3일내로 배송이 됩니다',
		});
	}
</script>


</head>


<body>
	<!-- 헤더 모듈 추가 -->
	<jsp:include page="/WEB-INF/views/modules/header.jsp" />

	<main>
		<div id="order_title">
			<span>주문/결제</span>
		</div>
		<div id="orderbox_wrap">
			<div id="orderlist" class="container">
				<div id="customerinfor" class="infor">
					<div id="customerfont">고객정보</div>
					<%--<c:forEach items="${custList}" var="cust">--%>
					<div>
						<span>이름 : ${loginCustomer.uName}</span>
					</div>
					<div>
						<span>이메일 : ${loginCustomer.email}</span>
					</div>
					<div>
						<span>핸드폰 번호 : ${loginCustomer.phoneNum}</span>
					</div>
					<%-- </c:forEach> --%>
				</div>
				<div id="sendcoustomerinfor" class="infor">
					<div id="sendcoustomerfont">받는사람 정보</div>
					<div>
						<label>우편번호 : <input type="text" id="postcode"
							name="addressnum"> <input type="button" value="우편번호 찾기"
							id="findPostCode">
						</label>
					</div>
					<div>
						<label>주&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;소 : <input
							type="text" id="combinedAddress" name="roadname">
						</label>
					</div>
					<div>
						<label>상세주소 : <input type="text" id="detailAddress"
							name="writeaddress">
						</label>
					</div>
					<div>
						<label>배송요청사항 : <select>
								<option value="">요청사항을 선택해주세요</option>
								<option value="select1">배송전에 연락부탁드립니다.</option>
								<option value="select2">부제시 경비실에 맡겨주세요.</option>
						</select></label>
					</div>
				</div>
				<div id="ordermethod" class="infor">
					<div id="ordermethodfont">결제 방법</div>
					<div id="ordermethodmini">
						<div class="ordercheck">
							<div>
								<label><input type="checkbox" name="ordermethodselect">
									계좌이체 </label>
							</div>
							<div>
								<label><input type="checkbox" name="ordermethodselect">
									체크/신용카드 </label>
							</div>
							<div>
								<label><input type="checkbox" name="ordermethodselect">
									무통장입금 </label>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="order">
				<div id="calbox">
					<c:forEach items="${cart.cart}" var="list">
						<div class="productrange">
							<div class="productbox">
								<div id="imgbox_1">
									<img
										src="/assets/image/clockimg/${list.product.categoryName}/${list.product.mainImg}"
										alt="" class="mainproduct">
								</div>
								<div id="productdetail_1">
									<div id="productdetail_1" style="margin-top: 10%;">${list.product.pKey}</div>
									<div>
										<span id="cal_price">${list.product.price}</span><span>
											원</span>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				<div id="calbox_inner">
					<div id="cal_total">
						<span>총금액</span>
						<p>
							<span id="cal_total_inner">${cart.totalPay}</span><span>원</span>
						</p>
					</div>
				</div>
							<div>
				<button type="button" id="order_btn" onclick="lastbtn()">결제하기</button>
			</div>
				</div>

			</div>



		</div>


	</main>
	<footer>
		<div id="info">
			<div id="info1">
				<h2>고객행복센터</h2>
				<div id="call">
					<span id="callnumber"><strong>1644-1107</strong></span><span>월~토요일
						오전7시 - 오후 6시</span>
				</div>
			</div>
			<div id="info2">
				<p>법인명(상호):주식회사 이젠 | 사업자 등록번호:61-254-25225 사업자 정보확인</p>
				<P>시계쇼핑몰:제2018-서울강남-55566호 | 개인정보보호책임자:이원준</P>
				<P>주소:서울특별시 강남구 테헤란로 133,18층(역삼동) | 대표이사:양양양</P>
				<p>채용문의:bangry@ezen.com</p>
				<p>팩스: 070-555-5545</p>
				<!-- <div id="icons">
          <i class="fa-brands fa-instagram"></i>
          <i class="fa-brands fa-facebook"></i>
          <i class="fa-brands fa-youtube"></i>
        </div> -->
			</div>
		</div>
	</footer>
</body>

</html>