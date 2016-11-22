<%--
  Created by IntelliJ IDEA.
  User: Andrey_pers
  Date: 21.11.2016
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student</title>
</head>
<body>


<c:forEach items="${students}" var="student">
    <table>
        <tr>
            <td>
                ${student.surname}
            </td>
            <td>
                ${student.name}
            </td>
            <td>
                ${student.othername}
            </td>
        </tr>
    </table>
</c:forEach>
<br>


<p>Сумма всех баллов</p>
<form action="getSum" method="get">
    <table border="5">
        <tr>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td>${sum}</td>
        </tr>
    </table>
    <input type="submit" value="Get"/>
</form>
<br>

<p>Средний бал</p>
<form action="getAverage" method="get">
    <table border="5">
        <tr>
            <td><input type="text"  name="id"></td>
        </tr>
        <tr>
            <td>${aver}</td>
        </tr>
    </table>
    <input type="submit" value="Get"/>
</form>
<br>

<p>Баллы за предмет (математика, физика, химия) </p>
<form action="getPointOfLesson" method="get">
    <table border="5">
        <tr>
            <td><input type="text" value="ID" name="id"></td>
        </tr>
        <tr>
            <td><input type="text" value="Name" name="lesson"></td>
        </tr>
        <tr>
            <td>${points}</td>
        </tr>
    </table>
    <input type="submit" value="Get"/>
</form>


</body>
</html>
