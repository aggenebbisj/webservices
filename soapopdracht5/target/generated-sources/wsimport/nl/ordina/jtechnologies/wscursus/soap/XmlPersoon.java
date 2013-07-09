
package nl.ordina.jtechnologies.wscursus.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for xmlPersoon complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="xmlPersoon">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="naam" type="{http://soap.wscursus.jtechnologies.ordina.nl/}xmlNaam" minOccurs="0"/>
 *         &lt;element name="geboortedatum" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="adres" type="{http://soap.wscursus.jtechnologies.ordina.nl/}xmlAdres" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "xmlPersoon", propOrder = {
    "naam",
    "geboortedatum",
    "adres"
})
public class XmlPersoon {

    protected XmlNaam naam;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar geboortedatum;
    protected XmlAdres adres;

    /**
     * Gets the value of the naam property.
     * 
     * @return
     *     possible object is
     *     {@link XmlNaam }
     *     
     */
    public XmlNaam getNaam() {
        return naam;
    }

    /**
     * Sets the value of the naam property.
     * 
     * @param value
     *     allowed object is
     *     {@link XmlNaam }
     *     
     */
    public void setNaam(XmlNaam value) {
        this.naam = value;
    }

    /**
     * Gets the value of the geboortedatum property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getGeboortedatum() {
        return geboortedatum;
    }

    /**
     * Sets the value of the geboortedatum property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setGeboortedatum(XMLGregorianCalendar value) {
        this.geboortedatum = value;
    }

    /**
     * Gets the value of the adres property.
     * 
     * @return
     *     possible object is
     *     {@link XmlAdres }
     *     
     */
    public XmlAdres getAdres() {
        return adres;
    }

    /**
     * Sets the value of the adres property.
     * 
     * @param value
     *     allowed object is
     *     {@link XmlAdres }
     *     
     */
    public void setAdres(XmlAdres value) {
        this.adres = value;
    }

}
