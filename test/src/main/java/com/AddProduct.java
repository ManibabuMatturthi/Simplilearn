package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

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

@WebServlet("/addData")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		
			String name = request.getParameter("pname");
			String price = request.getParameter("price");

			out.print("<h3>Product Validation is going on...</h3>");

			BigDecimal p = new BigDecimal(price);
			out.print(name + price);

			StandardServiceRegistry reg = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

			Metadata metadata = new MetadataSources(reg).getMetadataBuilder().build();

			SessionFactory factory = metadata.getSessionFactoryBuilder().build();

			Session session = factory.openSession();

			Transaction t = session.beginTransaction();

			session.save(new Eproduct(name, p));

			t.commit();

			out.print("<a href='index.jsp'>Click to add another product</a>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
