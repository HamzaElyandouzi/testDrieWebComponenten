<%--
  Created by IntelliJ IDEA.
  User: Hamza
  Date: 9-9-2019
  Time: 09:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>

<%--the name value is called from the session that has the same --%>
<%--which contains a saved value send through the login form.--%>
<h1>Welcome ${name} </h1>

<%--the following form will lead to the logoutServlet which will end the session--%>
<%--en then return to the login jsp--%>

<form action="logout" method="post">
    <input type="submit" name="logout" value="Log out">
</form>

</body>
</html>
