package org.mz;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mz.dbservice.DbService;

@WebServlet("/DeleteImagesServlet")
public class DeleteImagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteImagesServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int imageId=Integer.parseInt(request.getParameter("imageId"));
		boolean isDeleted;
		try {
			isDeleted = DbService.deleteProductImage(imageId);	
			if(isDeleted)
				response.sendRedirect("CustomizeImage.do");
			else
				throw new ServletException("Image can't be Deleted...");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
