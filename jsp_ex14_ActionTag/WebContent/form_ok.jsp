<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p>Welcome!</p>
	<%
	/* 요청 하는 쪽에서 CharacterEncoding 해준 후 넘겨 주어야 한다. */
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("userName");
		if (name.length() == 0) {
			// 입력 값이 0이면 (내용이 없다면) form.jsp를 다시 보여준다.
			String msg = "성명을 입력 후 로그인을 재시도 하세요.";
	%>
	<%
	// parameter 값을 넘겨주는 경우
	%>
	<jsp:forward page="form.jsp">
		<jsp:param value="<%=msg %>" name="msg"></jsp:param>
	</jsp:forward>
	<%
		}
	%>
	Hello
	<%=name%>

</body>
</html>