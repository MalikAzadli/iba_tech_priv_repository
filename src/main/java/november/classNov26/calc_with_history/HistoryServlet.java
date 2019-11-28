package november.classNov26.calc_with_history;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class HistoryServlet extends HttpServlet {

    private History history;
    private TemplateEngine engine;

    public HistoryServlet(History history, TemplateEngine engine) {
        this.history = history;
        this.engine = engine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, Object> data = new HashMap<>();
        data.put("history", history.getHist());
        engine.render("history.ftl", data, resp);
    }
}
