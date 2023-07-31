package ezen.shoppingmall.domain.total_order.service;

import java.util.List;

import ezen.shoppingmall.domain.customer.dto.Customer;
import ezen.shoppingmall.domain.product.dto.Product;

/**
 * 고객 관련 비즈니스 로직 처리 및 트랜잭션 관리를 위한 명세
 * @author 장장장
 *
 */
public interface TotalOrderService {
	
	//요청카테고리에 해당하는 상품목록 반환
	List<Customer> getCostomer(int custKey);
	
	List<Product> getProduct(String productKey);
	
}
