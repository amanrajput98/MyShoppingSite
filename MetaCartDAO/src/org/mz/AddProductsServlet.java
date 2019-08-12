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
import mz.dao.ProductDAOImpl;
import mz.dbservice.DbService;

@WebServlet("/AddProductsServlet")
public class AddProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public AddProductsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Id=request.getParameter("productId");
		String productName=request.getParameter("productName");
		String categoryName=request.getParameter("category");
		String description=request.getParameter("description");
		String price=request.getParameter("price");
		
		if(productName == null || productName.equals("")|| productName.matches("[0-9]+") ||
				categoryName.matches("[0-9]+") || !price.matches("[0-9]+") || description.matches("")){
			response.sendRedirect("ProductNotAdded.jsp");
		}else {
			try {
			int productId=Integer.parseInt(Id);
			int productPrice=Integer.parseInt(price);
			Products product=new Products(productId,productName,categoryName,description,productPrice);
			boolean check;
			ProductDAOImpl impl=new ProductDAOImpl();
				check = impl.addProduct(product);
				if(check) {
					response.sendRedirect("ProductSuccessfullyAdded.jsp");
				}
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException  e) {
				e.printStackTrace();
			}catch(SQLIntegrityConstraintViolationException ex) {
				throw new ServletException("This ProductId is already registered or Please Enter the Valid Category Name..");
			}catch(NumberFormatException ne) {
				throw new ServletException("Please Enter a Valid ProductId");
			} catch (SQLException e) {
				System.out.println(e);
				e.printStackTrace();
				throw new ServletException("Error..");
			}
		}
	}
}
