package com.example.webdom6.servlets;


import com.example.webdom6.models.Post;
import com.example.webdom6.models.User;
import com.example.webdom6.repo.posts.IPostRepo;
import com.example.webdom6.repo.posts.PostRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet(name = "PostsServlet", value = {"/", "/posts"})
public class PostServlet extends HttpServlet {

    private IPostRepo postRepo;
    private static int postIdCounter = 0;

    @Override
    public void init() throws ServletException {
        this.postRepo = new PostRepo();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("posts", this.postRepo.all());
        req.getRequestDispatcher("/posts.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User author = (User) req.getSession().getAttribute("user");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        PrintWriter out = resp.getWriter();


        if (author != null && !Objects.equals(title, "") && !Objects.equals(content, "")) {
            this.postRepo.insert(new Post(postIdCounter++, author, title, content, java.time.LocalDate.now()));
            resp.sendRedirect(getServletContext().getContextPath() + "/posts");
        }
        else{
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Not logged in, or content empty');");
            out.println("location='new_post.jsp';");
            out.println("</script>");
        }
    }
}
