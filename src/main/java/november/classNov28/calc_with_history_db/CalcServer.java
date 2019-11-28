package november.classNov28.calc_with_history_db;


import november.classNov28.calc_with_history_db.auth.Auth;
import november.classNov28.calc_with_history_db.auth.AuthHash;
import november.classNov28.calc_with_history_db.entities.TemplateEngine;
import november.classNov28.calc_with_history_db.entities.User;
import november.classNov28.calc_with_history_db.servlets.CalcServlet;
import november.classNov28.calc_with_history_db.servlets.HistoryServlet;
import november.classNov28.calc_with_history_db.servlets.LoginServlet;
import november.classNov28.calc_with_history_db.servlets.RedirectServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class CalcServer {
    /*
    http://localhost:9001
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
