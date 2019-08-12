package mz.beans;

public class ProductImages {
	private int imageId;
	private String imageName;
	private String productName;
	private String imagePath;
	private int productId;
	
	public ProductImages(int productId, String productName, String fileName, String savePath) {
		this.productId=productId;
		this.productName=productName;
		this.imageName=fileName;
		this.imagePath=savePath;
	}
	
	public ProductImages(int imageId, String imageName, String productName) {
		this.imageId=imageId;
		this.imageName=imageName;
		this.productName=productName;
	}

	public ProductImages(String productName, String imageName) {
		this.productName=productName;
		this.imageName=imageName;
	}

	public ProductImages(int imageId, int productId, String productName, String fileName, String savePath) {
		this.imageId=imageId;
		this.productId=productId;
		this.productName=productName;
		this.imageName=fileName;
		this.imagePath=savePath;
	}

	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
}	
