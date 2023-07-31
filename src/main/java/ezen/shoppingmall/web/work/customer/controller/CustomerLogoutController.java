package ezen.shoppingmall.web.work.customer.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ezen.shoppingmall.web.mvc.controller.HttpController;

public class CustomerLogoutController implements HttpController{

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) {
		String viewName = "customer/logout-action";
		
		
		
		
		
		return viewName;
	}

}
