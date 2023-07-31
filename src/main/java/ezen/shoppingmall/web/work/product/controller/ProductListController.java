package ezen.shoppingmall.web.work.product.controller;

import java.util.List;
import java.util.Map;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import ezen.shoppingmall.domain.category.dto.Category;
import ezen.shoppingmall.domain.common.factory.ServiceFactory;
import ezen.shoppingmall.domain.product.dto.Product;
import ezen.shoppingmall.domain.product.service.ProductService;
import ezen.shoppingmall.web.common.page.PageParams;
import ezen.shoppingmall.web.common.page.Pagination;
import ezen.shoppingmall.web.mvc.controller.WebController;

public class ProductListController implements WebController {

	// 한 페이지에 보여지는 목록 갯수 설정
	private static final int ELEMENT_SIZE = 4;
	// 한페이지에 보여지는 페이지 갯수 설정
	private static final int PAGE_SIZE = 5;

	private ProductService productService = ServiceFactory.getInstance().getProductService();

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		String viewName = "product/productlist";
		String categoryName = paramMap.get("category");
		// System.out.println(categoryName);
		// 가져온 category네임에 맞는 페이지를 보여주기 위해 DB갖다오기

		// 요청 페이지 파라미터를 가져옴 (페이지가 지정되지 않았을 경우 1페이지로 설정)
		int requestPage = 1;
		if (paramMap.containsKey("page")) {
			try {
				requestPage = Integer.parseInt(paramMap.get("page"));
			} catch (NumberFormatException e) {
				requestPage = 1;
			}
		}
		
		// 페이징 계산을 위한 게시글 전체 갯수 조회
		int rowCount = productService.getProductCount(categoryName);

		// 전체 페이지수 계산
		PageParams pageParams = new PageParams(ELEMENT_SIZE, PAGE_SIZE, requestPage, rowCount);
		Pagination pagination = new Pagination(pageParams);
		System.out.println(pageParams);
		
		// 상품목록
		List<Product> productList = productService.getProductList(categoryName, pageParams);
		// 상품 목록이 비어있지 않을 경우 첫 번째 상품의 카테고리 이름 사용
		model.put("categoryName", categoryName);
		model.put("productList", productList);
		model.put("pagination", pagination);
		return viewName;
	}

}
