<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hello World</title>
    <%@ include file="styles.jsp" %>
</head>
<body>
<%@ include file="nav_bar.jsp" %>

<div class="container">
    <form method="POST" action="<%=application.getContextPath() + "/login"%>">
        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" class="form-control" id="username" name="username" aria-describedby="usernameHelp"
                   placeholder="Enter username">
            <small id="usernameHelp" class="form-text text-muted">We'll never share your username with anyone
                else.</small>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Password">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

</body>
</html>
