package classNov26.calc_with_history;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class CalcServer {
    public static void main(String[] args) throws Exception {
        Server server = new Server(9001);

        History<Operation> history = new History<>();

        TemplateEngine engine = new TemplateEngine("./content");
        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(new ServletHolder(new CalcServlet(history, engine)), "/calc/*");
        handler.addServlet(new ServletHolder(new HistoryServlet(history, engine)), "/hist/*");

        server.setHandler(handler);
        server.start();
        server.join();
    }
}
