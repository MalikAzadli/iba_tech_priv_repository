package november.classNov23.web.calculator;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class CalculatorServer {
    public static void main(String[] args) throws Exception {
        Server server = new Server(9002);
        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(CalculatorServlet.class, "/calc/*");


        server.setHandler(handler);
        server.start();
        server.join();
    }
}
