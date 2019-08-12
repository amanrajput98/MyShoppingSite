package mz.dbservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mz.beans.Categories;
import mz.beans.ProductImages;
import mz.beans.Products;

public class DbService {
	private static Connection conn=null;
	
	public static void doConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/MetaCart", "root", "ajjumudit");
	}
	
	public static boolean addCategory(Categories category) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		doConnection();
		Statement stmt = conn.createStatement();
	    String query = "insert into category(categoryId,category_Name) values("+category.getCategoryId()+",'"+category.getCategoryName()+"')";
	    int result=stmt.executeUpdate(query);
	    conn.close();
	    return result>0;
	}
	
	public static boolean addProduct(Products product) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		doConnection();
		Statement stmt = conn.createStatement();
	    String query = "insert into products(productId,product_Name,categoryId,description,price) values("+product.getProductId()+",'"+product.getProductName()+
	    		"',"+searchCategoryId(product.getCategoryName())+",'"+product.getDescription()+"',"+product.getProductPrice()+")";
	    System.out.println(query);
	    int result=stmt.executeUpdate(query);

	    conn.close();
	    return result>0;
	}
	
	public static int searchCategoryId(String categoryName) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		int categoryId=0;
		System.out.println(categoryName);
		doConnection();
		Statement stmt = conn.createStatement();
		String query="select categoryId from category where Category_Name='"+categoryName+"'";
		ResultSet rs= stmt.executeQuery(query);
		if(rs.next())
			categoryId=rs.getInt("categoryId");
		conn.close();
		return categoryId;
	}
	
	public static int getProductId(String productName) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		int productId=0;
		doConnection();
		Statement stmt=conn.createStatement();
		String query="select productId from products where product_Name='"+productName+"'";
		ResultSet rs= stmt.executeQuery(query);
		if(rs.next())
			productId=rs.getInt("productId");
		conn.close();
		return productId;
	}
	
	public static boolean uploadImage(ProductImages productImage) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		doConnection();
		Statement stmt = conn.createStatement();
	    String query = "insert into images(imageName,productName,productId,imagePath) values('"+productImage.getImageName()+"','"+productImage.getProductName()+
	    		"',"+productImage.getProductId()+",'"+productImage.getImagePath()+"')";
	    System.out.println(query);
	    int result=stmt.executeUpdate(query);

	    conn.close();
	    return result>0;
	}
	
	public static ArrayList<Categories> serachCategory(Categories category) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		ArrayList<Categories> categoriesList=new ArrayList<Categories>();
		doConnection();
		Statement stmt = conn.createStatement();
        StringBuilder query =new StringBuilder("select * from category where");
        Categories searchCategory=new Categories(category.getCategoryId(), category.getCategoryName());
        
        if(searchCategory.getCategoryId()!=0) {
        	query.append(" categoryId=").append(searchCategory.getCategoryId()).append(" and");
        }
        if(!searchCategory.getCategoryName().equals("")) {
        	query.append(" Category_Name='").append(searchCategory.getCategoryName()).append("'").append(" and");
        }
        String newQuery=query.toString();
        String finalQuery = null;
        if (newQuery.endsWith(" and")) {
            finalQuery = newQuery.substring(0, newQuery.length() - 4);
        }
        if (newQuery.endsWith(" where")) {
            finalQuery = newQuery.replace(" where", ";");
        }
        System.out.println("final ::"+finalQuery);
        ResultSet rs = stmt.executeQuery(finalQuery);
        Categories searchedCategory;
        while(rs.next()) {
        	searchedCategory=new Categories(rs.getInt("CategoryId"),rs.getString("Category_Name"));
        	categoriesList.add(searchedCategory);
        }
        conn.close();
		return categoriesList;
	}
	
	public static Categories editCategory(int idToBeUpdated) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		doConnection();
		Statement stmt=conn.createStatement();
		String query="select * from category where categoryId="+idToBeUpdated;
		ResultSet rs=stmt.executeQuery(query);
		Categories category=null;
		while(rs.next()) {
			int categoryId=rs.getInt("categoryId");
			String categoryName=rs.getString("category_Name");
			category=new Categories(categoryId, categoryName);
		}
		conn.close();
		return category;
	}
	
	public static boolean updateCategory(Categories category) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		doConnection();
		Statement stmt=conn.createStatement();
		String query="update category set categoryId="+category.getCategoryId()+",category_Name='"+category.getCategoryName()+"' where categoryId="+category.getCategoryId();
		System.out.println(query);
		int val=stmt.executeUpdate(query);
		return val>0;
	}
	
	public static boolean deleteCategory(int categoryId) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		doConnection();
		Statement stmt=conn.createStatement();
		String query="delete from category where categoryId="+categoryId;
		int val=stmt.executeUpdate(query);
		return val>0;
	}
	
	public static ArrayList<Products> searchProducts(Products searchProduct) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		ArrayList<Products> productsList=new ArrayList<Products>();
		doConnection();
		Statement stmt = conn.createStatement();
        StringBuilder query =new StringBuilder("select * from products where");
        Products product=new Products(searchProduct.getProductId(), searchProduct.getProductName(), searchProduct.getCategoryName(), searchProduct.getProductPrice());
        
        if(product.getProductId()!=0) {
        	query.append(" productId=").append(product.getProductId()).append(" and");
        }
        if(!product.getProductName().equals("")) {
        	query.append(" product_Name='").append(product.getProductName()).append("'").append(" and");
        }
        if(!product.getCategoryName().equals("")) {
        	query.append(" categoryID='").append(searchCategoryId(product.getCategoryName())).append("'").append(" and");
        }
        if(product.getProductPrice()!=0) {
        	query.append(" price=").append(product.getProductPrice()).append(" and");
        }
        String newQuery=query.toString();
        String finalQuery = null;
        if (newQuery.endsWith(" and")) {
            finalQuery = newQuery.substring(0, newQuery.length() - 4);
        }
        if (newQuery.endsWith(" where")) {
            finalQuery = newQuery.replace(" where", ";");
        }
        System.out.println("final ::"+finalQuery);
        ResultSet rs = stmt.executeQuery(finalQuery);
        Products searchedProduct;
        while(rs.next()) {
        	int productId=rs.getInt("productId");
        	String productName=rs.getString("product_Name");
        	String categoryName=searchCategoryName(rs.getInt("categoryID"));
        	int price=rs.getInt("price");
        	searchedProduct=new Products(productId,productName,categoryName,price);
        	productsList.add(searchedProduct);
        }
        conn.close();
		return productsList;
	}
	
	public static String searchCategoryName(int categoryId) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String categoryName="";
		doConnection();
		Statement stmt = conn.createStatement();
		String query="select category_Name from category where CategoryId="+categoryId;
		ResultSet rs= stmt.executeQuery(query);
		if(rs.next())
			categoryName=rs.getString("category_Name");
		conn.close();
		return categoryName;
	}

	public static Products editProduct(int productIdToBeUpdated) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		doConnection();
		Statement stmt=conn.createStatement();
		String query="select * from products where productId="+productIdToBeUpdated;
		ResultSet rs=stmt.executeQuery(query);
		Products product=null;
		while(rs.next()) {
			int productId=rs.getInt("productId");
			String productName=rs.getString("product_Name");
			String categoryName=searchCategoryName(rs.getInt("categoryId"));
			String description=rs.getString("description");
			int price=rs.getInt("price");
			product=new Products(productId, productName,categoryName,description,price);
		}
		conn.close();
		return product;
	}

	public static boolean updateProduct(Products updateProduct) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		doConnection();
		Statement stmt = conn.createStatement();
	    String query = "Update products set productId="+updateProduct.getProductId()+",product_Name='"+updateProduct.getProductName()+
	    		"',categoryId="+searchCategoryId(updateProduct.getCategoryName())+",description='"+updateProduct.getDescription()+"',price="+updateProduct.getProductPrice()+" where productId="+updateProduct.getProductId();
	    System.out.println(query);
	    int result=stmt.executeUpdate(query);
	    conn.close();
	    return result>0;
	}

	public static boolean deleteProduct(int productId) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		doConnection();
		Statement stmt=conn.createStatement();
		String query="delete from products where productId="+productId;
		int val=stmt.executeUpdate(query);
		return val>0;
	}

	public static ArrayList<ProductImages> searchImages() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		ArrayList<ProductImages> imageList=new ArrayList<ProductImages>();
		doConnection();
		Statement stmt=conn.createStatement();
		String query="select * from Images";
		ResultSet rs = stmt.executeQuery(query);
        ProductImages searchedImages;
        while(rs.next()) {
        	int imageId=rs.getInt("imageId");
        	String imageName=rs.getString("imageName");
        	String productName=rs.getString("productName");
        	searchedImages=new ProductImages(imageId,imageName,productName);
        	imageList.add(searchedImages);
        }
        conn.close();
		return imageList;
	}

	public static boolean deleteProductImage(int imageId) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		doConnection();
		Statement stmt=conn.createStatement();
		String query="delete from images where imageId="+imageId;
		int val=stmt.executeUpdate(query);
		return val>0;
	}

	public static ProductImages editProductImages(int imageIdToBeUpdated) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		doConnection();
		Statement stmt=conn.createStatement();
		String query="select * from images where imageId="+imageIdToBeUpdated;
		ResultSet rs=stmt.executeQuery(query);
		ProductImages productImage=null;
		while(rs.next()) {
			int imageId=rs.getInt("imageId");
			String productName=rs.getString("productName");
			String imageName=rs.getString("imageName");
			productImage=new ProductImages(imageId,imageName,productName);
		}
		conn.close();
		return productImage;
	}

	public static boolean updateProductImage(ProductImages productImage) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		doConnection();
		Statement stmt = conn.createStatement();
	    String query = "Update images set productId="+productImage.getProductId()+",productName='"+productImage.getProductName()+
	    	"',imageName='"+productImage.getImageName()+"',imagePath='"+productImage.getImagePath()+"' where imageId="+productImage.getImageId();
	    System.out.println(query);
	    int result=stmt.executeUpdate(query);
	    conn.close();
	    return result>0;
	}
}