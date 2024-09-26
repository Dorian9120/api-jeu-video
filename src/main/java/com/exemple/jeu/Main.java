package com.exemple.jeu;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    public static void main(String[] args) throws Exception {
        Server server = new Server(1500);

        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.setContextPath("/");
        server.setHandler(handler);

        handler.addServlet(new ServletHolder(new HelloWorldServlet()), "/hello");
        handler.addServlet(new ServletHolder(new PingServlet()), "/ping");
        handler.addServlet(new ServletHolder(new GameController()), "/post-game-result");
        handler.addServlet(new ServletHolder(new GameController()), "/get-score/*");
        handler.addServlet(new ServletHolder(new GameController()), "/ranking");

        server.start();
        server.join();
    }
}
