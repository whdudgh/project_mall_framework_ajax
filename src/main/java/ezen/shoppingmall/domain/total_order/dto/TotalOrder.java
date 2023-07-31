package ezen.shoppingmall.domain.total_order.dto;

public class TotalOrder {
	
	private String orderKey;
	private int custKey;
	private String oRdate;
	private String payMethod;
	private int itemCnt;
	private int price;
	
	public TotalOrder() {}

	public TotalOrder(String orderKey, int custKey, String oRdate, String payMethod, int itemCnt, int price) {
		this.orderKey = orderKey;
		this.custKey = custKey;
		this.oRdate = oRdate;
		this.payMethod = payMethod;
		this.itemCnt = itemCnt;
		this.price = price;
	}

	public String getOrderKey() {
		return orderKey;
	}

	public void setOrderKey(String orderKey) {
		this.orderKey = orderKey;
	}

	public int getCustKey() {
		return custKey;
	}

	public void setCustKey(int custKey) {
		this.custKey = custKey;
	}

	public String getoRdate() {
		return oRdate;
	}

	public void setoRdate(String oRdate) {
		this.oRdate = oRdate;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public int getItemCnt() {
		return itemCnt;
	}

	public void setItemCnt(int itemCnt) {
		this.itemCnt = itemCnt;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "TotalOrder [orderKey=" + orderKey + ", custKey=" + custKey + ", oRdate=" + oRdate + ", payMethod="
				+ payMethod + ", itemCnt=" + itemCnt + ", price=" + price + "]";
	}
	
	

}
