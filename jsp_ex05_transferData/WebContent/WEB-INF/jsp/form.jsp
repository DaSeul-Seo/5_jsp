<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
label{
	display : inline-block;
	width: 120px;
}
form div{
	margin-left: 116px;
	margin-top: -20px;
}
form{width: 400px;}
</style>
</head>
<body>

<h1>정보입력</h1>
<hr>
<form method="POST" action="form.do">
<fieldset>
	<legend>서버에 전달할 데이터</legend>
	<label for="id">아이디</label><input type="text" id="id" name="id"><br>
	<label for="passwd">비밀번호</label><input type="password" id="passwd" name="passwd"><br>
	<label for="interest">관심분야</label>
		<div>
		<input type="checkbox" name="interest" value="JAVA">JAVA<br>
		<input type="checkbox" name="interest" value="JavaScript">JavaScript<br>
		<input type="checkbox" name="interest" value="jQuery">jQuery<br>
		<input type="checkbox" name="interest" value="JSP">JSP<br>
		<input type="checkbox" name="interest" value="Android">Android<br>
		</div>
	<hr>
	<input type="submit" value="전송하기">
</fieldset>
</form>
</body>
</html>