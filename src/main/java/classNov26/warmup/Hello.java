package classNov26.warmup;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Hello extends HttpServlet {
    private Archive archive;

    public Hello(Archive archive) {
        this.archive = archive;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        String name = path.substring(1);
        archive.setName(name);
        try(PrintWriter writer = resp.getWriter()){
            writer.printf("<h1>Hello, %s!</h1>", name);
        }
    }
}
