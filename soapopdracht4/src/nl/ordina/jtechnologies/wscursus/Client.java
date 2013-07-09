package nl.ordina.jtechnologies.wscursus;

import nl.ordina.jtechnologies.wscursus.soap.HelloService;
import nl.ordina.jtechnologies.wscursus.soap.HelloServiceService;

public class Client {

	public static void main(String[] args) {
		HelloServiceService service = new HelloServiceService();
		HelloService port = service.getHelloServicePort();
		System.out.println(port.sayHello("soap-client"));
	}

}
