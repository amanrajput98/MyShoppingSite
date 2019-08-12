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
import mz.dbservice.DbService;

@WebServlet("/EditCategoryServlet")
public class EditCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public EditCategoryServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int categoryId=Integer.parseInt(request.getParameter("categoryId"));
		try {
			Categories category=DbService.editCategory(categoryId);
			request.setAttribute("categoryObj", category);
			RequestDispatcher rd=request.getRequestDispatcher("UpdateCategory.jsp");
			rd.forward(request, response);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
