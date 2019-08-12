package org.mz;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import mz.beans.ProductImages;
import mz.dbservice.DbService;

@WebServlet("/UploadImagesServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
		maxFileSize = 1024 * 1024 * 10,
		maxRequestSize = 1024 * 1024 * 50)

public class UploadImagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UploadImagesServlet() { 
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String productName=request.getParameter("productName").trim();
		String image=request.getParameter("image");
			try {
				int productId;
				Part part=request.getPart("image");
				System.out.println(part);
				String fileName=extractFileName(part);
				System.out.println(fileName);
				String savePath="Z:\\Jsp_Servlet\\MetaCart\\WebContent\\Images"+File.separator+fileName;
				File fileSaveDir=new File(savePath);
				part.write(savePath+File.separator);
				productId = DbService.getProductId(productName);
				ProductImages productImage=new ProductImages(productId,productName,fileName,savePath);
				boolean check=DbService.uploadImage(productImage);
				if(check)
					response.sendRedirect("ImageSuccessfullyAdded.jsp");
			} catch(SQLIntegrityConstraintViolationException e) {
				throw new ServletException("No product Found.."+productName);
			}
			catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
	}
	
	private String extractFileName(Part part) {
		String contentDisp=part.getHeader("content-disposition");
		String items[]=contentDisp.split(";");
		for(String s : items) {
			if(s.trim().startsWith("filename"))
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
		}
		return "";
	}
}
