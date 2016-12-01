<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Бложек</title>
</head>
<body>

<h1>Добро пожаловать в мой блог!</h1>


<sec:authorize access="isAnonymous()">
<form action="/authentification" method="post">
    <table border="1">
        <tr>
            <td><label>Login</label> <input type="text" name="login"></td>
        </tr>
        <tr>
            <td><label>Password</label> <input type="password" name="password"></td>
        </tr>
    </table>
    <input type="submit" value="Authorization"/> &nbsp;&nbsp;&nbsp;  <a href="/posts/userRegistration">Registration</a>

</form>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
<b>Вы вошли как, <sec:authentication property="principal.username"/> &nbsp;&nbsp;<a href="/posts/logout">Logout</a></b>
</sec:authorize>
<br>
<form action="/posts" method="get">
    <input type="text" name="phrase" width="600px">
    <input type="submit" value="Search">
</form>

<a href="/posts/add">Добавить новый пост</a>

<c:if test="${posts.size() == 0}">
    <p>Пока ничего нету</p>
</c:if>


<c:forEach var="post" items="${posts}">
    <h3>${post.title}</h3>
    <small>${post.date}</small>
    <p>${post.text.substring(0, post.text.length() > 127 ? 127 : post.text.length())}</p>
    <a href="/posts/${post.id}">Читать полностью...</a><br>

    <sec:authorize access="isAuthenticated() and principal.username == '${post.author.login}'">
    <a href="/posts/${post.id}/delete">Удалить</a>
    <a href="/posts/${post.id}/edit">Редактировать</a>
    </sec:authorize>
    <hr>
</c:forEach>

</body>
</html>
