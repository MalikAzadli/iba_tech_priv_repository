package classNov26.replace;

import org.eclipse.jetty.servlet.ServletContextHandler;

public class Serverr {
    public static void main(String[] args) throws Exception {
        org.eclipse.jetty.server.Server server = new org.eclipse.jetty.server.Server(8001);

        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(ReplaceServlet.class, "/replace/");

        server.setHandler(handler);
        server.start();
        server.join();
    }
}
