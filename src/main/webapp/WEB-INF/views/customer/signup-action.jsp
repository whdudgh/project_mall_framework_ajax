<%@page import="ezen.shoppingmall.domain.common.factory.DaoFactory"%>
<%@page import="ezen.shoppingmall.domain.customer.dao.CustomerDao"%>
<%@ page contentType="text/html; charset=utf-8" %>


<% request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="customer" class="ezen.shoppingmall.domain.customer.dto.Customer" scope="session"/>
<jsp:setProperty property="*" name="member"/>

