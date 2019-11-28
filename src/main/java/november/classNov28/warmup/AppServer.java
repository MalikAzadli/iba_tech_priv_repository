package november.classNov28.warmup;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class AppServer {

    /**
     * http://localhost:9000
     */
    public static void main(String[] args) throws Exception {
        Server server = new Server(9000);
        TemplateEngine engine = new TemplateEngine("./content/");

        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(new ServletHolder(new LoginServlet(engine)), "/login/*");
        handler.addServlet(new ServletHolder(new MenuServlet(engine)), "/menu/*");
        handler.addServlet(new ServletHolder(new LogoutServlet(engine)), "/logout/*");
        handler.addServlet(new ServletHolder(new DefaultRedirect("/login/")), "/*");

        server.setHandler(handler);
        server.start();
        server.join();
    }
}
