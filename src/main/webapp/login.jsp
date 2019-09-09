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
    <title>Login</title>
</head>
<body>
<%--The following code prevents the user to return to the login form--%>
<%--after entering there name. unable to do it again until the have loged out--%>

<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");//Http 1.1
    response.setHeader("Pragma", "no-cache");//Http 1.0
    response.setHeader("Expires", "0");//Proxies
%>

<h1>Hallo Guest</h1>
<h2>Give a name to log in</h2>

<%--the following form will lead to then testdrieServlet with the value collected in the text input--%>

<form action="testdrie" method="post">
    <input type="text" name="login">
    <input type="submit" value="Push here">
</form>

</body>
</html>
