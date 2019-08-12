package org.mz;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mz.beans.Products;
import mz.dbservice.DbService;

@WebServlet("/SearchPorductServlet")
public class SearchPorductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchPorductServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("productId");
		String productName=request.getParameter("productName");
		String categoryName=request.getParameter("category"); 
		String price=request.getParameter("price");
		int productId=0;
		int productPrice=0;
		
		if(!id.equals("")||!id.isEmpty())
			productId=Integer.parseInt(id);
		else if(!price.equals("")||!price.isEmpty())
			productPrice=Integer.parseInt(price);
		
		Products searchProduct=new Products(productId, productName, categoryName, productPrice);
		ArrayList<Products> productsList;
		try {
			productsList = DbService.searchProducts(searchProduct);
			request.setAttribute("productlist",productsList); 
			RequestDispatcher rd=request.getRequestDispatcher("SearchedProducts.jsp");
			rd.forward(request,response);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
}
