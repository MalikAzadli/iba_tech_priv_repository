package november.classNov28.calc_with_history_db.servlets;

import november.classNov28.calc_with_history_db.db_props.DbOperations;
import november.classNov28.calc_with_history_db.entities.History;
import november.classNov28.calc_with_history_db.entities.Operation;
import november.classNov28.calc_with_history_db.entities.TemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HistoryServlet extends HttpServlet {

    private TemplateEngine engine;

    public HistoryServlet(TemplateEngine engine) {
        this.engine = engine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, Object> data = new HashMap<>();
        List<History> past = new ArrayList<>();
        try {
            past.addAll(DbOperations.getHistory());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        data.put("history", past);
        engine.render("history.ftl", data, resp);
    }
}
