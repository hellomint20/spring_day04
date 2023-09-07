<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	list page<br><br>

	<table border="1">
		<tr>
			<th>아이디</th> <th>이름</th>
		</tr>
		<c:forEach var="dto" items="${list}">
			<tr>
				<td>${ dto.id }</td> <td>${ dto.name }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>