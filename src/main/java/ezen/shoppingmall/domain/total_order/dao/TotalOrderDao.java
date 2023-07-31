package ezen.shoppingmall.domain.total_order.dao;

import java.sql.Connection;
import java.util.List;

import ezen.shoppingmall.domain.cart.dto.Cart;
import ezen.shoppingmall.domain.customer.dto.Customer;
import ezen.shoppingmall.domain.product.dto.Product;

/**
 * 데이터 베이스 고객 명세
 * @author 장원종
 *
 */
public interface TotalOrderDao {
	//주문에 맞는 customer 정보 가져오기(인자 카테고리명 리턴 리스트)
	List<Customer> findCustomerByCustKey(Connection connection, int custKey);
	
	List<Product> findProductbyPKey(Connection connection, String productKey);
	
	
}
