<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
    <title>Admin Dashboard</title>
</head>
<body>

<h2>📊 Visitors List</h2>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Visit Time</th>
    </tr>

    <c:forEach var="guest" items="${guests}">
        <tr>
            <td>${guest.id}</td>
            <td>${guest.name}</td>
            <td>${guest.visitTime}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
