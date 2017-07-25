<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ForumRR</title>
</head>
<body bgcolor="${backgroundcolor}" text="${textcolor}">

<br><a href="welcome.html">Back to main page</a>
<br><br>
<form action="add" method="post">
    <input type="submit" value="Send new message" />
</form>
<form action="settings">
    <input type="text" name="backcolor" value="" hidden  />
    <input type="text" name="textcolor" value="" hidden  />
    <input type="submit" value="Set colors on page" />
</form>
<form action="logout" method="post">
    <input type="submit" value="Logout" />
</form>

<table>
    <c:forEach items="${messages}" var="message">
        <tr>
            <td><c:out value="${message.messageAuthor.userName}"/>:</td>
            <td><c:out value="${message.message}"/></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
