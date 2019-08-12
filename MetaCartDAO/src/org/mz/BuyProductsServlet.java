package org.mz;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/BuyProductsServlet")
public class BuyProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BuyProductsServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.removeAttribute("productList");
		session.invalidate();
		response.sendRedirect("Buy.jsp");
	}
}
