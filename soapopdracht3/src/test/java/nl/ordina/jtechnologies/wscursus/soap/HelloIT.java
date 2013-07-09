package nl.ordina.jtechnologies.wscursus.soap;

import java.io.IOException;
import static org.junit.Assert.assertEquals;

import java.io.InputStream;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import org.junit.BeforeClass;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * 
 * @author Philippe Tjon-A-Hen
 * @author Ivo Woltring
 */
public class HelloIT {
   private static String address;
   private static URL wsdlURL;
   private static QName serviceName;
   private static QName portName;


   @BeforeClass
   public static void setUp() throws Exception {
      serviceName = new QName("http://soap.wscursus.jtechnologies.ordina.nl/", "HelloService");
      portName = new QName("http://soap.wscursus.jtechnologies.ordina.nl/", "HelloPort");
      address = "http://localhost:8080/soapopdracht3/HelloService";
      wsdlURL = new URL(address + "?wsdl");
   }

   
  /*
    * This test uses raw Service class for service, Dispatch<Source> for
    * client. No wsimport/wsdl2java run needed. Uses payload (soap:body contents)
    * only (Service.Mode.PAYLOAD). 
    * 
    * 
    * @throws ParserConfigurationException -
    * @throws SAXException -
    * @throws IOException -
    * @throws TransformerConfigurationException -
    * @throws TransformerException -
    */
   @Test
   public void sayHello() throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException {
      final Service jaxwsService = Service.create(wsdlURL, serviceName);
      
      final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      factory.setNamespaceAware(true);
      
      final DocumentBuilder builder = factory.newDocumentBuilder();
      final InputStream is = getClass().getClassLoader().getResourceAsStream("justPayload.xml");
      final Document newDoc = builder.parse(is);
      final DOMSource request = new DOMSource(newDoc);
      final Dispatch<Source> disp = jaxwsService.createDispatch(portName,  Source.class, Service.Mode.PAYLOAD);
      
      final Source result = disp.invoke(request);
      
      final DOMResult domResponse = new DOMResult();
      final Transformer trans = TransformerFactory.newInstance().newTransformer();
      
      trans.transform(result, domResponse);
      assertEquals("Hello from soap ws", "Hello Test User", domResponse
            .getNode().getFirstChild().getTextContent().trim());

   }
}
