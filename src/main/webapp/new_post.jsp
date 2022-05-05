<%@ page import="com.example.webdom6.models.User" %><%--
  Created by IntelliJ IDEA.
  User: Shus
  Date: 5/5/2022
  Time: 12:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="styles.jsp" %>
</head>
<body>
<%@ include file="nav_bar.jsp" %>


<%--todo postavi akciju kasnije ovde--%>

<div class="container">
    <form method="POST" action="<%=application.getContextPath() + "/posts"%>">
        <div class="form-group">
            <label for="author">Author</label>
            <input type="text" class="form-control" id="author" name="author" value="<%= ((User) session.getAttribute("user")).getUsername()%>" readonly>
        </div>
        <div class="form-group">
            <label for="title">Title</label>
            <input type="text" class="form-control" id="title" name="title" placeholder="Enter title">
        </div>
        <div class="form-group">
            <label for="content">Content</label>
            <textarea type="text" class="form-control" name="content" id="content"  rows="5" placeholder="Enter content"></textarea>

        </div >
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

</body>
</html>
