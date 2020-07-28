<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<h1>Shopping Cart</h1>
<hr>
<ul>
	<li><a href="car/list.do">Car List</a></li>
	<li><a href="car/cart.do">Cart</a></li>
</ul>
<hr>
<form action="car/input.do" method="POST">
차종 : <input type="text" name="name"/>
<input type="submit" value="send" />
</form>

</body>
</html>