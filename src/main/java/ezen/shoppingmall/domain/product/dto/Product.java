package ezen.shoppingmall.domain.product.dto;

public class Product {
	
	private String pKey;
	private String categoryName;
	private String pName;
	private String mainImg;
	private String subImg1;
	private String subImg2;
	private String subImg3;
	private String subImg4;
	private int price;
	private int pCnt;
	private String detailComment;
	
	public Product () {}

	public Product(String pKey, String categoryName, String pName, String mainImg, String subImg1, String subImg2,
			String subImg3, String subImg4, int price, int pCnt, String detailComment) {
		this.pKey = pKey;
		this.categoryName = categoryName;
		this.pName = pName;
		this.mainImg = mainImg;
		this.subImg1 = subImg1;
		this.subImg2 = subImg2;
		this.subImg3 = subImg3;
		this.subImg4 = subImg4;
		this.price = price;
		this.pCnt = pCnt;
		this.detailComment = detailComment;
	}
	//생성자 오버로딩 
	public Product(String categoryName, String pName, String mainImg, int price) {
		this.categoryName = categoryName;
		this.pName = pName;
		this.mainImg = mainImg;
		this.price = price;
	}

	public String getpKey() {
		return pKey;
	}

	public void setpKey(String pKey) {
		this.pKey = pKey;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getMainImg() {
		return mainImg;
	}

	public void setMainImg(String mainImg) {
		this.mainImg = mainImg;
	}

	public String getSubImg1() {
		return subImg1;
	}

	public void setSubImg1(String subImg1) {
		this.subImg1 = subImg1;
	}

	public String getSubImg2() {
		return subImg2;
	}

	public void setSubImg2(String subImg2) {
		this.subImg2 = subImg2;
	}

	public String getSubImg3() {
		return subImg3;
	}

	public void setSubImg3(String subImg3) {
		this.subImg3 = subImg3;
	}

	public String getSubImg4() {
		return subImg4;
	}

	public void setSubImg4(String subImg4) {
		this.subImg4 = subImg4;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getpCnt() {
		return pCnt;
	}

	public void setpCnt(int pCnt) {
		this.pCnt = pCnt;
	}

	public String getDetailComment() {
		return detailComment;
	}

	public void setDetailComment(String detailComment) {
		this.detailComment = detailComment;
	}

	@Override
	public String toString() {
		return "Product [pKey=" + pKey + ", categoryName=" + categoryName + ", pName=" + pName + ", mainImg=" + mainImg
				+ ", subImg1=" + subImg1 + ", subImg2=" + subImg2 + ", subImg3=" + subImg3 + ", subImg4=" + subImg4
				+ ", price=" + price + ", pCnt=" + pCnt + ", detailComment=" + detailComment + "]";
	}
	
	
}
