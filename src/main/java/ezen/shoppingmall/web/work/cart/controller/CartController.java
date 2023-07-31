package ezen.shoppingmall.web.work.cart.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ezen.shoppingmall.domain.cart.dto.Cart;
import ezen.shoppingmall.domain.cart.service.CartService;
import ezen.shoppingmall.domain.common.factory.ServiceFactory;
import ezen.shoppingmall.domain.customer.dto.Customer;
import ezen.shoppingmall.web.mvc.controller.HttpController;

/**
 * 장바구니 /cart요청관련 DB처리
 * @author 조영호
 *
 */
public class CartController implements HttpController{
	
	private CartService cartService = ServiceFactory.getInstance().getCartService();
	
	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) {
		String viewName = "cart/cart";
		String pKey = paramMap.get("pkey");
		
		//session에 저장된 로그인 멤버에 접근함.
		Customer customer = (Customer)request.getSession().getAttribute("loginmember");
		//int custKey = customer.getCustKey();
		
		
		
//		Cart cart = cartService.getCartByCustKey(custKey);
//		request.getSession().setAttribute("cart", cart);
		
//		request.getSession().setAttribute("items", items);
//		request.getSession().setAttribute("custKey", custKey);
		
		return viewName;
	}
}
