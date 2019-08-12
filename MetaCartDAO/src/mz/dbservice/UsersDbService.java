package mz.dbservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mz.beans.Products;

public class UsersDbService {
	
	private static Connection conn=null;
	
	public static void doConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/MetaCart", "root", "ajjumudit");
	} 
	
	public static ArrayList<Products> showProducts(String category) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
	doConnection();
	ArrayList<Products> productsList=new ArrayList<Products>();
	Statement stmt = conn.createStatement();
	int categoryId=DbService.searchCategoryId(category);
    String query ="select * from products where categoryId="+categoryId;
    ResultSet rs = stmt.executeQuery(query);
    Products product;
    while(rs.next()) {
    	int productId=rs.getInt("productId");
    	String productName=rs.getString("product_Name");
    	String categoryName = DbService.searchCategoryName(rs.getInt("categoryID"));
    	String description=rs.getString("description");
    	int price=rs.getInt("price");
    	product=new Products(productId,productName,categoryName,description,price);
    	productsList.add(product);
    }  
    conn.close();
    return productsList;
	}
	 
	public static String getImages(String productName) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		doConnection();
		Statement stmt = conn.createStatement();
		String query="select imageName from images where productName='"+productName+"'";
		ResultSet rs=stmt.executeQuery(query);
		String imageName="";
		if(rs.next()) {
			imageName=rs.getString("imageName");
		}
		conn.close();
		return imageName;
	}
	public static Products getProduct(int productId) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		doConnection();
		Statement stmt=conn.createStatement();
		String query="Select * from Products where productId="+productId;
		ResultSet rs=stmt.executeQuery(query);
		Products product=null;
		if(rs.next()) {
			String productName=rs.getString("product_Name");
			String description=rs.getString("description");
			int price=rs.getInt("price");
			product=new Products(productName,description,price);
		}
		return product;
	}
}
