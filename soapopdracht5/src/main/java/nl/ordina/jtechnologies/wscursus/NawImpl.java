package nl.ordina.jtechnologies.wscursus;

import javax.jws.WebService;

import nl.ordina.jtechnologies.wscursus.model.Persoon;
import nl.ordina.jtechnologies.wscursus.naw.CreateException;
import nl.ordina.jtechnologies.wscursus.soap.CreateFault;
import nl.ordina.jtechnologies.wscursus.soap.Naw;
import nl.ordina.jtechnologies.wscursus.soap.ObjectFactory;
import nl.ordina.jtechnologies.wscursus.soap.XmlNaam;
import nl.ordina.jtechnologies.wscursus.soap.XmlPersoon;
import nl.ordina.jtechnologies.wscursus.soap.mappings.XmlToDomainMapper;

/**
 * @author Ivo Woltring
 * @author Philippe Tjon
 */
@WebService(serviceName = "NawService", portName = "NawPort", endpointInterface = "nl.ordina.jtechnologies.wscursus.soap.Naw", targetNamespace = "http://wsdl.soap.wscursus.jtechnologies.ordina.nl/", wsdlLocation = "WEB-INF/wsdl/NawService.wsdl")
public class NawImpl implements Naw {
	private final nl.ordina.jtechnologies.wscursus.naw.Naw naw;
	private final ObjectFactory objectFactory;

	public NawImpl() {
		naw = new nl.ordina.jtechnologies.wscursus.naw.Naw();
		objectFactory = new ObjectFactory();
	}

	@Override
	public void create(XmlPersoon persoon) throws CreateFault {
		try {
			naw.create(XmlToDomainMapper.toPersoon(persoon));
			System.out.println("Persoon " + persoon.getNaam().getVoornaam()
					+ "created");
		} catch (CreateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public XmlPersoon read(XmlNaam naam) {
		Persoon result = naw.read(XmlToDomainMapper.toNaam(naam));
		return XmlToDomainMapper.fromPersoon(result);
	}

	@Override
	public void delete(XmlNaam naam) {
		System.out.println("delete");
	}

}
