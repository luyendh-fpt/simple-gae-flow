<%@ page import="demo.entity.Account" %>
<%@ page import="java.util.List" %>
<%@ page import="demo.entity.Student" %><%--
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
                <li>
                    <div>
                        <%
                            if(list.get(i).getStudentRef()!=null)
                            {
                                Student student = list.get(i).getStudentRef().get();
                        %>
                            <img src="<%=student.getAvatarUrl()%>" alt="" style="width: 150px;">
                        <%
                            }
                        %>
                    </div>
                    <div>
                        <a href="/account/detail?id=<%=list.get(i).getUsername()%>"><%= list.get(i).getUsername()%></a>
                    </div>
                </li>
        <%
            }
        %>

    </ul>
</body>
</html>
