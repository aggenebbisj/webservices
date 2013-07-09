
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

    private final static QName _XmlPersoon_QNAME = new QName("http://soap.wscursus.jtechnologies.ordina.nl/", "xmlPersoon");
    private final static QName _XmlNaam_QNAME = new QName("http://soap.wscursus.jtechnologies.ordina.nl/", "xmlNaam");
    private final static QName _XmlFault_QNAME = new QName("http://soap.wscursus.jtechnologies.ordina.nl/", "xmlFault");
    private final static QName _XmlNaamDelete_QNAME = new QName("http://soap.wscursus.jtechnologies.ordina.nl/", "xmlNaamDelete");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: nl.ordina.jtechnologies.wscursus.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link XmlAdres }
     * 
     */
    public XmlAdres createXmlAdres() {
        return new XmlAdres();
    }

    /**
     * Create an instance of {@link XmlPersoon }
     * 
     */
    public XmlPersoon createXmlPersoon() {
        return new XmlPersoon();
    }

    /**
     * Create an instance of {@link XmlFault }
     * 
     */
    public XmlFault createXmlFault() {
        return new XmlFault();
    }

    /**
     * Create an instance of {@link XmlNaam }
     * 
     */
    public XmlNaam createXmlNaam() {
        return new XmlNaam();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XmlPersoon }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wscursus.jtechnologies.ordina.nl/", name = "xmlPersoon")
    public JAXBElement<XmlPersoon> createXmlPersoon(XmlPersoon value) {
        return new JAXBElement<XmlPersoon>(_XmlPersoon_QNAME, XmlPersoon.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XmlNaam }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wscursus.jtechnologies.ordina.nl/", name = "xmlNaam")
    public JAXBElement<XmlNaam> createXmlNaam(XmlNaam value) {
        return new JAXBElement<XmlNaam>(_XmlNaam_QNAME, XmlNaam.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XmlFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wscursus.jtechnologies.ordina.nl/", name = "xmlFault")
    public JAXBElement<XmlFault> createXmlFault(XmlFault value) {
        return new JAXBElement<XmlFault>(_XmlFault_QNAME, XmlFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XmlNaam }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wscursus.jtechnologies.ordina.nl/", name = "xmlNaamDelete")
    public JAXBElement<XmlNaam> createXmlNaamDelete(XmlNaam value) {
        return new JAXBElement<XmlNaam>(_XmlNaamDelete_QNAME, XmlNaam.class, null, value);
    }

}
