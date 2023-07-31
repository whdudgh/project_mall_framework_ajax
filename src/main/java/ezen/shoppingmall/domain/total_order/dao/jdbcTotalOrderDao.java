package ezen.shoppingmall.domain.total_order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ezen.shoppingmall.domain.cart.dto.Cart;
import ezen.shoppingmall.domain.customer.dto.Customer;
import ezen.shoppingmall.domain.product.dto.Product;

/**
 * RDB를 통해 고객 기능 구현체
 * @author 장원종
 *
 */
public class jdbcTotalOrderDao implements TotalOrderDao{



	@Override
	public List<Customer> findCustomerByCustKey(Connection connection, int custKey) {
		List<Customer> resultList = null;
		//기능 구현 시작
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT u_name, email, phone_num")
		  .append(" FROM customer")
		  .append(" WHERE CUST_KEY = ?");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sb.toString());
			pstmt.setInt(1,custKey);
			rs = pstmt.executeQuery();
			resultList = new ArrayList<Customer>();
			if (rs.next()) {			
				String email = rs.getString("email");
				String uName = rs.getString("u_name");
				String phoneNumber = rs.getString("phone_num");
				// 웹 페이지 줄바꿈 처리
				Customer customer = new Customer();
				customer.setEmail(email);
				customer.setuName(uName);
				customer.setPhoneNum(phoneNumber);
				resultList.add(customer);
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
			} catch (Exception e) {}
		}
		return resultList;
	}
	
	
	@Override
	public List<Product> findProductbyPKey(Connection connection, String productKey) {
		List<Product> resultList = null;
		//기능 구현 시작
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT P_KEY, SUB_IMG1, PRICE")
		  .append(" FROM product")
		  .append(" WHERE P_KEY = ?");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sb.toString());
			pstmt.setString(1,productKey);
			rs = pstmt.executeQuery();
			resultList = new ArrayList<Product>();
			if (rs.next()) {			
				String pdKey = rs.getString("P_KEY");
				String subImg = rs.getString("SUB_IMG1");
				int pdPrice = rs.getInt("PRICE");
				// 웹 페이지 줄바꿈 처리
				Product product = new Product();
				product.setpKey(pdKey );
				product.setSubImg1(subImg);
				product.setPrice(pdPrice);
				resultList.add(product);
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
			} catch (Exception e) {}
		}
		return resultList;
	}
}
