package ezen.shoppingmall.domain.cart.dto;

import java.util.List;

import ezen.shoppingmall.domain.cart_item.dto.CartItem;

/**
 * 장바구니 항목을 담은 장바구니 클래스화
 * @author 조영호
 *
 */
public class Cart {
	
	List<CartItem> cart;
	int totalPay;
	
	public Cart() {}

	public Cart(List<CartItem> cart, int totalPay) {
		this.cart = cart;
		this.totalPay = totalPay;
	}
	
	public int getTotalPay() {
		return totalPay;
	}

	public void setTotalPay(int totalPay) {
		this.totalPay = totalPay;
	}
	
	public List<CartItem> getCart() {
		return cart;
	}
	
	public void setCart(List<CartItem> cart) {
		this.cart = cart;
	}
	
	@Override
	public String toString() {
		return "Cart [cart=" + cart + "]";
	}
	
	public void updateProductCount(Cart cart,String productId, String productMount) {
		List<CartItem> list = cart.getCart();
		for (CartItem cartItem : list) {
			if(cartItem.getProduct().getpKey().equalsIgnoreCase(productId)) {
				cartItem.setProductCnt(Integer.parseInt(productMount));
				System.out.println("수량증가했다..");
			} else {
				System.out.println("수량증가 실패");
			}
		}
		// 상품아이디와 상품 갯수를 받아 카트에담긴 물품의 수량을 조절하기		
	}
	
	
	
}
