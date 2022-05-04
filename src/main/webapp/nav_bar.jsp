<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Web programiranje</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="<%=application.getContextPath()%>/posts">Posts</a>
      </li>
    </ul>

    <div class="form-inline my-2 my-lg-0">
      <% if (session.getAttribute("user") == null) { %>
      <a href="<%=application.getContextPath()%>/login" class="btn btn-outline-success my-2 my-sm-0">Log in</a>
      <% } else { %>
      <a href="<%=application.getContextPath()%>/logout" class="btn btn-outline-success my-2 my-sm-0">Log out</a>
      <% } %>
    </div>
  </div>
</nav>
