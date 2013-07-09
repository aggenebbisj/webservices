
package nl.ordina.jtechnologies.wscursus.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for xmlAdres complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="xmlAdres">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="straat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="woonplaats" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="postcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "xmlAdres", propOrder = {
    "straat",
    "woonplaats",
    "postcode"
})
public class XmlAdres {

    @XmlElement(required = true)
    protected String straat;
    @XmlElement(required = true)
    protected String woonplaats;
    protected String postcode;

    /**
     * Gets the value of the straat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStraat() {
        return straat;
    }

    /**
     * Sets the value of the straat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStraat(String value) {
        this.straat = value;
    }

    /**
     * Gets the value of the woonplaats property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWoonplaats() {
        return woonplaats;
    }

    /**
     * Sets the value of the woonplaats property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWoonplaats(String value) {
        this.woonplaats = value;
    }

    /**
     * Gets the value of the postcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * Sets the value of the postcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostcode(String value) {
        this.postcode = value;
    }

}
