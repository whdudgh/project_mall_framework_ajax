package ezen.shoppingmall.domain.order_detail.dto;

public class OrderDetail {
	
	private int orderDetKey;
	private String pKey;
	private String orderKey;
	
	public OrderDetail() {}

	public OrderDetail(int orderDetKey, String pKey, String orderKey) {
		this.orderDetKey = orderDetKey;
		this.pKey = pKey;
		this.orderKey = orderKey;
	}

	public int getOrderDetKey() {
		return orderDetKey;
	}

	public void setOrderDetKey(int orderDetKey) {
		this.orderDetKey = orderDetKey;
	}

	public String getpKey() {
		return pKey;
	}

	public void setpKey(String pKey) {
		this.pKey = pKey;
	}

	public String getOrderKey() {
		return orderKey;
	}

	public void setOrderKey(String orderKey) {
		this.orderKey = orderKey;
	}

	@Override
	public String toString() {
		return "OrderDetail [orderDetKey=" + orderDetKey + ", pKey=" + pKey + ", orderKey=" + orderKey + "]";
	}
	
	
	

}
