package nl.ordina.jtechnologies.wscursus.rest.opdracht1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/opdracht1")
public class Hello {

	@GET
	@Path("/hello/{message}")
	public String sayHello(@PathParam(value = "message") String message) {
		return "Hello " + message;
	}
}
