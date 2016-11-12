<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Комментарии</title>
</head>
<body>

<h1>Комментарии</h1>

<p>${message}</p>
<hr>
<c:if test="${comments.isEmpty()}">
    <p>Комментариев нет!</p>
</c:if>
<form action="/comment" method="post">
    <label>Ваше комментарий: </label>
    <input type="text" name="comm">
    <input type="hidden" name="id" value="${id}" />
    <input type="submit">
</form>
<br>
<hr>
<c:forEach items="${comments}" var="comment">
    <p>${comment.comment}</p>
</c:forEach>

</body>
</html>
