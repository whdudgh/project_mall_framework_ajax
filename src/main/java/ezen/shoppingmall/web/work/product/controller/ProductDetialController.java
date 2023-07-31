package ezen.shoppingmall.web.work.product.controller;

import java.util.Map;

import ezen.shoppingmall.domain.common.factory.ServiceFactory;
import ezen.shoppingmall.domain.product.dto.Product;
import ezen.shoppingmall.domain.product.service.ProductService;
import ezen.shoppingmall.web.mvc.controller.WebController;

/**
 * 선택된 상품의 상세페이지로 이동하는 역할
 * @author 조영호
 *
 */
public class ProductDetialController implements WebController{
	
	private ProductService productService = ServiceFactory.getInstance().getProductService();

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		String viewName = "product/product";
		String pName = paramMap.get("pName");
		Product selectedProduct = productService.getProductByName(pName);
		
		model.put("selectedProduct", selectedProduct);
		return viewName;
	}
}
