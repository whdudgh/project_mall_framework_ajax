package ezen.shoppingmall.domain.product.service;

import java.util.List;

import ezen.shoppingmall.domain.product.dto.Category;
import ezen.shoppingmall.domain.product.dto.Product;
import ezen.shoppingmall.web.common.page.PageParams;

/**
 * 상품 관련 비즈니스 로직 처리 및 트랜잭션 관리를 위한 명세
 * @author 문승욱
 *
 */
public interface ProductService {
	//전체 페이지 
	public int getProductCount(String categoryKey);
	
	// 상품 카테고리 목록 반환
	public List<Category> getCategorys();
	
	//요청카테고리에 해당하는 상품목록 반환
	//List<Product> getProductList(String categoryName);
	
	//요청상세페이지에 해당하는 상품정보 반환
	Product getProductByName(String pName);
	
	/* 요청 페이지, 페이지당 보여지는 목록 갯수에 따른 상품 목록 반환 */
	List<Product> getProductList(String categoryName, PageParams params);
	
}
