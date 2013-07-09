
package nl.ordina.jtechnologies.wscursus.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for xmlNaam complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="xmlNaam">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="voornaam" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="achternaam" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "xmlNaam", propOrder = {
    "voornaam",
    "achternaam"
})
public class XmlNaam {

    @XmlElement(required = true)
    protected String voornaam;
    @XmlElement(required = true)
    protected String achternaam;

    /**
     * Gets the value of the voornaam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVoornaam() {
        return voornaam;
    }

    /**
     * Sets the value of the voornaam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVoornaam(String value) {
        this.voornaam = value;
    }

    /**
     * Gets the value of the achternaam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAchternaam() {
        return achternaam;
    }

    /**
     * Sets the value of the achternaam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAchternaam(String value) {
        this.achternaam = value;
    }

}
