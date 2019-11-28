package november.classNov26.warmup;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class WarmUpServer {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8001);

        ServletContextHandler handler = new ServletContextHandler();
        Archive archive = new Archive();
        Hello hello = new Hello(archive);
        handler.addServlet(new ServletHolder(hello), "/hello/*");
        Bye bye = new Bye(archive);
        handler.addServlet(new ServletHolder(bye), "/bye/*");
        server.setHandler(handler);
        server.start();
        server.join();
    }
}
