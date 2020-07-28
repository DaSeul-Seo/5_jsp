<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산 결과</title>
</head>
<body>

<h3>계산 결과</h3>
	
	<%
		int a = Integer.parseInt(request.getParameter("a"));
		int b = Integer.parseInt(request.getParameter("b"));
		
		String oper = request.getParameter("oper");
	
		if(oper.equals("+")) {
			out.println(a + " + " + b + " = " + (a+b));
		}
		else if(oper.equals("-")) {
			out.println(a + " - " + b + " = " + (a-b));
		}
		else if(oper.equals("*")) {
			out.println(a + " * " + b + " = " + (a*b));
		}
		else if(oper.equals("/")) {
			out.println(a + " / " + b + " = " + (a/b));
		}
		
	
	%>
	<form action="calc_form.html" method="posd">
	<input type="submit" value = "돌아가기">
	</form>

</body>
</html>