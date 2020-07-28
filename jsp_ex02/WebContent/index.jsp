<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
// 선언부: 멤버필드 선언 부분
public String userName = "길동이";
public void sayHello(){
	System.out.println("Hello world");
}
%>
<%
// 스크립트 릿 : _service() 함수의 내부
sayHello(); // 함수 호출
%>
<%--JSP 주석문
표현식: <%= (변수나 데이터) %>
--%>
<h1><%=userName %>의 홈페이지</h1>
<hr>
<ul>
	<li><a href="hello.do">HelloServlet 요청</a></li>
	<%--a안에서는 /를 쓰면 안된다.
	web.xml에서만 가능 --%>
</ul>
</body>
</html>
