package ezen.shoppingmall.web.work.customer.controller;

import java.util.Map;

import ezen.shoppingmall.web.mvc.controller.WebController;

public class MoveToLoginController implements WebController{

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		String view = "customer/login";
		//그냥 이동만함.
		return view;
	}

}
