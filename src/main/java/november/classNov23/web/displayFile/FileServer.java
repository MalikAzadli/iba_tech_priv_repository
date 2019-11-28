package november.classNov23.web.displayFile;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class FileServer {
    public static void main(String[] args) throws Exception {
        Server server = new Server(9003);
        ServletContextHandler handler = new ServletContextHandler();

        handler.addServlet(FileServlet.class, "/*");

        server.setHandler(handler);
        server.start();
        server.join();

    }
}
