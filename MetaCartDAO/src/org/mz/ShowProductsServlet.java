package org.mz;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mz.beans.Products;
import mz.dbservice.UsersDbService;


public class ShowProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ShowProductsServlet() {
        super();  
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categoryName=request.getParameter("categoryName");
			try {
				ArrayList<Products> productsList=UsersDbService.showProducts(categoryName);
				request.setAttribute("MetaCartProducts", productsList);
				RequestDispatcher rd= request.getRequestDispatcher("MetaCart.jsp");
				rd.forward(request, response);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

	}
}
