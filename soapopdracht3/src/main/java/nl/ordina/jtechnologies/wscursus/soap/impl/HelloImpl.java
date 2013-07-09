package nl.ordina.jtechnologies.wscursus.soap.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import nl.ordina.jtechnologies.wscursus.soap.Hello;

@WebService(serviceName = "HelloService", portName = "HelloPort", endpointInterface = "nl.ordina.jtechnologies.wscursus.soap.Hello", targetNamespace = "http://soap.wscursus.jtechnologies.ordina.nl/", wsdlLocation = "WEB-INF/wsdl/HelloService.wsdl")
public class HelloImpl implements Hello {

	@Override
	@WebMethod
	@WebResult(name = "sayHelloResponse", targetNamespace = "http://soap.wscursus.jtechnologies.ordina.nl/", partName = "return")
	public String sayHello(
			@WebParam(name = "sayHello", targetNamespace = "http://soap.wscursus.jtechnologies.ordina.nl/", partName = "argument") String argument) {
		return "Hello " + argument;
	}

}
