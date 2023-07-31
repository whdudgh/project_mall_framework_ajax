package ezen.shoppingmall.web.work.product.controller;

import java.util.Map;

import ezen.shoppingmall.web.mvc.controller.WebController;

public class ProductController implements WebController{

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		String viewName ="product/product";	
		//구현내용필요
		return viewName;
	}
}
