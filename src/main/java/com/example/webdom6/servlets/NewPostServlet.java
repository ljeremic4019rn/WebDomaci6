package com.example.webdom6.servlets;

import com.example.webdom6.models.Post;
import com.example.webdom6.repo.posts.IPostRepo;
import com.example.webdom6.repo.posts.PostRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "NewPostServlet", value = "/new-post")
public class NewPostServlet extends HttpServlet {

    private IPostRepo postRepo;

    @Override
    public void init() throws ServletException {
        this.postRepo = new PostRepo();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println(request.getPathInfo());
        int id = Integer.parseInt(request.getPathInfo().substring(1));
        Post subject = this.postRepo.find(id);
        request.setAttribute("subject", subject);

        request.getRequestDispatcher("/single-subject.jsp").forward(request, response);
    }
}
