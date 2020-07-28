<%@page import="org.comstudy21.model.Product"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Cart</h2>
<hr />
<%
if(session.getAttribute("cartList") != null){
	HashSet<Product> cartList = (HashSet<Product>)session.getAttribute("cartList");
	if(cartList.size() >0){	
	Iterator iter = cartList.iterator();
	while(iter.hasNext()){
		Product p = (Product)iter.next();
		out.println
		("<p>"+p+"<a href="+request.getContextPath()+"/shop/cart_remove.do?idx="+p.getIdx()+">&nbsp;[Remove]</a></p>");
		}
	} else{
		out.println("<h2>Cart NULL</h2>");
	}
} else{
	out.println("<h2>Cart NULL</h2>");
} // end of if
%>

<br>
<a href="<%=request.getContextPath()%>/shop/home.do">HOME</a>
<a href="<%=request.getContextPath()%>/shop/list.do">Car List</a>

</body>
</html>