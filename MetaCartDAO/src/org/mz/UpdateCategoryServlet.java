package org.mz;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mz.beans.Categories;
import mz.dbservice.DbService;

@WebServlet("/UpdateCategoryServlet")
public class UpdateCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateCategoryServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String catId=request.getParameter("categoryId");
		String categoryName=request.getParameter("categoryName");
		if(catId.equals("") || categoryName == null || categoryName.equals("")||!catId.matches("[0-9]+") || categoryName.matches("[0-9]+")){
			throw new ServletException("Please Enter the Valid credentials");
		}else {
			int categoryId=Integer.parseInt(catId);
			Categories category=new Categories(categoryId, categoryName);
			boolean check;
			try {
				check = DbService.updateCategory(category);
				System.out.println(check);
				if(check) {
					response.sendRedirect("CategorySuccessfullyUpdated.jsp");
				}
			}
			catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
