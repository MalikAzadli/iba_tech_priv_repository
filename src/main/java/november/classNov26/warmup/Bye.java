package november.classNov26.warmup;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Bye extends HttpServlet {

    private Archive archive;

    public Bye(Archive archive) {
        this.archive = archive;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(PrintWriter writer = resp.getWriter()){
            writer.printf("<h1>Bye, %s!</h1>", archive.getName());
        }
    }
}
