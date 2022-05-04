package com.example.webdom6.servlets;

import com.example.webdom6.models.User;
import com.example.webdom6.repo.users.IUserRepo;
import com.example.webdom6.repo.users.UserRepo;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    private IUserRepo userRepository;

    @Override
    public void init() throws ServletException {
        this.userRepository = new UserRepo();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.addCookie(new Cookie("test_cookie", "test_value"));
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = this.userRepository.find(username);

        if (user == null || !user.getPassword().equals(DigestUtils.sha256Hex(password))) {
            // Nema usera ili je lozinka pogresna
            response.sendRedirect(getServletContext().getContextPath() + "/login");

            return;
        }

        request.getSession().setAttribute("user", user);

        response.sendRedirect(getServletContext().getContextPath() + "/");
    }
}
