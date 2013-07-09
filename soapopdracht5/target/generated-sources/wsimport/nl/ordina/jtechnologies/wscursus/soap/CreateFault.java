
package nl.ordina.jtechnologies.wscursus.soap;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-b01-
 * Generated source version: 2.1
 * 
 */
@WebFault(name = "xmlFault", targetNamespace = "http://soap.wscursus.jtechnologies.ordina.nl/")
public class CreateFault
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private XmlFault faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public CreateFault(String message, XmlFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public CreateFault(String message, XmlFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: nl.ordina.jtechnologies.wscursus.soap.XmlFault
     */
    public XmlFault getFaultInfo() {
        return faultInfo;
    }

}
