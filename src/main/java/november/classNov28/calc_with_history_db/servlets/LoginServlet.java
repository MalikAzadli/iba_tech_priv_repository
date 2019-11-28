package november.classNov28.calc_with_history_db.servlets;



import november.classNov28.calc_with_history_db.entities.TemplateEngine;
import november.classNov28.calc_with_history_db.auth.Auth;
import november.classNov28.calc_with_history_db.auth.AuthHash;
import november.classNov28.calc_with_history_db.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LoginServlet extends HttpServlet {

    private  final Auth auth;
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
        System.out.printf("name:%s\n",name);
        System.out.printf("paswd:%s\n",password);
        Auth auth = new AuthHash();
        try (PrintWriter w = resp.getWriter()) {
            if (auth.check(name, password)) {
                user.setUsername(name);
                w.printf("Auth for user:%s passwd:%s successful", name, password);
            } else {
                w.printf("Auth for user:%s passwd:%s Error", name, password);
            }
        }
    }
}