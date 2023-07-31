package ezen.shoppingmall.domain.cart.service;

import ezen.shoppingmall.domain.cart.dto.Cart;

/**
 * CartDao에서 만든 기능의 커넥션 관리 명세
 * @author 조영호
 *
 */
public interface CartService {
	
	//회원코드에 따른 카트정보를 받아오는 커넥션관리
	Cart getCartByCustKey(int custKey);
	
	//회원코드에 따른 회원장바구니 부여 커넥션관리
	boolean setCartAtCustomer(int custKey);
	
	//장바구니 추가 커넥션관리
	boolean setItemInCart(int cartNum, String pName);
	
	//장바구니 내부 상품갯수 변경 커넥션관리
	boolean changeCount(int count, int cartNum, String pKey);
}
