package mz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mz.beans.Products;

public class ProductDAOImpl implements ProductDao {
	
	@Override
	public boolean addProduct(Products product) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection conn=DataSource.doConnection();
		String query = Common.ADDPRODUCT_QUERY;
		PreparedStatement stmt=conn.prepareStatement(query);
		stmt.setInt(1, product.getProductId());
		stmt.setString(2, product.getProductName());
		stmt.setInt(3, searchCategoryId(product.getCategoryName()));
		stmt.setString(4, product.getDescription());
		stmt.setInt(5, product.getProductPrice());
	     System.out.println(query);
	    int result=stmt.executeUpdate();

	    conn.close();
	    return result>0;
	}
	public static int searchCategoryId(String categoryName) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		int categoryId=0;
		System.out.println(categoryName);
		Connection conn=DataSource.doConnection();
		Statement stmt = conn.createStatement();
		String query="select categoryId from category where Category_Name='"+categoryName+"'";
		ResultSet rs= stmt.executeQuery(query);
		if(rs.next())
			categoryId=rs.getInt("categoryId");
		conn.close();
		return categoryId;
	}
	@Override
	public ArrayList<Products> searchProducts(Products searchProduct) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		ArrayList<Products> productsList=new ArrayList<Products>();
		Connection conn=DataSource.doConnection();
		Statement stmt = conn.createStatement();
        StringBuilder query =new StringBuilder(Common.SEARCH_PRODUCT_QUERY);
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
	
	@Override
	public Products editProduct(int productIdToBeUpdated) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateProduct(Products updateProduct) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProduct(int productId) {
		// TODO Auto-generated method stub
		return false;
	}
	public static String searchCategoryName(int categoryId) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String categoryName="";
		Connection conn=DataSource.doConnection();
		Statement stmt = conn.createStatement();
		String query="select category_Name from category where CategoryId="+categoryId;
		ResultSet rs= stmt.executeQuery(query);
		if(rs.next())
			categoryName=rs.getString("category_Name");
		conn.close();
		return categoryName;
	}
}
