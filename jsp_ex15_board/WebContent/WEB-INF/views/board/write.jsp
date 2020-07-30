<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language="javascript">
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
</script>
</head>
<body>

<form action="<%=request.getContextPath()%>/board?action=write.do" method="POST">
	<table>
		<tr>
			<th width="100" align="right">*Author:&nbsp;</th>
			<td><input type="text" size="20" maxlength="100" name="author" /></td>
		</tr>
		<tr>
			<th width="100" align="right">E-mail:&nbsp;</th>
			<td><input type="text" size="30" maxlength="200" name="email"/></td>
		</tr>
		<tr>
			<th width="100" align="right">*Title:&nbsp;</th>
			<td><input type="text" size="67" maxlength="500" name="title"/></td>
		</tr>
		<tr>
			<th width="100" align="right">Content:&nbsp;</th>
			<td><textarea name="content" cols="65" rows="10" maxlength="4000"></textarea></td>
		</tr>
		<tr>
			<th width="100" align="right">Passwd:&nbsp;</th>
			<td><input type="password" size="10" maxlength="12" name="passwd"/></td>
			<!-- <td>&nbsp;(글 수정/삭제 시 필요합니다.)</td> -->
		</tr>
		<tr>
			<th>&nbsp;</th>
			<td><input type="submit" value="Write" />
				<a href="<%=request.getContextPath()%>/board?action=write.do">List</a>
			</td>
		</tr>
	</table>
</form>

</body>
</html>













