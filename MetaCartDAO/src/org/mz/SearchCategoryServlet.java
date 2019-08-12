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

import mz.beans.Categories;
import mz.dbservice.DbService;

@WebServlet("/SearchCategoryServlet")
public class SearchCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchCategoryServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String catId=request.getParameter("categoryId");
		String categoryName=request.getParameter("categoryName");
		int categoryId=0;
		if(!catId.equals("") || !catId.isEmpty())
			categoryId=Integer.parseInt(catId);
			try {
				Categories category=new Categories(categoryId,categoryName);
				ArrayList<Categories> categoriesList=DbService.serachCategory(category);
				request.setAttribute("list",categoriesList); 
				RequestDispatcher rd=request.getRequestDispatcher("SearchedCategory.jsp");
				rd.forward(request,response);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
				System.out.println(e);
			}
		}
}
