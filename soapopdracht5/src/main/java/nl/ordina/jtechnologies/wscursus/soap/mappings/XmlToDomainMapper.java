package nl.ordina.jtechnologies.wscursus.soap.mappings;

import javax.xml.datatype.XMLGregorianCalendar;

import nl.ordina.jtechnologies.wscursus.model.Adres;
import nl.ordina.jtechnologies.wscursus.model.Date;
import nl.ordina.jtechnologies.wscursus.model.Maand;
import nl.ordina.jtechnologies.wscursus.model.Naam;
import nl.ordina.jtechnologies.wscursus.model.Persoon;
import nl.ordina.jtechnologies.wscursus.soap.ObjectFactory;
import nl.ordina.jtechnologies.wscursus.soap.XmlAdres;
import nl.ordina.jtechnologies.wscursus.soap.XmlNaam;
import nl.ordina.jtechnologies.wscursus.soap.XmlPersoon;

public class XmlToDomainMapper {

	public static Persoon toPersoon(XmlPersoon xml) {
		Persoon result = new Persoon();
		result.setNaam(toNaam(xml.getNaam()));
		result.setAdres(toAdres(xml.getAdres()));
		result.setGeboorteDatum(toGeboortedatum(xml.getGeboortedatum()));
		return result;
	}

	public static Naam toNaam(XmlNaam xml) {
		if (xml == null)
			return null;

		return new Naam(xml.getVoornaam(), xml.getAchternaam());
	}

	private static Adres toAdres(XmlAdres xml) {
		if (xml == null)
			return null;

		return new Adres(xml.getStraat(), xml.getWoonplaats(),
				xml.getPostcode());
	}

	private static Date toGeboortedatum(XMLGregorianCalendar xml) {
		if (xml == null)
			return null;

		return new Date(xml.getDay(), Maand.valueOf(month[xml.getMonth() - 1]),
				xml.getYear());
	}

	private static final String[] month = { Maand.JANUARI.name(),
			Maand.FEBRUARI.name(), Maand.MAART.name(), Maand.APRIL.name(),
			Maand.MEI.name(), Maand.JUNI.name(), Maand.JULI.name(),
			Maand.AUGUSTUS.name(), Maand.SEPTEMBER.name(),
			Maand.OKTOBER.name(), Maand.NOVEMBER.name(), Maand.DECEMBER.name() };

	public static XmlPersoon fromPersoon(Persoon persoon) {
		XmlPersoon result = new ObjectFactory().createXmlPersoon();
		result.setNaam(fromNaam(persoon.getNaam()));
		// result.setAdres(fromAdres(persoon.getAdres()));
		// result.setGeboorteDatum(toGeboortedatum(xml.getGeboortedatum()));
		return result;
	}

	private static XmlNaam fromNaam(Naam naam) {
		if (naam == null)
			return null;

		XmlNaam result = new ObjectFactory().createXmlNaam();
		result.setVoornaam(naam.getNaam());
		result.setAchternaam(naam.getAchternaam());
		return result;
	}
}
