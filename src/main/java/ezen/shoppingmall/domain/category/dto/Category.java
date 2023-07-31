package ezen.shoppingmall.domain.category.dto;

public class Category {
	
	private int categoryKey;
	private String cName;
	
	public Category() {}

	public Category(int categoryKey, String cName) {
		this.categoryKey = categoryKey;
		this.cName = cName;
	}

	public int getCategoryKey() {
		return categoryKey;
	}

	public void setCategoryKey(int categoryKey) {
		this.categoryKey = categoryKey;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	@Override
	public String toString() {
		return "Category [categoryKey=" + categoryKey + ", cName=" + cName + "]";
	}
	
	
	
	

}
