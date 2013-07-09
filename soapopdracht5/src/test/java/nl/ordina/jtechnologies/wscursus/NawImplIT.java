package nl.ordina.jtechnologies.wscursus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPFaultException;

import nl.ordina.jtechnologies.wscursus.soap.CustomXmlPersoon;
import nl.ordina.jtechnologies.wscursus.soap.XmlNaam;
import nl.ordina.jtechnologies.wscursus.soap.XmlPersoon;

import org.junit.BeforeClass;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * 
 * @author Philippe Tjon-A-Hen
 * @author Ivo Woltring
 */
public class NawImplIT {

	private static final String WSDL_NAMESPACE = "http://wsdl.soap.wscursus.jtechnologies.ordina.nl/";
	private static final String NAMESPACE = "http://soap.wscursus.jtechnologies.ordina.nl/";

	private static String address;
	private static URL wsdlURL;
	private static QName serviceName;
	private static QName portName;

	@BeforeClass
	public static void setUp() throws Exception {
		serviceName = new QName(WSDL_NAMESPACE, "NawService");
		portName = new QName(WSDL_NAMESPACE, "NawPort");
		address = "http://localhost:8080/soapopdracht5/NawService";
		wsdlURL = new URL(address + "?wsdl");
	}

	/**
	 * This test uses raw Service class for service, Dispatch<Source> for
	 * client. No wsimport/wsdl2java run needed. Uses payload (soap:body
	 * contents) only (Service.Mode.PAYLOAD).
	 * 
	 * As the create webservice is a void method the returning document is
	 * empty. Thus the result is null.
	 * 
	 * @throws ParserConfigurationException
	 *             -
	 * @throws SAXException
	 *             -
	 * @throws IOException
	 *             -
	 */
	@Test
	public void create() throws ParserConfigurationException, SAXException,
			IOException {
		doCreate("createPayload.xml");
	}

	private void doCreate(final String payload)
			throws ParserConfigurationException, SAXException, IOException {
		final Service jaxwsService = Service.create(wsdlURL, serviceName);

		final DocumentBuilderFactory factory = DocumentBuilderFactory
				.newInstance();
		factory.setNamespaceAware(true);

		final DocumentBuilder builder = factory.newDocumentBuilder();
		final InputStream is = getClass().getClassLoader().getResourceAsStream(
				payload);
		final Document newDoc = builder.parse(is);
		final DOMSource request = new DOMSource(newDoc);
		final Dispatch<Source> disp = jaxwsService.createDispatch(portName,
				Source.class, Service.Mode.PAYLOAD);

		final Source result = disp.invoke(request);
		assertNull(result);
	}

	/**
	 * This test uses raw Service class for service, Dispatch<JAXBContext> for
	 * client. Conveniently uses JAX-WS generated artifacts.
	 * 
	 * Creating the same persoon twice should give an soapfault.
	 * 
	 * @throws JAXBException
	 *             -
	 */
	@Test
	public void create_duplicates_not_allowed() throws JAXBException {
		final Service jaxwsService = Service.create(wsdlURL, serviceName);
		final JAXBContext jaxbContext = JAXBContext
				.newInstance("nl.ordina.jtechnologies.wscursus.soap");
		final Dispatch<Object> jaxbDispatch = jaxwsService.createDispatch(
				portName, jaxbContext, Service.Mode.PAYLOAD);

		final XmlPersoon persoon = new XmlPersoon();
		final XmlNaam naam = new XmlNaam();
		naam.setVoornaam("Test");
		naam.setAchternaam("User");
		persoon.setNaam(naam);

		final JAXBElement<XmlPersoon> persoonElement = new JAXBElement<>(
				new QName(NAMESPACE, "xmlPersoon"), XmlPersoon.class, persoon);

		jaxbDispatch.invoke(persoonElement);

		try {
			jaxbDispatch.invoke(persoonElement);
			fail("Duplicate should not be allowed..");
		} catch (SOAPFaultException e) {
			assertEquals(
					"S:ServercreateDubbele sleutel! Deze persoon bestaat al", e
							.getFault().getTextContent());
		}
	}

	/**
	 * Create and read the persoon.
	 * 
	 * @throws JAXBException
	 *             -
	 */
	@Test
	public void read() throws JAXBException, ParserConfigurationException,
			SAXException, IOException {

		doCreate("createReadPayload.xml");

		final CustomXmlPersoon persoon = doRead("Create", "Read");

		assertEquals("Create", persoon.getNaam().getVoornaam());
		assertEquals("Read", persoon.getNaam().getAchternaam());

		assertEquals("CreateRead 1", persoon.getAdres().getStraat());
		assertEquals("0001CR", persoon.getAdres().getPostcode());
		assertEquals("ReadCreate", persoon.getAdres().getWoonplaats());

		assertEquals(1, persoon.getDag());
		assertEquals("JANUARI", persoon.getMaand());
		assertEquals(1970, persoon.getJaar());

	}

	private CustomXmlPersoon doRead(final String voorNaam,
			final String achterNaam) throws JAXBException {

		final Service jaxwsService = Service.create(wsdlURL, serviceName);
		final JAXBContext jaxbContext = JAXBContext
				.newInstance("nl.ordina.jtechnologies.wscursus.soap");
		final Dispatch<Object> jaxbDispatch = jaxwsService.createDispatch(
				portName, jaxbContext, Service.Mode.PAYLOAD);

		final XmlNaam naam = new XmlNaam();
		naam.setVoornaam(voorNaam);
		naam.setAchternaam(achterNaam);

		final JAXBElement<XmlNaam> naamElement = new JAXBElement<>(new QName(
				NAMESPACE, "xmlNaam"), XmlNaam.class, naam);

		final JAXBElement<XmlPersoon> o = (JAXBElement<XmlPersoon>) jaxbDispatch
				.invoke(naamElement);
		return (CustomXmlPersoon) o.getValue();
	}

	/**
	 * Create person, read it, delete it, try to read it, and delete it again.
	 * 
	 * @throws ParserConfigurationException
	 *             -
	 * @throws SAXException
	 *             -
	 * @throws IOException
	 *             -
	 * @throws JAXBException
	 *             -
	 */
	@Test
	public void delete() throws ParserConfigurationException, SAXException,
			IOException, JAXBException {

		doCreate("createDeletePayload.xml");
		final XmlPersoon persoon = doRead("Create", "Delete");
		assertEquals("Create", persoon.getNaam().getVoornaam());
		assertEquals("Delete", persoon.getNaam().getAchternaam());

		final Service jaxwsService = Service.create(wsdlURL, serviceName);
		final JAXBContext jaxbContext = JAXBContext
				.newInstance("nl.ordina.jtechnologies.wscursus.soap");
		final Dispatch<Object> jaxbDispatch = jaxwsService.createDispatch(
				portName, jaxbContext, Service.Mode.PAYLOAD);

		final XmlNaam naam = new XmlNaam();
		naam.setVoornaam("Create");
		naam.setAchternaam("Delete");

		final JAXBElement<XmlNaam> naamElement = new JAXBElement<>(new QName(
				NAMESPACE, "deleteNaam"), XmlNaam.class, naam);
		jaxbDispatch.invoke(naamElement);

		final XmlPersoon persoon2 = doRead("Create", "Delete");
		assertNull(persoon2);

		// second delete should not give errors.
		jaxbDispatch.invoke(naamElement);

	}

	/**
	 * Create persoon, read it, update it , re-read it and check updated field.
	 * 
	 * @throws ParserConfigurationException
	 *             -
	 * @throws SAXException
	 *             -
	 * @throws IOException
	 *             -
	 * @throws JAXBException
	 *             -
	 */
	@Test
	public void update() throws ParserConfigurationException, SAXException,
			IOException, JAXBException {
		doCreate("createUpdatePayload.xml");
		final XmlPersoon persoon = doRead("Create", "Update");
		assertEquals("Create", persoon.getNaam().getVoornaam());
		assertEquals("Update", persoon.getNaam().getAchternaam());

		assertEquals("CreateUpdate", persoon.getAdres().getWoonplaats());

		persoon.getAdres().setWoonplaats("Nieuwegein");

		final Service jaxwsService = Service.create(wsdlURL, serviceName);
		final JAXBContext jaxbContext = JAXBContext
				.newInstance("nl.ordina.jtechnologies.wscursus.soap");
		final Dispatch<Object> jaxbDispatch = jaxwsService.createDispatch(
				portName, jaxbContext, Service.Mode.PAYLOAD);

		final JAXBElement<XmlPersoon> persoonElement = new JAXBElement<>(
				new QName(NAMESPACE, "updatePersoon"), XmlPersoon.class,
				persoon);
		jaxbDispatch.invoke(persoonElement);

		final XmlPersoon persoon2 = doRead("Create", "Update");

		assertEquals("Nieuwegein", persoon2.getAdres().getWoonplaats());

	}
}
