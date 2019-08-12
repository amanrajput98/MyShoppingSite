package mz.dao;

public class Common {
	public static final String SELECT_QUERY="select * from";
	public static final String AND="and";
	public static final String COMMA=",";
	public static final String ADDPRODUCT_QUERY="insert into products(productId,product_Name,categoryId,description,price) values(?,?,?,?,?)";
	public static final String SEARCH_PRODUCT_QUERY="select * from products where";
}
