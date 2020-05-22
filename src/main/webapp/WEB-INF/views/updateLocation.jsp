<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Location</title>
</head>
<body>
<form method="post" action="updateLoc">
<pre>
Id: 	<input type="text"  name="id" value="${updateLocation.id}" readonly/>
code: 	<input type="text"  name="code" value="${updateLocation.code}"/>
Name:	<input type="text"  name="name" value="${updateLocation.name}"/>
Urban:	<input type="radio" name="type" value="urban" ${updateLocation.type=='urban'?'checked':''}/>
Rural:	<input type="radio" name="type" value="rural" ${updateLocation.type=='rural'?'checked':''}/>
<input type="submit" value="UpdateLocation">
</pre>
</form>
${message}

<a href="displayAllLocations">showAllLocations</a>
</body>
</html>