<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>data.jsp</title>
</head>
<body>
	
	<h3>data.jsp 페이지에서 결과 확인</h3>
	<%
	/*스크립트릿 - JSP 문서 안에 java 소스코드 작성*/
	String user = request.getParameter("user");
	String message = request.getParameter("message");
	
	// system.out.println() 으로 출력하면 console에 출력된다.
	// out.println() 으로 출력하면 브라우저 화면에 출력된다.
	out.println("user : " + user + "<br>");
	out.println("message : " + message);
	%>
	
</body>
</html>