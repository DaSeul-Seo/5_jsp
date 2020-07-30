<%@page import="java.sql.*"%>
<%@page import="test.web.model.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Detail Page</h1>
<hr />

<%
if(request.getAttribute("detaillist") != null){
	ArrayList<BoardDto> detaillist = (ArrayList<BoardDto>)request.getAttribute("detaillist");
	for(int i = 0; i<detaillist.size(); i++){
		BoardDto data = detaillist.get(i);
		String num = data.getNum()+"";
		String author = data.getAuthor();
		String email = data.getEmail();
		String title = data.getTitle();
		String content = data.getContent();
		String passwd = data.getPasswd();
		Timestamp writeday = data.getWriteday();
%>

<form action="<%=request.getContextPath()%>/board?action=list" method="POST">
<table border="1">
	<tr>
		<th>No</th>
		<th><%=num %></th>
	</tr>
	<tr>
		<th width="100" align="right">Author:&nbsp;</th>
		<td><%=author %></td>
	</tr>
	<tr>
		<th width="100" align="right">E-mail:&nbsp;</th>
		<td><%=email %></td>
	</tr>
	<tr>
		<th width="100" align="right">Title:&nbsp;</th>
		<td><%=title %></td>
	</tr>
	<tr>
		<th width="100" align="right">Content:&nbsp;</th>
		<td><%=content %></td>
	</tr>
	<tr>
		<th width="100" align="right">Passwd:&nbsp;</th>
		<td><%=passwd %></td>
		<!-- <td>&nbsp;(글 수정/삭제 시 필요합니다.)</td> -->
	</tr>
	
	<%
		} // end for
	} // end if
	%>
	
</table>
	<a href="<%=request.getContextPath()%>/board?action=list">List</a>	
	<a href="<%=request.getContextPath()%>/board?action=update.ui">Update</a>
	<a href="<%=request.getContextPath()%>/board?action=delete.do">Delete</a>
</form>


</body>
</html>