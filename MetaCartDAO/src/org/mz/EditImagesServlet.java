package org.mz;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mz.beans.Categories;
import mz.beans.ProductImages;
import mz.dbservice.DbService;

@WebServlet("/EditImagesServlet")
public class EditImagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditImagesServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int imageId=Integer.parseInt(request.getParameter("imageId"));
		try {
			ProductImages productImage=DbService.editProductImages(imageId);
			request.setAttribute("ImageObject", productImage);
			RequestDispatcher rd=request.getRequestDispatcher("UpdateProductImage.jsp");
			rd.forward(request, response);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
