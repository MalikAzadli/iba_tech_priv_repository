package classNov23.web.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String sa = req.getParameter("a");
    String sb = req.getParameter("b");
    String pathInfo = req.getPathInfo();
    String queryString = req.getQueryString();
    // http://localhost:9001/hello/abc/?a=5&b=7
//    Calc calc = new Calc();
//    int c = calc.add(a,b);

    try (PrintWriter writer = resp.getWriter()) {
      writer.println("<html><body><H1>Hello World</H1>");

      writer.printf("a=%s<br>",sa);
      writer.printf("b=%s<br>",sb);
      writer.printf("pathInfo=%s<br>",pathInfo);
      writer.printf("queryString=%s<br>",queryString);
//      writer.printf("result=%s<br>",c);

      writer.println("</body><html>");
    }
  }
}
