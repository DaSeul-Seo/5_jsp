<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Hello JSP World</h1>
<%
out.println("<p>Greetings</p>");

// 실제경로  : request.getRealPath
// this : class로 바뀐 파일
// service 메소드로 적용
String path = request.getRealPath(this.getClass().getName().toString());
out.println(path);
%>

</body>
</html>