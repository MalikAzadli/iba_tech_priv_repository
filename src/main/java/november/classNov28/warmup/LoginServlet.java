package november.classNov28.warmup;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class LoginServlet extends HttpServlet {
    private TemplateEngine engine;
    public LoginServlet(TemplateEngine engine) {
        this.engine = engine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, Object> data = new HashMap<>();
        ArrayList<LinkContainer> links = new ArrayList<>();
        links.add(new LinkContainer("/menu/", "Menu"));
        links.add(new LinkContainer("/logout/", "Log out"));
        data.put("title", "LOGIN");
        data.put("links", links);
        engine.render("template.ftl", data, resp);
    }
}
