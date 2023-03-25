<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%
 	String contextPath = request.getContextPath();
 %>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<ul class="navbar-nav me-auto">
		<li class="nav-item"><a class="nav-link" href="<%=contextPath %>/product/productlist.jsp">상품 목록</a></li>
		<li class="nav-item"><a class="nav-link" href="<%=contextPath %>/product/regist.jsp">상품 정보 등록</a></li>
	</ul>
</nav>