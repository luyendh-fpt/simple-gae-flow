<%@ page import="demo.entity.Account" %>
<%@ page import="java.util.List" %>
<%@ page import="demo.entity.ClassRoom" %><%--
  Created by IntelliJ IDEA.
  User: xuanhung
  Date: 2019-06-18
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<ClassRoom> list = (List<ClassRoom>) request.getAttribute("list");
    int currentPage = (int) request.getAttribute("currentPage");
    int currentLimit = (int) request.getAttribute("currentLimit");
    int totalPage = (int) request.getAttribute("totalPage");
%>
<html>
<head>
    <title>ClassRoom List</title>
</head>
<body>

<h1>ClassRoom List</h1>
<div>Current page: <%= currentPage%></div>
<div>Current limit: <%= currentLimit%></div>
<div>Total Page: <%= totalPage%></div>
<ul>
    <%
        for (int i = 0; i < list.size(); i++) {
    %>
    <li>
        <img src="<%=list.get(i).getImageUrl()%>" alt="" style="width: 200px">
        <a href="/classroom/detail?id=<%=list.get(i).getId()%>"><%= list.get(i).getName()%>
        </a>
    </li>
    <%
        }
    %>

</ul>
<div>
    <ul>
        <%
        if (currentPage > 1){
        %>
            <a href="/classroom/list?page=1&limit=<%=currentLimit%>"><<</a>
        <%
        }
        %>
        <%
            if (currentPage > 1){
        %>
        <a href="/classroom/list?page=<%=currentPage-1%>&limit=<%=currentLimit%>"><</a>
        <%
            }
        %>

        <%
            if (currentPage - 2 > 1){
        %>
        <a href="/classroom/list?page=<%=currentPage-2%>&limit=<%=currentLimit%>"><%=currentPage - 2%></a>
        <%
            }
        %>
        <%
            if (currentPage - 1 > 1){
        %>
        <a href="/classroom/list?page=<%=currentPage-1%>&limit=<%=currentLimit%>"><%=currentPage - 1%></a>&nbsp;
        <%
            }
        %>

        <a href="#"><%=currentPage%></a>

        <%
            if (currentPage + 1 < totalPage){
        %>
        <a href="/classroom/list?page=<%=currentPage+1%>&limit=<%=currentLimit%>"><%=currentPage + 1%></a>&nbsp;
        <%
            }
        %>

        <%
            if (currentPage + 2 < totalPage){
        %>
        <a href="/classroom/list?page=<%=currentPage+2%>&limit=<%=currentLimit%>"><%=currentPage + 2%></a>&nbsp;
        <%
            }
        %>

        <%
            if (currentPage < totalPage){
        %>
        <a href="/classroom/list?page=<%=currentPage + 1%>&limit=<%=currentLimit%>">></a>&nbsp;
        <%
            }
        %>
        <%
            if (currentPage < totalPage){
        %>
        <a href="/classroom/list?page=<%=totalPage%>&limit=<%=currentLimit%>">>></a>
        <%
            }
        %>
    </ul>

</div>
</body>
</html>
