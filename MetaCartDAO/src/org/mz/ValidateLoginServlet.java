package org.mz;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ValidateLoginServlet
 */
@WebServlet("/ValidateLoginServlet")
public class ValidateLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ValidateLoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailId=request.getParameter("email");
		String password=request.getParameter("password");
		
		if(emailId.equals("amanrajput9819@gmail.com")&& password.equals("metazone")) {
			HttpSession session=request.getSession();
			System.out.println(session.isNew()+">>>>+");
			session.setAttribute("email", emailId);
			response.sendRedirect("ValidLogin.jsp");
		}else {
			response.sendRedirect("InvalidLogin.jsp");
		}
	}
}
