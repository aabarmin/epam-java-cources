package com.epam.university.java.core.task034;

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

import com.epam.university.java.core.utils.common.Validator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * Class implements <code>Task034</code> interface.
 */
public class Task034Impl implements Task034 {
    @Override
    public Person readWithSaxParser(DefaultHandler handler, String filepath) {
        Validator.validateNotNull(handler, filepath,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NULL);
        SAXParser saxParser;
        try {
            saxParser = SAXParserFactory.newInstance().newSAXParser();
            saxParser.parse(getClass().getResourceAsStream(filepath), handler);
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            ex.printStackTrace();
        }
        return ((SaxHandlerImpl) handler).getPerson();
    }

    @Override
    public Person readWithJaxbParser(String filepath) {
        Validator.validateNotNull(filepath,
                Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(PersonImpl.class,
                    PhoneNumberImpl.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            String resourcePath = getClass().getResource(filepath).getFile();
            String osAppropriatePath = System.getProperty("os.name")
                    .contains("indow") ? resourcePath.substring(1)
                    : resourcePath;
            return (Person) unmarshaller.unmarshal(Paths.get(osAppropriatePath)
                    .toFile());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Person readWithStaxParser(XMLStreamReader streamReader) {
        Validator.validateNotNull(streamReader,
                Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        Person person = null;
        PhoneNumber phoneNumber;
        try {
            XMLEventReader xmlEventReader = XMLInputFactory.newInstance()
                    .createXMLEventReader(streamReader);
            while (xmlEventReader.hasNext()) {
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    if (startElement.getName().getLocalPart().equals
                            ("person")) {
                        person = new PersonImpl();
                        Attribute idAttr = startElement.getAttributeByName(
                                new QName("id"));
                        if (idAttr != null) {
                            person.setId(Integer.parseInt(idAttr.getValue()));
                        }
                    } else if (startElement.getName().getLocalPart().equals
                            ("first-name")) {
                        if (person == null) {
                            person = new PersonImpl();
                        }
                        xmlEvent = xmlEventReader.nextEvent();
                        person.setFirstName(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals
                            ("last-name")) {
                        if (person == null) {
                            person = new PersonImpl();
                        }
                        xmlEvent = xmlEventReader.nextEvent();
                        person.setLastName(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart()
                            .equals("person-phone")) {
                        if (person == null) {
                            person = new PersonImpl();
                        }
                        xmlEvent = xmlEventReader.nextEvent();
                        phoneNumber = new PhoneNumberImpl();
                        phoneNumber.setPhoneNumber(xmlEvent.asCharacters()
                                .getData());
                        person.getPhoneNumbers().add(phoneNumber);
                    }
                }
            }
        } catch (XMLStreamException ex) {
            ex.printStackTrace();
        }
        return person;
    }
}