package mz.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import mz.beans.Products;

public interface ProductDao {
	public abstract boolean addProduct(Products product) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public abstract ArrayList<Products> searchProducts(Products searchProduct) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException ;
	public abstract Products editProduct(int productIdToBeUpdated) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException ;
	public abstract boolean updateProduct(Products updateProduct) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException ;
	public abstract boolean deleteProduct(int productId)  throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException ;
}
