package com.epam.university.java.core.task034;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

public class Task034Impl implements Task034 {
    @Override
    public Person readWithSaxParser(DefaultHandler handler, String filepath) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            URI fileUri = getClass().getResource(filepath).toURI();
            SAXParser parser = factory.newSAXParser();
            parser.parse(new File(fileUri), handler);
        } catch (ParserConfigurationException | SAXException | IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return ((SaxHandlerImpl) handler).getPerson();
    }

    @Override
    public Person readWithJaxbParser(String filepath) {
        Person person = null;
        try {
            JAXBContext context = JAXBContext.newInstance(PersonImpl.class, PhoneNumberImpl.class);
            URI fileUri = getClass().getResource(filepath).toURI();
            File file = new File(fileUri);
            person = (Person) context.createUnmarshaller()
                    .unmarshal(new FileReader(file));
        } catch (JAXBException | FileNotFoundException | URISyntaxException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public Person readWithStaxParser(XMLStreamReader streamReader) throws XMLStreamException {
        Person person = new PersonImpl();
        PhoneNumber phoneNumber;
        List<PhoneNumber> phoneNumbers = new LinkedList<>();

        while (streamReader.hasNext()) {
            int event = streamReader.next();
            if (event == XMLEvent.START_ELEMENT
                    && "person".equalsIgnoreCase(streamReader.getLocalName())) {
                person.setId(Integer.parseInt(streamReader.getAttributeValue(null, "id")));
            }
            if (event == XMLEvent.START_ELEMENT
                    && "first-name".equalsIgnoreCase(streamReader.getLocalName())) {
                person.setFirstName(streamReader.getElementText());
            }
            if (event == XMLEvent.START_ELEMENT
                    && "last-name".equalsIgnoreCase(streamReader.getLocalName())) {
                person.setLastName(streamReader.getElementText());
            }
            if (event == XMLEvent.START_ELEMENT
                    && "person-phone".equalsIgnoreCase(streamReader.getLocalName())) {
                phoneNumber = new PhoneNumberImpl();
                phoneNumber.setPhoneNumber(streamReader.getElementText());
                phoneNumbers.add(phoneNumber);
            }
        }
        person.setPhoneNumbers(phoneNumbers);
        return person;
    }

}
