package net.neelparikh;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class IdentityAPI {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler ch = new ServletContextHandler();
        ch.setContextPath("/api/");
        ch.addServlet(new ServletHolder(new IdentityServlet()), "/users/*");
        server.setHandler(ch);
        server.start();
        server.join();
    }
}
