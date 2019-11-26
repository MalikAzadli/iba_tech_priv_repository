package classNov26.calc_with_history;

import classNov23.web.calculator.Calculator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class CalcServlet extends HttpServlet {

    private History history;
    private TemplateEngine engine;

    public CalcServlet(History history, TemplateEngine engine) {
        this.history = history;
        this.engine = engine;
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
        HashMap<String, Object> data = new HashMap<>();
        data.put("calculation", operation);
        engine.render("calculator.ftl", data, resp);
        history.add(operation);

    }
}
