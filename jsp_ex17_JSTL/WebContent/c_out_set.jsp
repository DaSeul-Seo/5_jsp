<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="m" class="org.comstudy21.SaramBean"></jsp:useBean>
<jsp:setProperty property="name" name="m" value="hong"/>
<c:set var="str" value="kim"></c:set>
<c:remove var="m"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>사람 정보 관리</h1>
<hr />

<c:if test="${m.name == null}">
	<p>NONE Name</p>
</c:if>
<c:if test="${m.name != null }">
<p>Name : <c:out value="${m.name }"></c:out></p>
</c:if>

<%
request.setAttribute("message", "Hello jsp world");
%>

<p>Message : <c:out value="${message }"></c:out></p>
<p>str : <c:out value="${str }"></c:out></p>

</body>
</html>
