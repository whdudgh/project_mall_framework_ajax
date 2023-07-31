package ezen.shoppingmall.web.work.customer.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ezen.shoppingmall.domain.cart.dto.Cart;
import ezen.shoppingmall.domain.cart.service.CartService;
import ezen.shoppingmall.domain.common.factory.ServiceFactory;
import ezen.shoppingmall.domain.customer.dto.Customer;
import ezen.shoppingmall.domain.customer.service.CustomerService;
import ezen.shoppingmall.web.mvc.controller.HttpController;

/**
 * 회원 로그인 및 로그아웃 처리 세부 컨트롤러
 * /customer/login
 */
public class CustomerLoginController implements HttpController {
	private CustomerService customerService = ServiceFactory.getInstance().getCustomerService();
	private CartService cartService = ServiceFactory.getInstance().getCartService();
	
	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) {
		String viewName = "/index";
		// 회원 로그인 요청 (POST)
		if(request.getMethod().equalsIgnoreCase("post")) {
			String loginEmail = paramMap.get("email");
			String loginPasswd = paramMap.get("uPwd");
			String saveEmail = paramMap.get("rememberme");
			Customer loginCustomer = customerService.isCustomer(loginEmail, loginPasswd);
			int custKey = loginCustomer.getCustKey();
			Cart cart = cartService.getCartByCustKey(custKey);
			// 회원인 경우
			if(loginCustomer != null){
				// 세션에 로그인정보 저장
				request.getSession().setAttribute("cart", cart);
				request.getSession().setAttribute("loginCustomer", loginCustomer);
				// 아이디 저장 체크 시 쿠키 생성
				if(saveEmail != null){
					Cookie saveCookie;
					try {
						saveCookie = new Cookie("saveEmail", URLEncoder.encode(loginCustomer.getEmail(), "utf-8"));
						saveCookie.setPath("/");
						saveCookie.setMaxAge(60*60*24*100);
						response.addCookie(saveCookie);
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}	
			}
		}else { // 로그아웃 요청 (GET)
			// 세션 삭제
			request.getSession().invalidate();
		}
		return viewName;
	}
}
