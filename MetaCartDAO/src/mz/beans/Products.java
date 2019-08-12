package mz.beans;

public class Products {
	private int productId;
	private String productName;
	private String description;
	private String categoryName;
	private int productPrice;
	private int quantity;
	
	public Products(int productId, String productName, String categoryName, String description, int productPrice) {
		this.productId=productId;
		this.productName=productName;
		this.categoryName=categoryName;
		this.description=description;
		this.productPrice=productPrice;
	}
	
	public Products(int productId, String productName, String categoryName, int productPrice) {
		this.productId=productId;
		this.productName=productName;
		this.categoryName=categoryName;
		this.productPrice=productPrice;
	}
	
	public Products(String productName, String description, int price) {
		this.productName=productName;
		this.description=description;
		this.productPrice=price;
	}

	public Products(String productName, int price, int quantity) {
		this.productName=productName;
		this.productPrice=price;
		this.quantity=quantity;
	}

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
