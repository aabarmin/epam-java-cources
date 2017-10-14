package com.epam.university.java.core.task034;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;

public class Task034Impl implements Task034 {
    @Override
    public Person readWithSaxParser(DefaultHandler handler, String filepath) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(getClass().getResourceAsStream(filepath), handler);
            if (handler instanceof SaxHandlerImpl) {
                return ((SaxHandlerImpl) handler).getPerson();
            } else {
                return null;
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Person readWithJaxbParser(String filepath) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(
                    PersonImpl.class,
                    PhoneNumberImpl.class
            );
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (Person) unmarshaller.unmarshal(new File(getClass()
                    .getResource(filepath).toURI()));
        } catch (JAXBException | URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Person readWithStaxParser(XMLStreamReader streamReader) {
        Person person = null;
        Collection<PhoneNumber> phoneNumbers = null;
        String content = null;
        String localName;

        try {
            while (streamReader.hasNext()) {
                final int event = streamReader.next();
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        localName = streamReader.getLocalName();
                        switch (localName) {
                            case "person":
                                person = new PersonImpl();
                                person.setId(Integer.parseInt(streamReader.getAttributeValue(0)));
                                break;
                            case "person-phones":
                                phoneNumbers = new ArrayList<>();
                                break;
                            default:
                                break;
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        content = streamReader.getText().trim();
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        localName = streamReader.getLocalName();
                        switch (localName) {
                            case "first-name":
                                if (person != null) {
                                    person.setFirstName(content);
                                }
                                break;
                            case "last-name":
                                if (person != null) {
                                    person.setLastName(content);
                                }
                                break;
                            case "person-phone":
                                PhoneNumber phoneNumber = new PhoneNumberImpl();
                                phoneNumber.setPhoneNumber(content);
                                if (phoneNumbers != null) {
                                    phoneNumbers.add(phoneNumber);
                                }
                                break;
                            case "person-phones":
                                if (person != null) {
                                    person.setPhoneNumbers(phoneNumbers);
                                }
                                break;
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
            }
            return person;
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return null;
    }
}