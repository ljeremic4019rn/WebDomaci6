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

@WebServlet(name = "PostsServlet", value = {"/", "/posts"})
public class PostServlet extends HttpServlet {

    private IPostRepo postRepo;

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
        String text = req.getParameter("post");
        if (author != null && text != null) {
            this.postRepo.insert(new Post(author, text, "context"));
        }

        resp.sendRedirect(getServletContext().getContextPath() + "/posts");
    }
}
