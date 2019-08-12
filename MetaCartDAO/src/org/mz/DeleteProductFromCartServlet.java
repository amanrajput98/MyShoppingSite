package org.mz;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mz.beans.Products;

@WebServlet("/DeleteProductFromCartServlet")
public class DeleteProductFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeleteProductFromCartServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int indexPos=Integer.parseInt(request.getParameter("indexPos"));
		HttpSession session=request.getSession();
		ArrayList<Products> productList=(ArrayList)(session.getAttribute("productList"));
		productList.remove(indexPos);
		response.sendRedirect("Cart.jsp");
	}
}
