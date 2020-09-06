package com.epam.university.java.core.task034;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Task034Impl implements Task034 {
    @Override
    public Person readWithSaxParser(DefaultHandler handler, String filepath) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        Person person = null;
        try {
            InputStream stream = getClass().getResourceAsStream(filepath);
            SAXParser parser = factory.newSAXParser();
            parser.parse(stream, handler);
            SaxHandlerImpl saxHandler = (SaxHandlerImpl) handler;
            person = saxHandler.getPerson();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public Person readWithJaxbParser(String filepath) {
        JAXBContext jaxbContext;
        PersonImpl person = null;
        try {
            jaxbContext = JAXBContext.newInstance(PersonImpl.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            URI fileUri = getClass().getResource(filepath).toURI();

            person = (PersonImpl) jaxbUnmarshaller.unmarshal(new File(fileUri));

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public Person readWithStaxParser(XMLStreamReader streamReader) {

        XMLInputFactory factory = XMLInputFactory.newInstance();
        PersonImpl person = new PersonImpl();
        List<PhoneNumber> phoneNumberList = new ArrayList<>();
        try {
            XMLEventReader reader = factory.createXMLEventReader(streamReader);
            while (reader.hasNext()) {
                XMLEvent event = reader.nextEvent();
                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    String elementName = startElement.getName().getLocalPart();
                    if (elementName.equalsIgnoreCase("person")) {
                        Attribute id = startElement.getAttributeByName(QName.valueOf("id"));
                        person.setId(Integer.parseInt(id.getValue()));
                    } else if (elementName.equalsIgnoreCase("first-name")) {
                        event = reader.nextEvent();
                        person.setFirstName(event.asCharacters().getData());
                    } else if (elementName.equalsIgnoreCase("last-name")) {
                        event = reader.nextEvent();
                        person.setLastName(event.asCharacters().getData());
                    } else if (elementName.equalsIgnoreCase("person-phone")) {
                        event = reader.nextEvent();
                        phoneNumberList.add(new PhoneNumberImpl(event.asCharacters().getData()));
                    }
                }

            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        person.setPhoneNumbers(phoneNumberList);

        return person;
    }
}
