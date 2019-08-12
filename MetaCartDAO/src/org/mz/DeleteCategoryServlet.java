package org.mz;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mz.dbservice.DbService;

@WebServlet("/DeleteCategoryServlet")
public class DeleteCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteCategoryServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int categoryId=Integer.parseInt(request.getParameter("categoryId"));
		String space="";
		try {
			boolean check=DbService.deleteCategory(categoryId);
			if(check)
				response.sendRedirect("SearchCategory.do?categoryId=&categoryName="+space);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLIntegrityConstraintViolationException e) {
			throw new ServletException("Cannot delete this category First delete the corresponding Products..");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
