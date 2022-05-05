package com.example.webdom6.servlets;

import com.example.webdom6.models.Comment;
import com.example.webdom6.models.Post;
import com.example.webdom6.repo.posts.IPostRepo;
import com.example.webdom6.repo.posts.PostRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SinglePostServlet", value = "/posts/*")
public class SinglePostServlet extends HttpServlet {

    private IPostRepo postRepo;

    @Override
    public void init() throws ServletException {
        this.postRepo = new PostRepo();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getPathInfo().substring(1));
        Post post = this.postRepo.find(id);
        request.getSession().setAttribute("post", post);

        request.getRequestDispatcher("/single_post.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getPathInfo().substring(1));
        Post post = this.postRepo.find(id);
        post.getComments().add(new Comment(request.getParameter("name"), request.getParameter("comment")));

        request.getRequestDispatcher("/single_post.jsp").forward(request, response);
    }
}
