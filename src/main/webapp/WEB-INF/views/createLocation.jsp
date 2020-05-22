<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Location</title>
</head>
<body>
<form method="post" action="saveLoc">
<pre>
Id: 	<input type="text"  name="id"/>
code: 	<input type="text"  name="code"/>
Name:	<input type="text"  name="name"/>
Urban:	<input type="radio" name="type" value="urban"/>
Rural:	<input type="radio" name="type" value="rural"/>
<input type="submit" value="SaveLocation">
</pre>
</form>
${message}

<a href="displayAllLocations">showAllLocations</a>
</body>
</html>