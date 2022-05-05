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
import java.io.PrintWriter;

@WebServlet(name = "NewPostServlet", value = "/new_post")
public class NewPostServlet extends HttpServlet {

    private IPostRepo postRepo;

    @Override
    public void init() throws ServletException {
        this.postRepo = new PostRepo();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();

        if (request.getSession().getAttribute("user") != null){
            request.getRequestDispatcher("/new_post.jsp").forward(request, response);
        }
        else{
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Not logged in');");
            out.println("location='/posts';");
            out.println("</script>");
        }

    }
}
