package nl.ordina.jtechnologies.wscursus.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/hello")
public class Hello {

	@GET
	@Path("/{msg}")
	public String sayHello(@PathParam("msg") String msg) {
		return "Hello " + msg;
	}

}
