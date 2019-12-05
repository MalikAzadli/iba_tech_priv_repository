package december.classDec03.cookies;


import december.classDec03.cookies.auth.Auth;
import december.classDec03.cookies.auth.AuthHash;
import december.classDec03.cookies.entities.TemplateEngine;
import december.classDec03.cookies.entities.User;
import december.classDec03.cookies.servlets.CalcServlet;
import december.classDec03.cookies.servlets.HistoryServlet;
import december.classDec03.cookies.servlets.LoginServlet;
import december.classDec03.cookies.servlets.RedirectServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class CalcServerC {
    /*
    http://localhost:9001/login
     */
    public static void main(String[] args) throws Exception {
        Server server = new Server(9001);

        TemplateEngine engine = new TemplateEngine("./content");
        Auth auth = new AuthHash();
        User loggedin = new User();
        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(new ServletHolder(new LoginServlet(auth, engine, loggedin)), "/login/*");
        handler.addServlet(new ServletHolder(new CalcServlet(engine, loggedin)), "/calc/*");
        handler.addServlet(new ServletHolder(new HistoryServlet(engine)), "/hist/*");
        handler.addServlet(new ServletHolder(new RedirectServlet("/login/")), "/*");

        server.setHandler(handler);
        server.start();
        server.join();
    }
}
