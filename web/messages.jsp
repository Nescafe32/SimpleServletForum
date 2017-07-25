<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adding new message</title>
</head>
<body>

<h2>Add message</h2>
<br>

<jsp:useBean id="user" scope="session" class="com.rr.servlets.model.ForumUser" />

<form action="messages" method="post">
    <textarea rows="6" cols="14" name="msg" placeholder="Type ur message, dear <jsp:getProperty name="user" property="userName"/>"></textarea>
    <br><input type="submit" value="Send message" />
</form>

</body>
</html>
