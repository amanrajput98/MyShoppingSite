package org.mz;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mz.beans.Products;
import mz.dbservice.DbService;

@WebServlet("/UpdatePorductServlet")
public class UpdatePorductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdatePorductServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String proId=request.getParameter("productId");
		String productName=request.getParameter("productName");
		String categoryName=request.getParameter("categoryName");
		String description=request.getParameter("description");
		String price=request.getParameter("price");

		if(productName == null || productName.equals("")|| productName.matches("[0-9]+") ||
				categoryName.matches("[0-9]+") || !price.matches("[0-9]+") || description.matches("")){
			throw new ServletException("Please Enter the Valid credentials");
		}else {
			try {
			int productId=Integer.parseInt(proId);
			int productPrice=Integer.parseInt(price);
			Products product=new Products(productId, productName, categoryName, description, productPrice);
			boolean check = DbService.updateProduct(product);
				System.out.println(check);
				if(check) {
					response.sendRedirect("ProductSuccessfullyUpdated.jsp");
				}
			} catch(SQLIntegrityConstraintViolationException e) {
				throw new ServletException("Please Enter the Valid Category Name..");
			}
			catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
