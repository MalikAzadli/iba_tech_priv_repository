package november.classNov26.replace;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class ReplaceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = "Marianne";
        int count = 3;

        File file = new File("./content/placeholder_task.html");
        BufferedReader br = new BufferedReader(new FileReader(file));
        try (PrintWriter bw = resp.getWriter()) {
            br.lines()
                    .forEach(s -> {
                        s = s.replaceAll("\\$user", name);
                        s = s.replaceAll("\\$count", String.format("%d", count));
                        bw.println(s);
                    });
        }
    }
}
