<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
div, header, footer{
	border: 0px solid gray;
	border-radius: 10px;
}
#page{
	width: 1000px;
	margin: 0 auto;
}
div.left, div.main{
	height: 400px;
	float: left;
}
div.left{
	width: 200px;
	background-color: #aaa;
}
div.main{
	width: 790px;
	background-color: #aaa;
	margin-left: 10px;	
	/* padding: 10px; */
}
#menu{
	background-color: #aaa;
	margin: 5px 0;
	text-align: center;
	padding: 10px;
}
</style>
</head>
<body>

<div id="page">
	<!-- 가운데 정렬은 margin: 0 auto;-->
	
	<!--header include : start -->
	<%-- <%@ include file="/include/header.jsp" %> --%>
	<jsp:include page="/include/header.jsp"></jsp:include>
	<!--header include : end -->
	
	<!-- 센터 -->
	<!--middle include : start -->
	<%-- <%@ include file="/include/middle.jsp" %> --%>
	<jsp:include page="/include/middle.jsp"></jsp:include>
	<!--middle include : end -->

	<!-- 하단 -->
	<!--footer include : start -->
	<%-- <%@ include file="/include/footer.jsp" %> --%>
	<jsp:include page="/include/footer.jsp"></jsp:include>
	<!--footer include : end -->
</div>

</body>
</html>