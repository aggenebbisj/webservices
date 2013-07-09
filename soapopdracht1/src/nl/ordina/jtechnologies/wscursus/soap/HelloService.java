package nl.ordina.jtechnologies.wscursus.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class HelloService {

	/**
	 * The web method or actual webservice to call.
	 * 
	 * @param base
	 *            the content base
	 * @return the hello response
	 */
	@WebMethod
	public String sayHello(final String base) {
		return "Hello " + base;
	}

}
