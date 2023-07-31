package ezen.shoppingmall.domain.cart.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import ezen.shoppingmall.domain.cart.dao.CartDao;
import ezen.shoppingmall.domain.cart.dto.Cart;
import ezen.shoppingmall.domain.cart_item.dto.CartItem;
import ezen.shoppingmall.domain.common.factory.ServiceFactory;

/**
 * CartService의 구현객체
 * @author 조영호
 *
 */
public class CartServiceImpl implements CartService {
	
	private DataSource dataSource;
	private CartDao cartDao;

	public CartServiceImpl(DataSource dataSource, CartDao cartDao) {
		this.dataSource = dataSource;
		this.cartDao = cartDao;
	}
	
	/**
	 * CartDao에 있는 특정회원 카트반환 커넥션관리
	 */
	@Override
	public Cart getCartByCustKey(int custKey) {
		Cart cart = null;
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			
			cart = cartDao.getCart(connection, custKey);
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (connection != null)	connection.close();
			} catch (SQLException e1) {	}
		}
		
		return cart;
		
	}
	
	/**
	 * CartDao에 있는 회원가입시 회원에게 부여되는카트 커넥션관리
	 * insert문이라 auto commit해제 필요
	 */
	@Override
	public boolean setCartAtCustomer(int custKey) {
		boolean success = false;
		Connection connection = null;
		try {
			// 트랜잭션 시작
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			
			cartDao.giveCart(connection, custKey);
			 
			// 정상 처리 시 커밋
			connection.commit();
			success = true;
		} catch (Exception e) {
			try {connection.rollback();} catch (SQLException e1) {}
			throw new RuntimeException(e.getMessage());
		} finally {
			try {if(connection != null) connection.close();} catch (SQLException e1) {}
		}
		return success;
	}
	
	/**
	 * CartDao에 있는 장바구니담기메소드 커넥션관리
	 * insert문이라 auto commit해제 필요
	 */
	@Override
	public boolean setItemInCart(int cartNum, String pName) {
		boolean success = false;
		Connection connection = null;
		try {
			// 트랜잭션 시작
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			
			cartDao.addToCart(connection, cartNum, pName);
			
			// 정상 처리 시 커밋
			connection.commit();
			success = true;
		} catch (Exception e) {
			try {connection.rollback();} catch (SQLException e1) {}
			throw new RuntimeException(e.getMessage());
		} finally {
			try {if(connection != null) connection.close();} catch (SQLException e1) {}
		}
		return success;
	}
	
	/**
	 * CartDao에 있는 장바구니의 특정상품의 갯수 업데이트메소드 커넥션관리
	 * update문이라 auto commit해제 필요
	 */
	@Override
	public boolean changeCount(int count, int cartNum, String pKey) {
		boolean success = false;
		Connection connection = null;
		try {
			// 트랜잭션 시작
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			
			cartDao.updateCount(connection, count, cartNum, pKey);
			
			// 정상 처리 시 커밋
			connection.commit();
			success = true;
		} catch (Exception e) {
			try {connection.rollback();} catch (SQLException e1) {}
			throw new RuntimeException(e.getMessage());
		} finally {
			try {if(connection != null) connection.close();} catch (SQLException e1) {}
		}
		return success;
	}
	
	public static void main(String[] args) {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		CartService cartService = serviceFactory.getCartService();
		
//		회원번호에 부여된 카트내용물 불러오기
//		Cart cart = cartService.getCartByCustKey(1);
//		List<CartItem> cartItems = cart.getCart();
//		for (CartItem cartItem : cartItems) {
//			System.out.println(cartItem);
//		}
//		회원가입시 회원고유번호로 카트부여
//		boolean result = cartService.setCartAtCustomer(5);
//		장바구니추가시 실제테이블에 상품추가
//		boolean result = cartService.setItemInCart(501, "IW390701");
//		+, -버튼에 대한 실제 아이템 갯수 업데이트
//		boolean result = cartService.changeCount(2, 501, "IW390701");
		
//		System.out.println(result);
	}
}
