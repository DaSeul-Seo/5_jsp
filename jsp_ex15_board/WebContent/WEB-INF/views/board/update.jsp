<%@page import="test.web.model.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- <script language="javascript">
	window.onload = function(){
		let form = document.forms[0];
		form.onsubmin = function(){
			event.preventDefault();
			
			if(this.author.value==""){
				alert("Please write Author(Necessary)");
				this.author.focus();
				return;
			}
			if(this.title.value==""){
				alert("Please write Title(Necessary)");
				this.title.focus();
				return;
			}
			this.submit();
		}
	}
</script> -->
</head>
<body>

<h1>정보 수정</h1>
<hr />

<%
if(request.getAttribute("updatelist") != null){
	ArrayList<BoardDto>updatelist = (ArrayList<BoardDto>)request.getAttribute("updatelist");
	for(int i = 0; i<updatelist.size(); i++){
		BoardDto data = updatelist.get(i);
		String num = data.getNum()+"";
		String author = data.getAuthor();
		String email = data.getEmail();
		String title = data.getTitle();
		String content = data.getContent();
		String passwd = data.getPasswd();
%>

<form action="<%=request.getContextPath()%>/board?action=update.do" name="update" method="POST">
	<table>
		<tr>
			<th>NO</th>
			<td></td>
		</tr>
		<tr>
			<th width="100" align="right">*Author:&nbsp;</th>
			<td><input type="text" size="20" maxlength="100" name="author"/><%=author %></td>
		</tr>
		<tr>
			<th width="100" align="right">E-mail:&nbsp;</th>
			<td><input type="text" size="30" maxlength="200" name="email"/><%=email %></td>
		</tr>
		<tr>
			<th width="100" align="right">*Title:&nbsp;</th>
			<td><input type="text" size="67" maxlength="500" name="title"/><%=title %></td>
		</tr>
		<tr>
			<th width="100" align="right">Content:&nbsp;</th>
			<td><textarea name="content" cols="65" rows="10" maxlength="4000"><%=content %></textarea></td>
		</tr>
		<tr>
			<th width="100" align="right">Passwd:&nbsp;</th>
			<td><input type="password" size="10" maxlength="12" name="passwd"/><%=passwd %></td>
			<!-- <td>&nbsp;(글 수정/삭제 시 필요합니다.)</td> -->
		</tr>
		
	<%
		} // end for
	} // end if
	%>
</table>
	
<a href="<%=request.getContextPath()%>/board?action=update.do">Update</a>
</form>

</body>
</html>