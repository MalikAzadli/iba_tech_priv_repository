package november.classNov28.calc_with_history_db.servlets;

import november.classNov23.web.calculator.Calculator;
import november.classNov28.calc_with_history_db.db_props.DbOperations;
import november.classNov28.calc_with_history_db.entities.History;
import november.classNov28.calc_with_history_db.entities.Operation;
import november.classNov28.calc_with_history_db.entities.TemplateEngine;
import november.classNov28.calc_with_history_db.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class CalcServlet extends HttpServlet {

    private TemplateEngine engine;
    private User user;

    public CalcServlet(TemplateEngine engine, User user) {
        this.engine = engine;
        this.user = user;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String a = req.getParameter("a");
//        String b = req.getParameter("b");
//        String op = req.getParameter("op");
        String a = "5";
        String b = "6";
        String op = "add";

        Calculator calculator = new Calculator();
        Operation operation = new Operation(a, op, b, calculator.operate(a,b,op));
        History history = new History(user, operation);
        HashMap<String, Object> data = new HashMap<>();
        data.put("calculation", operation);
        engine.render("calculator.ftl", data, resp);
        try {
            DbOperations.addHistory(history);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
