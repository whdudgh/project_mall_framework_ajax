package ezen.shoppingmall.domain.cart_item.dto;

import ezen.shoppingmall.domain.product.dto.Product;

/**
 * 카트에 담길 상품 클래스
 * @author 조영호
 *
 */
public class CartItem {
	Product product;
	int productCnt;
	String containDate;
	
	public CartItem() {}

	public CartItem(Product product, int productCnt, String containDate) {
		this.product = product;
		this.productCnt = productCnt;
		this.containDate = containDate;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getProductCnt() {
		return productCnt;
	}

	public void setProductCnt(int productCnt) {
		this.productCnt = productCnt;
	}

	public String getContainDate() {
		return containDate;
	}

	public void setContainDate(String containDate) {
		this.containDate = containDate;
	}

	@Override
	public String toString() {
		return "CartItem [product=" + product + ", productCnt=" + productCnt + ", containDate=" + containDate + "]";
	}

	
	
	
}
