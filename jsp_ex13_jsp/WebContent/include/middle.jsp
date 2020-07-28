<%@page import="org.comstudy21.LeftItem"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 센터 -->
<div id="middle">
	<div class="left">
		<p>LEFT MENU</p>
		<ul>
		<%
		if(request.getAttribute("leftItems") != null){
			ArrayList<LeftItem> items = (ArrayList<LeftItem>)request.getAttribute("leftItems");
			for(LeftItem item : items){
				out.println(item.getTag());
			}
		}
		%>
		</ul>
	</div>
	<div class="main">
		<h3>MAIN</h3>
		<hr />
		<%
		// 지역변수
		// String subPage = request.getParameter("page");
		String subPage = "/include/jsp/home.jsp";
		%>
				
		<!-- out.println(request.getParameter("page")); -->
		<%
		if(request.getParameter("page") != null){
			subPage = request.getParameter("page");
			subPage = "/include/jsp/" + subPage.trim() + ".jsp";
		}
		%>
		
		<!-- 액션 태그를 사용하면 변수와 함께 쓸 수 있다 -->
		<!-- 소스 자체가 들어온다. -->
		<jsp:include page="<%=subPage %>"></jsp:include>
	
	</div>
</div>