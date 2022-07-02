package com.ecommerce;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.product.Eproduct;

/**
 * Servlet implementation class SaveData
 */
@WebServlet("/save")
public class SaveData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		String name = request.getParameter("name");
		
		String price = request.getParameter("price");
		
		if(id!=null&&name!=null&&price!=null) {
		
		BigDecimal pric= new BigDecimal(price);
			
		Integer ids = new Integer(id);
		
		Eproduct ep = new Eproduct();
		
		ep.setId(ids);
		ep.setName(name);
		ep.setPrice(pric);
		
		
		RequestDispatcher view = request.getRequestDispatcher("display.jsp");
		
		view.forward(request,response);}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request,response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
