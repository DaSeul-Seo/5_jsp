<%@page import="org.comstudy21.SaramBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
ArrayList<SaramBean> list = new ArrayList<>();
list.add(new SaramBean(0, "hong", "010-1111-1111"));
list.add(new SaramBean(1, "kim", "010-2222-2222"));
list.add(new SaramBean(2, "lee", "010-3333-3333"));
list.add(new SaramBean(3, "park", "010-4444-4444"));
request.setAttribute("list", list);
%>

<!-- JSTL의 forEach 태그를 이용해서 list 목록을 출력 -->

<c:forEach var="list" items="${list }">
	<p>
	no : <c:out value="${list.no }"></c:out><br>
	name : <c:out value="${list.name }"></c:out><br>
	email : <c:out value="${list.email }"></c:out><br>
	</p>
</c:forEach>

</body>
</html>
