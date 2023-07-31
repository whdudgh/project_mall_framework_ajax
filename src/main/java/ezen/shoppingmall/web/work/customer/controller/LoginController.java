package ezen.shoppingmall.web.work.customer.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ezen.shoppingmall.web.mvc.controller.HttpController;

/**
 * 스위트 얼럿 테스트를 위해 이동만하는 컨트롤러
 * @author 조영호
 *
 */
public class LoginController implements HttpController{

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) {
		String viewName = "customer/login";
		return viewName;
	}

}
