package ezen.shoppingmall.web.work.home;

import java.util.List;
import java.util.Map;

import ezen.shoppingmall.domain.common.factory.ServiceFactory;
import ezen.shoppingmall.domain.product.dto.Category;
import ezen.shoppingmall.domain.product.service.ProductService;
import ezen.shoppingmall.web.mvc.controller.WebController;
/**
 * /index 요청에 대한 세부 핸들러
 */
public class HomeController implements WebController{
	
	private ProductService productService = ServiceFactory.getInstance().getProductService();
	

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		String viewName = "index";
		// 홈페이지에서 동적 컨텐츠 출력 시 Service 객체 사용
		//List<Category> categories = productService.getCategorys();
		//model.put("categories", categories);
		return viewName;
	}
}













