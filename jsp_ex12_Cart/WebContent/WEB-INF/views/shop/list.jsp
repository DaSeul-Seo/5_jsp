<%@page import="org.comstudy21.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Car List</h2>
<hr>
<%
if(request.getAttribute("pList") != null){
	ArrayList<Product> pList = (ArrayList<Product>)request.getAttribute("pList");
	for(int i = 0; i<pList.size(); i++){
		Product p = pList.get(i);
%>
	<p><%=p.getIdx()%> | 
	<a href="<%=request.getContextPath()%>/shop/detail.do?idx=<%=p.getIdx()%>">
	<%=p.getTitle()%></a> | 
	<%=p.getPrice()%> | 
	<a href="<%=request.getContextPath()%>/shop/cart.do?idx=<%=p.getIdx()%>">Cart</a></p>
<%
	} // end of for
} else{
	out.println("<h2>Product NULL</h2>");
} // end of id
%>

<hr>
<a href="<%=request.getContextPath()%>/shop/home.do">HOME</a>
<a href="<%=request.getContextPath()%>/shop/cart.do">Cart</a>

</body>
</html>