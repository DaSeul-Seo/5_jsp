<%@page import="org.comstudy21.dto.Person"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<h1>User List</h1>
<hr>
<%
	ArrayList<Person> pList = (ArrayList<Person>)request.getAttribute("p_List");%>
	<table border="1px" style="border-collapse: collapse;">
	<tr>
	<th>이름</th><th>주소</th><th>나이</th></tr>
	<%for(int i = 0; i<pList.size(); i++){%>
	<tr>
		<td>
		<%out.println(pList.get(i).getUserName()); %>
		</td>
		<td>
		<%out.println(pList.get(i).getUserAddr()); %>
		</td>
		<td>
		<%out.println(pList.get(i).getAge());%>
		</td>
	</tr>
	<%
	}
	%>
</table>

</body>
</html>