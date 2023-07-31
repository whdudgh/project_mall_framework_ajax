package ezen.shoppingmall.domain.product.dto;

public class Category {
	private String categoryKey;
	private String categoryName;
	
	public Category() {}

	public Category(String categoryKey, String categoryName) {
		super();
		this.categoryKey = categoryKey;
		this.categoryName = categoryName;
	}

	public String getCategoryKey() {
		return categoryKey;
	}

	public void setCategoryKey(String categoryKey) {
		this.categoryKey = categoryKey;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Category [categoryKey=" + categoryKey + ", categoryName=" + categoryName + "]";
	}

}
