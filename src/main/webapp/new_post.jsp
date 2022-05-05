<%--
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

<div class="container">
    <form method="POST" action="<%=application.getContextPath() + "/posts"%>">
        <div class="form-group">
            <label for="author">Author</label>
            <input type="text" class="form-control" id="author" name="author" placeholder="Enter username">
        </div>
        <div class="form-group">
            <label for="author">Title</label>
            <input type="text" class="form-control" id="title" name="title" placeholder="Enter title">
        </div>
        <div class="form-group">
            <label for="author">Content</label>
            <input type="text" class="form-control" id="content" name="content" placeholder="Enter content">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

</body>
</html>
