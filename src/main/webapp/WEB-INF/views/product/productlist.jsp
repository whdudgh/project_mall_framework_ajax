<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Document</title>
<script src="https://kit.fontawesome.com/4ec79785b5.js"
	crossorigin="anonymous"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<!--공용 헤더 푸터 css추가-->
<link rel="stylesheet" href="/assets/css/common.css">
<!--특정페이지 전용 css추가-->
<link rel="stylesheet" href="/assets/css/productlist.css">
<!--버거버튼 동작 자바스크립트 추가-->
<script defer src="/assets/js/burgerBT.js"></script>
</head>
<body>

	<!-- 헤더 모듈 추가-->
	<jsp:include page="/WEB-INF/views/modules/header.jsp" />

	<main>
		<div class="new_title">
			<h2>${categoryName}</h2>
		</div>
		<div id="product_wrap">
			<c:forEach items="${productList}" var="product">
				<div class="product">
					<!-- <div class="new">NEW!</div> -->
					<a href="${path}/product?pName=${product.pName}"> <img
						src="/assets/image/clockimg/${categoryName}/${product.mainImg}"
						alt="">
					</a>
					<div class="product_info">
						<p class="product_name">${product.pName}</p>
						<p class="product_price">${product.price}원</p>
					</div>
				</div>
			</c:forEach>
			</div>
			<div id="product_page">
				<!-- 페이징 처리 -->
				<nav class="mt-3">
					<ul class="pagination justify-content-center">
						<%-- 처음으로 보여주기 여부 --%>
						<c:if test="${pagination.showFirst}">
							<li class="page-item"><a class="page-link" href="?page=1&category=${categoryName}"
								aria-label="First"> <span aria-hidden="true">처음으로</span>
							</a></li>
						</c:if>

						<%-- 이전 목록 보여주기 여부 --%>
						<c:if test="${pagination.showPrevious}">
							<li class="page-item"><a class="page-link"
								href="?page=${pagination.previousStartPage}&category=${categoryName}"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>
						</c:if>

						<c:forEach var="i" begin="${pagination.startPage }"
							end="${pagination.endPage }">
							<c:choose>
								<c:when test="${i == pagination.params.requestPage}">
									<li class="page-item active"><a class="page-link">${i}</a></li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a class="page-link"
										href="?page=${i}&category=${categoryName}">${i}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>

						<%-- 다음 목록 보여주기 여부 --%>
						<c:if test="${pagination.showNext}">
							<li class="page-item"><a class="page-link"
								href="?page=${pagination.nextStartPage}&category=${categoryName}" aria-label="Next">
									<span aria-hidden="true">&raquo;</span>
							</a></li>
						</c:if>

						<%-- 마지막으로 보여주기 여부 --%>
						<c:if test="${pagination.showLast}">
							<li class="page-item"><a class="page-link"
								href="?page=${pagination.totalPages}&category=${categoryName}" aria-label="First"> <span
									aria-hidden="true">마지막으로</span>
							</a></li>
						</c:if>
					</ul>
				</nav>
			
		</div>
		<div class="overlay"></div>
	</main>
	<!-- 푸터 모듈 추가 -->
	<jsp:include page="/WEB-INF/views/modules/footer.jsp" />

</body>
</html>
