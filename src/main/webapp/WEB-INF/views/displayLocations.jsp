<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Locations:</h2>
<table>
<tr>
<th>id</th>
<th>code</th>
<th>name</th>
<th>type</th>
</tr>

<c:forEach items="${LocationList}" var="location">
<tr>
<td>${location.id}</td>
<td>${location.code}</td>
<td>${location.name}</td>
<td>${location.type}</td>
<td><a href="deleteLocation?id=${location.id}">dalete</a></td>
<td><a href="updateLocation?id=${location.id}">update</a></td>
</c:forEach>
</table>
<a href="generateReport">Report</a>
<a href="createLocation">CreateLocation</a>
</body>
</html>