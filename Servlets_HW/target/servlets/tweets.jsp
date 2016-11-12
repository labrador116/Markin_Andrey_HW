<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vietto
  Date: 07.11.16
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Twitter</title>
</head>
<body bgcolor="${colour}">

<h1>Tweeter</h1>


<form action="/twitter" method="get">
    <p><select name="select" size="1">
        <option value="blue">Blue</option>
        <option value="green">Green</option>
        <option value="yellow">Yellow</option>
        <option value="grey">Grey</option>
    </select>
        <input type="submit" value="Отправить"></p>
</form>


<form action="/twitter" method="post">
    <label>Ваше сообщение: </label>
    <input type="text" name="message">
    <input type="submit">
</form>
<br>
<c:if test="${tweets.isEmpty()}">
    <p>Ничего пока нету :(</p>
</c:if>


<c:forEach items="${tweets}" var="tweet">
    <p>${tweet.message}</p>
    <p>${tweet.createdAt}</p>
    <hr>
    <br>

<form action="/twitter/" method="get">
    <input type="hidden" name="id" value="${tweet.id}" />
    <input type="submit" value="Delete" />
</form>
    <br>
    <a href="/comment?id=${tweet.id}" >Комментарии</a>
    <hr>
</c:forEach>
</body>
</html>
