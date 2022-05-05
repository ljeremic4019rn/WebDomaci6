<%@ page import="com.example.webdom6.models.Post" %><%--
  Created by IntelliJ IDEA.
  User: Shus
  Date: 5/5/2022
  Time: 12:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="styles.jsp" %>
</head>
<body>
<% Post post = ((Post) session.getAttribute("post"));%>


<div class="container">
    <article>
        <h1><%=post.getTitle()%></h1>
        <div>
            <small><%=post.getAuthor()%></small>
            <small><%=post.getDateCreated()%></small>
        </div>

        <article>
            <%=post.getContent()%>
        </article>


    </article>
</div>

</body>
</html>
