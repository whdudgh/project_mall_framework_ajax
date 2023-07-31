package ezen.shoppingmall.web.work.total_order.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ezen.shoppingmall.domain.common.factory.ServiceFactory;
import ezen.shoppingmall.domain.total_order.service.TotalOrderService;
import ezen.shoppingmall.web.mvc.controller.HttpController;

/*
 * /order에 대한 요청처리
 */
public class TotalOrderController implements HttpController {
	private TotalOrderService orderService = ServiceFactory.getInstance().getTotalOrderService();

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) {
		String viewName = "order/order";
		int custKey = 1;
		String productKey = "IW390703";

//		List<Customer> custList = orderService.getCostomer(custKey);
//		model.put("custList", custList);

//		int custKey = Integer.parseInt(request.getSession().getAttribute("custKey"));
		
		//List<Product> productList = orderService.getProduct(productKey);
		//model.put("productKey", productList);
		
//		request.getSession().getAttribute("items");

		//paramMap.get("totalPrice");
		
		//int totalPrice = (Integer) null;
		//model.put("totalPrice", totalPrice);
		
		
		return viewName;

	}
}
