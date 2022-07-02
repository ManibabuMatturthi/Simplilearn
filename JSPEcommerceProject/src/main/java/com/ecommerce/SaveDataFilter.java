package com.ecommerce;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;



/**
 * Servlet Filter implementation class SaveDataFilter
 */
//@WebFilter("/save")
public class SaveDataFilter extends HttpFilter implements Filter {
   
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("This is Filter");
		
		String id = request.getParameter("id");
		String name= request.getParameter("name");
		String  price = request.getParameter("price");
		try {
			
	
		if(id==null|| name ==null||price==null) {
			PrintWriter out= response.getWriter();
			out.print("<h3>Please fill all the details</h3>");
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request,response);
		}
		
		
	}catch (Exception e){
		
		PrintWriter out = response.getWriter();
		
		out.print("<a href=\"index.jsp\">Home Page</a>");
		
	}
		chain.doFilter(request, response);
	}
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
