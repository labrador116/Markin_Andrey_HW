
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form action="/posts/userRegistration/accessRegistration" method="post"  modelAttribute="user">
    <table>
        <tr>
            <td>Login:</td>
            <td><form:input path="login" /></td>
            <td><form:errors path="login"/></td>
        </tr>

        <tr>
            <td>Password:</td>
            <td><form:password path="password" /></td>
            <td><form:errors path="password" /></td>
        </tr>

        <tr>
            <td>Name:</td>
            <td><form:input path="name" /></td>
            <td><form:errors path="name" /></td>
        </tr>
        <tr>
            <td>Surname:</td>
            <td><form:input path="surname" /></td>
            <td><form:errors path="surname" /></td>
        </tr>

        <tr>
            <td>Othername:</td>
            <td><form:input path="othername" /></td>
            <td><form:errors path="othername" /></td>
        </tr>

        <tr>
            <td colspan="3"><input type="submit" value="Submit" /></td>
        </tr>
    </table>
</form:form>



</body>
</html>
