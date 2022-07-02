
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	String Id= request.getParameter("id");
	String Name = request.getParameter("name");
	String Price = request.getParameter("price");
	
	out.print("Product ID: "+Id);
	out.print("Product Name: "+Name);
	out.print("Product Price: "+Price);
	

%>
<a href="index.jsp">Home Page</a>

</body>
</html>