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
%>
<html>
<head>
    <title>Account Form</title>
</head>
<body>
<h1>Tạo thông tin sinh viên</h1>
<form action="<%=blobstoreService.createUploadUrl("/account/register")%>" method="post"
      enctype="multipart/form-data">
    <div>
        Username <input type="text" name="username">
    </div>
    <div>
        Password <input type="password" name="password">
    </div>
    <div>
        Confirm Password <input type="password" name="confirmPassword">
    </div>
    <div>
        Rollnumber <input type="text" name="rollNumber">
    </div>
    <div>
        Fullname <input type="text" name="fullName">
    </div>
    <div>
        Avatar <input type="file" name="myFile">
    </div>
    <div>
        <input type="submit" value="Submit">
        <input type="reset" value="Reset">
    </div>
</form>
</body>
</html>
