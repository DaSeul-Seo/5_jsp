<%@page import="java.sql.Timestamp"%>
<%@page import="test.web.model.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
	<tr>
		<th>No</th>
		<th>Author</th>
		<th>E-mail</th>
		<th>Title</th>
		<th>WriteDate</th>
	</tr>
	<%
	if(request.getAttribute("list") != null){
		ArrayList<BoardDto> list = (ArrayList<BoardDto>)request.getAttribute("list");
		for(int i = 0; i<list.size(); i++){
			BoardDto data = list.get(i);
			String num = data.getNum()+"";
			String author = data.getAuthor();
			String email = data.getEmail();
			String title = data.getTitle();
			Timestamp writeday = data.getWriteday();
	%>
	
	<tr>
		<td><%=num %></td>
		<td><%=author %></td>
		<td><%=email %></td>
		<td><a href="<%=request.getContextPath()%>/board?action=detail.ui&num=<%=num%>"><%=title %></a></td>
		<td><%=writeday %></td>
	</tr>
	
	<%
		} // end for
	} // end if
	%>
</table>

<a href="<%=request.getContextPath()%>/board?action=write.ui">Write</a>

</body>
</html>