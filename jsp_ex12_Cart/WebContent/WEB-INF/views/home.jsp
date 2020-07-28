<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Car Shopping Mall</h1>
	<hr>
	<ul>
		<li><a href="<%=request.getContextPath() %>/shop/list.do">Car List</a></li>
		<li><a href="<%=request.getContextPath() %>/shop/cart.do">Cart</a></li>
		<li><a href="<%=request.getContextPath() %>/bbs/list.do">Service Center</a></li>
		<li><a href="<%=request.getContextPath() %>/bbs/board.do">Community</a></li>
	</ul>

</body>
</html>