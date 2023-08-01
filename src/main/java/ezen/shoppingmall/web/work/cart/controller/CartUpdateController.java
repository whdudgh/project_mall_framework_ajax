package ezen.shoppingmall.web.work.cart.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ezen.shoppingmall.domain.cart.dto.Cart;
import ezen.shoppingmall.domain.cart.service.CartService;
import ezen.shoppingmall.domain.common.factory.ServiceFactory;
import ezen.shoppingmall.web.mvc.controller.HttpController;
import ezen.shoppingmall.web.mvc.controller.RestController;

/**
 * 장바구니 /cart요청관련 DB처리
 * @author 조영호
 * /cart/update 요청에 대한 세부컨트롤러 (카트 수량 변경)
 *
 */
public class CartUpdateController implements RestController{
	
	@Override
	public void process(Map<String, String> paramMap, HttpServletRequest request,	HttpServletResponse response) {
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		String result = null;
		try {
			out = response.getWriter();
			String productId = paramMap.get("productId");
			String productMount = paramMap.get("productMount");
			
			Cart cart  = (Cart)request.getSession().getAttribute("cart");
			cart.updateProductCount(cart, productId, productMount);
			result = "true";
			
		} catch (IOException e) {
			result = "false";
		} finally {
			out.println(result);
		}
	}
}
