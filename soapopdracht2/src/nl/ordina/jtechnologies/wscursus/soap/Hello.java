package nl.ordina.jtechnologies.wscursus.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Hello {

	@WebMethod
	public String sayHello(String arg0) {
		return "hallo " + arg0;
	}

}
