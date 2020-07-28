<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style>
label{
	display: inline-block;
	width: 200px;
}
</style>
</head>
<body>
<%
if(session.getAttribute("login.id") != null){
	out.println("<h3>이미 로그인 중입니다</h3>");
	out.println("<a href=logout.do>Logout</a>");	
}else{
	// 사용자가 막아놔도 가능
	String url = response.encodeURL("login.do");
%>
<h1>Login</h1>
<hr>
<form action="<%=url%>" method="POST">
	<input type="hidden" name="address" value="seoul"/>
	<input type="hidden" name="email" value="kim@korea.com"/>
	<input type="hidden" name="tel" value="010-1111-1111"/>
	<fieldset>
	<legend>Login</legend>
	<label for="userId">USER ID</label>
	<input type="text" name="userId" id="userId" value="kim"/><br>
	<label for="passwd">비밀번호</label>
	<input type="text" name="passwd" id="passwd" value="1111"/><br>
	<input type="submit" value="login" />
	</fieldset>
</form>
<%
}
%>

</body>
</html>