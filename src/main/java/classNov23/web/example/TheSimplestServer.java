package classNov23.web.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class TheSimplestServer {
  public static void main(String[] args) throws Exception {
    Server server = new Server(9001);
    ServletContextHandler handler = new ServletContextHandler();
    handler.addServlet(HelloServlet.class, "/hello/*");

    Auth auth = new AuthHash();
    LoginServlet login = new LoginServlet(auth);
    handler.addServlet(new ServletHolder(login), "/login/*");
    handler.addServlet(HelpServlet.class, "/help/*");
    handler.addServlet(Servlet404.class, "/*");
    server.setHandler(handler);
    server.start();
    server.join();
  }
}
