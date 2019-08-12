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

@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddToCartServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productName=request.getParameter("productName").trim();
		int price=Integer.parseInt(request.getParameter("price").trim());
		int quantity=Integer.parseInt(request.getParameter("quantity").trim());
		Products product=new Products(productName, price, quantity);
		HttpSession session=request.getSession();
		System.out.println(session.isNew()+">???>");
		ArrayList<Products> productsListToCart=(ArrayList<Products>) session.getAttribute("productList");
		if(productsListToCart==null) {
			productsListToCart=new ArrayList<Products>();
			session.setAttribute("productList", productsListToCart);
		}
		productsListToCart.add(product);
		response.sendRedirect("Cart.jsp");
	}
}
