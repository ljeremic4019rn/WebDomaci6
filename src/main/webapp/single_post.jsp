<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.webdom6.models.Post" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.example.webdom6.models.Comment" %><%--
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
<%@ include file="nav_bar.jsp" %>
<% Post post = ((Post) session.getAttribute("post"));%>


<div class="container">
    <article>
        <h1><%=post.getTitle()%></h1>
        <div>
            <small><%=post.getAuthor().getUsername()%></small>
            <br>
            <small><%=post.getDateCreated()%></small>
        </div>
        <br>

        <div>
            <%=post.getContent()%>
        </div>

        <div>
            <div>
                <h2>Comments:</h2>
                <c:forEach var="comment" items="${post.getComments()}">
                    <div class="container border">
                        <h5>${comment.author}</h5>
                        <h7>${comment.content}</h7>
                    </div>
                    <br>
                </c:forEach>
            </div>

            <form method="POST" action="<%=application.getContextPath() + "/posts/" + post.getId()%>">
                <div class="form-group">
                    <label for="name">Name</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="Enter your name">

                    <label for="comment">Comment</label>
                    <input type="text" class="form-control" id="comment" name="comment"
                           placeholder="Enter your comment">
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </article>
</div>

</body>
</html>
