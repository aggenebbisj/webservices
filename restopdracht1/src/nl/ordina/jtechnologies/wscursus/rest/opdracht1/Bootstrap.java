package nl.ordina.jtechnologies.wscursus.rest.opdracht1;

import java.io.IOException;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

public class Bootstrap {

	public static void main(final String... args)
			throws IllegalArgumentException, IOException {
		HttpServer server = HttpServerFactory.create("http://localhost:8066/");
		server.start();
		System.in.read();
		server.stop(0);
	}
}
