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

/**
 * Servlet implementation class AddCategoryServlet
 */
@WebServlet("/AddCategoryServlet")
public class AddCategoryServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public AddCategoryServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String catId=request.getParameter("categoryId");
		String categoryName=request.getParameter("categoryName");
		
		if(catId.equals("") || categoryName == null || categoryName.equals("")||!catId.matches("[0-9]+") || categoryName.matches("[0-9]+")){
			response.sendRedirect("CategoryNotAdded.jsp");
		}
			else {
			try {
				int categoryId=Integer.parseInt(catId);
				Categories category=new Categories(categoryId,categoryName);
				boolean check=DbService.addCategory(category);
				if(check) {			
					response.sendRedirect("CategorySuccessfullyAdded.jsp");
				}
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
				System.out.println(e);
				
				throw new ServletException("This CategoryId is already registered..");
			}catch(NumberFormatException ne) {
				throw new ServletException("Please Enter a Valid CategoryId");
			}
		}
	}

}
