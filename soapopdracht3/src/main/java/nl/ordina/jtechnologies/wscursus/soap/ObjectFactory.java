
package nl.ordina.jtechnologies.wscursus.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the nl.ordina.jtechnologies.wscursus.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SayHello_QNAME = new QName("http://soap.wscursus.jtechnologies.ordina.nl/", "sayHello");
    private final static QName _SayHelloResponse_QNAME = new QName("http://soap.wscursus.jtechnologies.ordina.nl/", "sayHelloResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: nl.ordina.jtechnologies.wscursus.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wscursus.jtechnologies.ordina.nl/", name = "sayHello")
    public JAXBElement<String> createSayHello(String value) {
        return new JAXBElement<String>(_SayHello_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wscursus.jtechnologies.ordina.nl/", name = "sayHelloResponse")
    public JAXBElement<String> createSayHelloResponse(String value) {
        return new JAXBElement<String>(_SayHelloResponse_QNAME, String.class, null, value);
    }

}
