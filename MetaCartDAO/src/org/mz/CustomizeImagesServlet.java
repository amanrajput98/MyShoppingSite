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
import mz.beans.ProductImages;
import mz.dbservice.DbService;

@WebServlet("/CustomizeImagesServlet")
public class CustomizeImagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public CustomizeImagesServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<ProductImages> imageList=DbService.searchImages();
			request.setAttribute("productImageList",imageList);
			RequestDispatcher rd=request.getRequestDispatcher("CustomizeProductImages.jsp");
			rd.forward(request, response);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
