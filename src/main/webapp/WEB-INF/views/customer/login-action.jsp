<%@page import="java.net.URLEncoder"%>
<%@page import="ezen.shoppingmall.domain.common.factory.DaoFactory"%>
<%@page import="ezen.shoppingmall.domain.customer.dto.Customer"%>
<%@page import="ezen.shoppingmall.domain.customer.dao.CustomerDao"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18/dist/sweetalert2.min.css">
  <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18/dist/sweetalert2.min.js"></script>


<c:choose>
	<c:when test="${empty loginCustomer }">
		<script>
		Swal.fire({
			  icon: 'error',
			  title: 'Oops...',
			  text: '로그인에 실패하셨습니다!',
			})
			location.href= '/login';
		</script>
	</c:when>
	<c:otherwise>
		Swal.fire({
			  icon: 'success',
			  title: 'Oops...',
			  text: '로그인을 성공하셨습니다!',
			})
		<c:redirect url="/"/>	
	</c:otherwise>
</c:choose>
