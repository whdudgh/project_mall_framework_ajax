<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Document</title>
  <script src="https://kit.fontawesome.com/4ec79785b5.js" crossorigin="anonymous"></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
  <!--공용 헤더 푸터 css추가-->
  <link rel="stylesheet" href="/assets/css/common.css">
  <!--특정페이지 전용 css추가-->
  <link rel="stylesheet" href="/assets/css/product.css">
  <!--버거버튼 동작 자바스크립트 추가-->
  <script defer src="/assets/js/burgerBT.js"></script>
  <!--로그인 상태에 따른 장바구니 추가 버튼의 동작 스크립트 -->
  <script defer src="/assets/js/addProductToCart.js"></script>
  <!--스위트 얼럿 스크립트와 js-->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18/dist/sweetalert2.min.css">
  <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18/dist/sweetalert2.min.js"></script>
  
  <style>
  .form-control.button-active:focus {
    outline: none;
    box-shadow: none;
  }
  </style>
</head>

<body style="background-color: #000;">

  <!-- 헤더 인클루드 시작-->
    <jsp:include page="/WEB-INF/views/modules/header.jsp"/>
  <!-- 헤더 인클루드 끝 -->

  <!--================================햄버거 header 완전 끝 밑에부턴 각자페이지===========================================-->


  <main style="height: 2800px; background-color: black;">
    <!-- 상세페이지 시작 -->
    <section style="margin: 0 auto; width: 100vw; position: absolute;">
      <div class="row" style="margin: 0 auto; height: 800px; width: 90vw;">
        <div id="carousel" class="carousel slide col-7" style="max-height: 700px;">
          <div class="carousel-inner caro1">
            <div class="carousel-item active">
              <img src="/assets/image/clockimg/${selectedProduct.categoryName}/${selectedProduct.mainImg}" class="d-block w-100 img-fulid">
            </div>
            <div class="carousel-item">
              <img src="/assets/image/clockimg/${selectedProduct.categoryName}/${selectedProduct.subImg1}" class="d-block w-100 img-fulid">
            </div>
            <div class="carousel-item">
              <img src="/assets/image/clockimg/${selectedProduct.categoryName}/${selectedProduct.subImg3}" class="d-block w-100 img-fluid">
            </div>
          </div>
          <button class="carousel-control-prev" type="button" data-bs-target="#carousel" data-bs-slide="prev" style="margin-top: 100px;">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          </button>
          <button class="carousel-control-next" type="button" data-bs-target="#carousel" data-bs-slide="next" style="margin-top: 100px;">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
          </button>
        </div>
        <div class="col-4" style="height: 500px; max-height: 500px;">
          <p class="caroP" style="margin-top: 100px;" id="pkey">${selectedProduct.pKey}</p>
          <h3 class="caroH">제품명</h3>
          <p class="caroP">${selectedProduct.pName}</p>
          <h3 class="caroH">가격</h3>
          <p class="caroP" style="margin-bottom: 100px;">₩${selectedProduct.price}</p>
          <a type="button" class="btn btn-dark w-100" id="cart"
            style="background-color:rgb(18, 50, 44); height: 60px; max-height: 60px; margin-bottom: 40px; padding: 20px;">장바구니
            추가</a>
          <!--<a href="${path}/cart?pkey=${selectedProduct.pKey}" type="button" class="btn btn-dark w-100" 
            style="background-color:rgb(18, 50, 44); height: 60px; max-height: 60px; padding: 20px;">구매하기</a> -->
        </div>
      </div>
      <div class="row" style="background-color: #f9f9f9; margin: 4% 0 0 0;">
        <h1 style="color: #000; text-align: center; font-weight: bold; padding-right: 25px; padding-top: 2%;">세부사항</h1>
      </div>
      <div class="row" style="background-color: #f9f9f9; width: 100vw; margin-bottom: 300px;">
        <!-- 캐러셀 내용 -->
        <div class="col-md-12" style="position: relative;">
          <div id="caro" class="carousel slide">
            <!-- 캐러셀 버튼 위치 조정 -->
            <div class="carousel-indicators" style="position: absolute; top: -10px; left: 10px;">
              <button type="button" data-bs-target="#caro" data-bs-slide-to="0" style="background-color: #000;" class="active btn btn-primary" aria-current="true" aria-label="Slide 1"></button>
              <!-- 버튼 사이의 간격을 조정하기 위해 <span> 태그 추가 -->
              <span style="margin: 0 10px;"></span>
              <button type="button" data-bs-target="#caro" data-bs-slide-to="1" style="background-color: #000;" class="btn btn-primary" aria-label="Slide 2"></button>
              <span style="margin: 0 10px;"></span>
              <button type="button" data-bs-target="#caro" data-bs-slide-to="2" style="background-color: #000;" class="btn btn-primary" aria-label="Slide 3"></button>
            </div>
      
            <div class="carousel-inner" style="width: 100vw; max-width: 100vw;">
              <div class="carousel-item active">
                <img src="/assets/image/111.png" class="d-block w-100">
              </div>
              <div class="carousel-item">
                <img src="/assets/image/222.png" class="d-block w-100">
              </div>
              <div class="carousel-item">
                <img src="/assets/image/3333.png" class="d-block w-100">
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-5 offset-1 justify-content-center" style="height: 300px; text-align: center;"><i
            class="fa-sharp fa-solid fa-wrench" style="color: #ffffff; font-size: 150px; max-height: 300px;"></i>
          <p style="color: #fff; margin-top: 50px; font-size: 1.5em;">품질 보증 기간동안 버클1회 무상</p>
        </div>
        <div class="col-5 justify-content-center" style="height: 300px; text-align: center;"><i
            class="fa-sharp fa-solid fa-award" style="color: #ffffff; font-size: 150px; max-height: 300px;"></i>
          <p style="color: #fff; margin-top: 50px; font-size: 1.5em;">품질 보증 기간을 무료로 6년까지 연장</p>
        </div>
      </div>
      <div style="border-bottom: 1px solid #fff;"></div>
      <div style="text-align: right;">
        <button type="button" class="btn btn-dark"
          style="margin-top: 80px; margin-right: 80px; width: 120px; height: 40px; background-color:rgb(18, 50, 44);"
          data-bs-toggle="modal" data-bs-target="#exampleModal">후기보기</button>
      </div>

      <!-- Modal -->
      <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-xl">
          <div class="modal-content">
            <div class="modal-body">
              <div class="container-fluid">
                <div class="row mt-4" style="justify-content: center; margin-top: 0 !important;">
                  <div class="row mt-4" style="margin-top: 0 !important;">
                    <h2 class="mt-5">후기 & 리뷰</h2>
                    <p class="mb-3 w-lg-75">자유롭게 글을 남겨 주세요.</p>
                    <div class="width-50x pt-1" style="background-color: #000;"></div>
                  </div>
                  <div class="row mt-4" style="margin-top: 0 !important;">
                    <ul class="list-group w-100" style="margin-top: 3em;">
						<li class="list-group-item border-0 m-0 p-0">
                          <div class="text-end">
                            <button class="form-control button-active text-start bg-gray-200 pb-5" style="border-radius: inherit;">
                              <div class="row">
                              <b class="col-1 text-start">김기정</b>
                              <label class="fs-6 col-11 text-end">2023.07.27</label>
                            </div>
                              <br>
                              <p>아~~~~~ 거하게 3일 잠만자고싶다.adsadsadasdddddddddddddddddddddddddd</p>
                            </button>
                          </div>
                        </li>  
                        <li class="list-group-item border-0 m-0 p-0">
                          <div class="text-end">
                            <button class="form-control button-active text-start bg-gray-200 pb-5" style="border-radius: inherit;">
                              <div class="row">
                              <b class="col-1 text-start">김기정</b>
                              <label class="fs-6 col-11 text-end">2023.07.27</label>
                            </div>
                              <br>
                              <p>아~~~~~ 거하게 3일 잠만자고싶다.adsadsadasdddddddddddddddddddddddddd</p>
                            </button>
                          </div>
                        </li> 
                        <li class="list-group-item border-0 m-0 p-0">
                          <div class="text-end">
                            <button class="form-control button-active text-start bg-gray-200 pb-5" style="border-radius: inherit;">
                              <div class="row">
                              <b class="col-1 text-start">김기정</b>
                              <label class="fs-6 col-11 text-end">2023.07.27</label>
                            </div>
                              <br>
                              <p>아~~~~~ 거하게 3일 잠만자고싶다.adsadsadasdddddddddddddddddddddddddd</p>
                            </button>
                          </div>
                        </li>                         
                        <li class="list-group-item border-0 m-0 p-0">
                          <div class="text-end">
                            <button class="form-control button-active text-start bg-gray-200 pb-5" style="border-radius: inherit;">
                              <div class="row">
                              <b class="col-1 text-start">김기정</b>
                              <label class="fs-6 col-11 text-end">2023.07.27</label>
                            </div>
                              <br>
                              <p>아~~~~~ 거하게 3일 잠만자고싶다.adsadsadasdddddddddddddddddddddddddd</p>
                            </button>
                          </div>
                        </li>                         
                        <li class="list-group-item border-0 m-0 p-0">
                          <div class="text-end">
                            <button class="form-control button-active text-start bg-gray-200 pb-5" style="border-radius: inherit;">
                              <div class="row">
                              <b class="col-1 text-start">김기정</b>
                              <label class="fs-6 col-11 text-end">2023.07.27</label>
                            </div>
                              <br>
                              <p>아~~~~~ 거하게 3일 잠만자고싶다.adsadsadasdddddddddddddddddddddddddd</p>
                            </button>
                          </div>
                        </li> 

                    </ul>
                    <form action="./article-action.jsp" method="post" role="form" class="needs-validation mb-5 mb-lg-7 mt-4"
                    novalidate style="padding: 0">
                    <div class="mb-3 text-end">
                      <textarea class="form-control textArea" name="content" <c:if test="${empty loginMember}">placeholder="로그인 하여야 게시글을 입력할 수 있습니다...."</c:if>
                      required <c:if test="${empty loginMember}">disabled</c:if> style="width: 101.4%; border-radius: 0; max-height: fit-content; max-height: 9em; min-height: 9em"></textarea>
                    </div>

                    <div class="d-md-flex justify-content-end align-items-center mb-0">
                      <input type="submit" value="글 남기기" id="sendBtn" class="btn btn-dark btn-sm" step="">
                    </div>
                  </form>
                    <div class="modal-footer p-0">
                      <nav class="mt-3">
                        <ul class="pagination justify-content-center">
                          <!-- <%-- 처음으로 보여주기 여부 --%> -->
                          <c:if test="${pagination.showFirst}">
                            <li class="page-item">
                              <a class="page-link pagingBT" href="?page=1" aria-label="First">
                                <span aria-hidden="true">처음으로</span>
                              </a>
                            </li>
                          </c:if>

                          <!-- <%-- 이전 목록 보여주기 여부 --%> -->
                          <c:if test="${pagination.showPrevious}">
                            <li class="page-item">
                              <a class="page-link pagingBT" href="?page=${pagination.previousStartPage}"
                                aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                              </a>
                            </li>
                          </c:if>

                          <c:forEach var="i" begin="${pagination.startPage }" end="${pagination.endPage }">
                            <c:choose>
                              <c:when test="${i == pagination.params.requestPage}">
                                <li class="page-item active"><a class="page-link pagingBT">${i}</a></li>
                              </c:when>
                              <c:otherwise>
                                <li class="page-item"><a class="page-link pagingBT" href="?page=${i}">${i}</a></li>
                              </c:otherwise>
                            </c:choose>
                          </c:forEach>

                          <!-- <%-- 다음 목록 보여주기 여부 --%> -->
                          <c:if test="${pagination.showNext}">
                            <li class="page-item">
                              <a class="page-link pagingBT" href="?page=${pagination.nextStartPage}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                              </a>
                            </li>
                          </c:if>
                          <!-- <%-- 마지막으로 보여주기 여부 --%> -->
                          <c:if test="${pagination.showLast}">
                            <li class="page-item">
                              <a class="page-link pagingBT" href="?page=${pagination.totalPages}" aria-label="First">
                                <span aria-hidden="true">마지막으로</span>
                              </a>
                            </li>
                          </c:if>
                        </ul>
                      </nav>
                      <button type="button" class="btn btn-dark" data-bs-dismiss="modal"
                        style="background-color:black">나가기</button>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
              <div class="overlay"></div>
    </section>
    <!-- 상세페이지 끝 -->
  </main>
  <jsp:include page="/WEB-INF/views/modules/footer.jsp"/>
</body>

</html>