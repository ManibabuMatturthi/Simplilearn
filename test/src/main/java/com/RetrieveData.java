package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

/**
 * Servlet implementation class RetrieveData
 */

@WebServlet("/retrieveData")
public class RetrieveData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		PrintWriter out = response.getWriter();
		out.print("<h3>Data Retrieval Processing....</h3>");

		StandardServiceRegistry reg = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

		Metadata metadata = new MetadataSources(reg).getMetadataBuilder().build();

		SessionFactory factory = metadata.getSessionFactoryBuilder().build();

		Session session = factory.openSession();

		Transaction t = session.beginTransaction();

		response.setContentType("text/html");

		List<Eproduct> list = session.createQuery("from Eproduct").list();
		 
		
			out.println("<html><body>");
			out.println("<b>Product Listing</b><br>");
			out.println("<b><Table colspan='2'  border = '1 px'>");
			out.println("<b><tr style='background-color:#00FF00'><th>ID:</th><th>Name:</th><th>Price:</th></tr>");
			
			for (Eproduct p : list) {
				out.println("<tr><td>" + String.valueOf(p.getPid()) + "</td> <td> " + p.getPname() + "</td><td> "
						+ String.valueOf(p.getPrice())+"</td></tr>");

				
				//out.println("<hr>");
			}
			

			out.println("</table></body></html>");
			
			t.commit();
			session.close();
			
			out.print("<br><br><a href='index.jsp'>Back to Home </a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
