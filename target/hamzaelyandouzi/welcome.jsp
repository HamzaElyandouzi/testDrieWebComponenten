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

<h1>Welcome ${name} </h1>

<form action="logout" method="post">
    <input type="submit" name="logout" value="Log out">
</form>

</body>
</html>
