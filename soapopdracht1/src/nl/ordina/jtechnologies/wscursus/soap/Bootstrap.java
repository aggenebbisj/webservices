package nl.ordina.jtechnologies.wscursus.soap;

import javax.xml.ws.Endpoint;

/**
 * Bootstrap class to start a SOAP endpoint.
 */
public final class Bootstrap {
	public static void main(final String... args) {
		final HelloService content = new HelloService();
		final Endpoint endpoint = Endpoint.create(content);
		endpoint.publish("http://localhost:8066/soap-opdracht1");
	}
}