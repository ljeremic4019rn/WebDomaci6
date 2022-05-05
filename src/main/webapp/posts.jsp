<%@ page import="com.example.webdom6.models.Post" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="styles.jsp" %>
</head>
<body>
<%@ include file="nav_bar.jsp" %>

<div class="container">
    <h1>Posts:</h1>
    <br>

    <c:forEach var="post" items="${posts}">
            <div class="container border">
                <a href="<%=application.getContextPath()%>/posts/${post.getId()}" aria-current="true">
                <h3>${post.getTitle()}</h3>
                </a>
                <small>${post.shortenedText()}</small>
                <br>
                <small>Opsirnije...</small>
            </div>
    </c:forEach>

    <br>
    <a href="<%=application.getContextPath()%>/new_post" class="btn btn-outline-success my-2 my-sm-0">New post</a>
</div>


</body>
</html>
