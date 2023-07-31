package ezen.shoppingmall.web.work.customer.controller;

import java.util.Map;

import ezen.shoppingmall.web.mvc.controller.WebController;

public class MoveToSignupController implements WebController{

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		String viewName = "customer/signup";
		return viewName;
	}

}
