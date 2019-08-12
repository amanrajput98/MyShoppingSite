package org.mz;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mz.beans.Products;
import mz.dbservice.DbService;

@WebServlet("/EditPorductServlet")
public class EditPorductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public EditPorductServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId=Integer.parseInt(request.getParameter("productId"));
		Products product;
		try {
			product = DbService.editProduct(productId);
			request.setAttribute("productObj", product);
			RequestDispatcher rd=request.getRequestDispatcher("UpdateProduct.jsp");
			rd.forward(request, response);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
