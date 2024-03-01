
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New List Page - Pet List</title>
</head>
<body>
	<form action="createNewListServlet" method="post">
	List Name: <input type="text" name="listName"><br />
	Date: <input type="text" name="month" placeholder="mm" size="4">
	<input type="text" name="day" placeholder="dd" size="4">,
	<input type="text" name="year" placeholder="yyyy" size="4">
	Shopper Name: <input type="text" name="shopperName"><br />

	Available Items:<br />
	<select name="allItemsToAdd" multiple size="6">
		<c:forEach items="${requestScope.allItems}" var="currentitem">
			<option value="${currentitem.id}">${currentitem.species} | ${currentitem.gender} | ${currentitem.age}
			</option>
		</c:forEach>
	</select>
	<br />
	<input type="submit" value="Create List and Add Items">
</form>
<a href="index.html">Go add new items instead.</a>

	<form method = "post" action = "listNavigationServlet"> <table>
	
	<c:forEach items="${requestScope.allLists}" var="currentlist"> <tr>
	<td><input type="radio" name="id" value="${currentlist.id}"></td> <td><h2>${currentlist.listName}</h2></td></tr>
	<tr><td colspan="3">Date: ${currentlist.date}</td></tr> <tr><td colspan="3">Shopper:
	${currentlist.shopper.shopperName}</td></tr>
	<c:forEach var = "listVal" items = "${currentlist.listOfItems}">
	<tr><td></td><td colspan="3"> ${listVal.species}, ${listVal.gender} , ${listVal.age}
	
		</td> </tr>
	</c:forEach>
	</c:forEach>
</table>
	<input type = "submit" value = "edit" name="doThisToList"> <input type = "submit" value = "delete" name="doThisToList"> <input type="submit" value = "add" name = "doThisToList"> </form>
	<a href="addPetsForListServlet">Create a new Pet List</a> <a href="index.html">Insert a new item</a>
</body>
</html>
