<%@ page import="demo.entity.ClassRoom" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreService" %>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory" %><%--
  Created by IntelliJ IDEA.
  User: xuanhung
  Date: 2019-06-18
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
    ClassRoom room = (ClassRoom) request.getAttribute("room");
    HashMap<String, String> errors = (HashMap<String, String>) request.getAttribute("errors");
    if(errors == null){
        errors = new HashMap<>();
    }
    if(room == null){
        room = new ClassRoom();
    }
%>
<html>
<head>
    <title>Classroom Form</title>
</head>
<body>
<h1>Classroom Form</h1>
<%
    if(errors.size() > 0){
%>
<div class="error">
 Vui lòng sửa các lỗi bên dưới và thử lại.
</div>
<%
    }
%>

<form action="<%= blobstoreService.createUploadUrl("/classroom/create") %>"
      method="post" enctype="multipart/form-data">
    <div>
        Name <input type="text" name="name" value="<%= room.getName()%>">
        <%
            if(errors.containsKey("name")){
        %>
            <span class="error"><%=errors.get("name")%></span>
        <%
            }
        %>
    </div>
    <div>
        Description <input type="text" name="description" value="<%= room.getDescription()%>">
        <%
            if(errors.containsKey("description")){
        %>
        <span class="error"><%=errors.get("description")%></span>
        <%
            }
        %>
    </div>
    <div>Image <input type="file" name="myFile"></div>
    <div>
        <input type="submit" value="Submit">
        <input type="reset" value="Reset">
    </div>
</form>
</body>
</html>
