<%@ page import="demo.entity.Account" %><%--
  Created by IntelliJ IDEA.
  User: xuanhung
  Date: 2019-06-18
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Account account = (Account) request.getAttribute("account");
%>
<html>
<head>
    <title>Account Form</title>
</head>
<body>
<h1>Account Form</h1>
<form action="/account/update" method="post">
    <div>
        Username <input type="text" name="username" value="<%= account.getUsername()%>">
    </div>
    <div>
        Password <input type="password" name="password">
    </div>
    <div>
        Confirm Password <input type="password" name="password">
    </div>
    <div>
        <input type="submit" value="Submit">
        <input type="reset" value="Reset">
    </div>
</form>
</body>
</html>
