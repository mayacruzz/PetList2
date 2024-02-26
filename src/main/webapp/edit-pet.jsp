<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Pet</title>
</head>
<body>
	<form action="editPetServlet" method="post">
        Species: <input type="text" name="species" value="${petToEdit.species}"><br />
        Gender: <input type="text" name="gender" value="${petToEdit.gender}"><br />
        Age: <input type="text" name="age" value="${petToEdit.age}"><br />
        <input type="hidden" name="id" value="${petToEdit.id}">
        <input type="submit" value="Save Edited Pet">
    </form>
</body>
</html>