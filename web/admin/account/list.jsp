<%@ page import="demo.entity.Account" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: xuanhung
  Date: 2019-06-18
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Account> list = (List<Account>) request.getAttribute("list");
%>
<html>
<head>
    <title>Account List</title>
</head>
<body>
    <h1>Account List</h1>
    <ul>
        <%
            for (int i = 0; i < list.size(); i++) {
        %>
                <li><a href="/account/detail?id=<%=list.get(i).getUsername()%>"><%= list.get(i).getUsername()%></a></li>
        <%
            }
        %>

    </ul>
</body>
</html>
