<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>天气</title>
<link rel="stylesheet" href="/css/index.css" type="text/css" />

</head>
<body>

<h1>
Hello <%=request.getAttribute("username")+""%>!
</h1> 
<hr/>
<% java.util.List weather = (java.util.List)request.getAttribute("weather"); %>
<table border="1" cellpadding="20" cellspacing="0">
	<c:forEach items="${weather}" var="day">
    <tr>
			<td>日期</td>
			<td>${day.date}</td>
			<td>气温</td>
			<td>${day.temp}</td>
		</tr>
</c:forEach>
	
</table>
</body>
</html>
