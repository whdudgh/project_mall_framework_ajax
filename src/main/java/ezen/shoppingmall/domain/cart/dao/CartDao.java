package ezen.shoppingmall.domain.cart.dao;

import java.sql.Connection;

import ezen.shoppingmall.domain.cart.dto.Cart;
import ezen.shoppingmall.domain.cart_item.dto.CartItem;

/**
 * 순수클래스 cart를 이용한 기능 명세
 * @author 조영호
 *
 */
public interface CartDao {
	//회원코드를 받아 그 회원의 카트정보를 갖고오는 메소드
	Cart getCart(Connection connection, int custkey);
	
	//회원가입시 회원코드를 받아 해당 회원에게 장바구니 부여메소드
	boolean giveCart(Connection connection, int custKey);
	
	//상품상세에서 장바구니 추가하기 하면 원래 있던 장바구니에 추가되는 메소드
	boolean addToCart(Connection connection, int cartNum, String pName);
	
	//상품갯수를 +, -버튼 누를 때 마다 실제테이블의 값이 변경되는 메소드
	boolean updateCount(Connection connection, int count, int cartNum, String p_key);
}
