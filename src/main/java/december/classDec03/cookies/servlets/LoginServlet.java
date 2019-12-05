package december.classDec03.cookies.servlets;


import december.classDec03.cookies.auth.Auth;
import december.classDec03.cookies.auth.AuthHash;
import december.classDec03.cookies.entities.MyConsts;
import december.classDec03.cookies.entities.TemplateEngine;
import december.classDec03.cookies.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LoginServlet extends HttpServlet implements MyConsts {

    private final Auth auth;
    private final TemplateEngine engine;
    private User user;

    public LoginServlet(Auth auth, TemplateEngine engine, User user) {
        this.auth = auth;
        this.engine = engine;
        this.user = user;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Files.copy(Paths.get("./content/login.html"), resp.getOutputStream());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        System.out.printf("name:%s\n", name);
        System.out.printf("paswd:%s\n", password);
        Auth auth = new AuthHash();
        try (PrintWriter w = resp.getWriter()) {
            if (auth.check(name, password)) {
                user.setUsername(name);
                w.printf("Auth for user:%s passwd:%s successful", name, password);
                int user_id = 12;
                Cookie cookie = new Cookie(COOKIE_NAME, String.valueOf(user_id));
                resp.addCookie(cookie);
                w.println("Wait for 2 seconds, you will be redirected to calculator");
                resp.sendRedirect("refresh");
            } else {
                w.printf("Auth for user:%s passwd:%s Error", name, password);
            }
        }

    }
}