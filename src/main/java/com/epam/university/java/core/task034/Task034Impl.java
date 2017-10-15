package com.epam.university.java.core.task034;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import static javax.xml.stream.XMLStreamConstants.CHARACTERS;
import static javax.xml.stream.XMLStreamConstants.START_ELEMENT;

/**
 * {@inheritDoc}
 */
public class Task034Impl implements Task034 {

    /**
     * {@inheritDoc}
     */
    @Override
    public Person readWithSaxParser(DefaultHandler handler, String filepath) {
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxFactory.newSAXParser();
            SaxHandlerImpl saxHandler = new SaxHandlerImpl();
            saxParser.parse(Task034Impl.class.getResourceAsStream(filepath), saxHandler);
            return saxHandler.getPerson();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person readWithJaxbParser(String filepath) {
        try {
            JAXBContext context = JAXBContext.newInstance(PersonImpl.class, PhoneNumberImpl.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            PersonImpl impl = (PersonImpl) unmarshaller.unmarshal(
                    Task034Impl.class.getResourceAsStream(filepath));
            return impl;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person readWithStaxParser(XMLStreamReader streamReader) {
        Person person = null;
        Collection<PhoneNumber> phones = new ArrayList<>();
        try {
            int event = streamReader.getEventType();
            while (true) {
                switch (event) {
                    case START_ELEMENT:
                        switch (streamReader.getName().toString()) {
                            case "person":
                                person = new PersonImpl();
                                String attributeValue = streamReader.getAttributeValue(0);
                                person.setId(Integer.parseInt(attributeValue));
                                break;
                            case "person-phones":
                                person.setPhoneNumbers(phones);
                                break;
                            case "first-name":
                                streamReader.next();
                                if (streamReader.getEventType() == CHARACTERS) {
                                    person.setFirstName(streamReader.getText());
                                }
                                break;
                            case "last-name":
                                streamReader.next();
                                if (streamReader.getEventType() == CHARACTERS) {
                                    person.setLastName(streamReader.getText());
                                }
                                break;
                            case "person-phone":
                                streamReader.next();
                                if (streamReader.getEventType() == CHARACTERS) {
                                    PhoneNumberImpl phoneNumber = new PhoneNumberImpl();
                                    phoneNumber.setPhoneNumber(streamReader.getText());
                                    person.getPhoneNumbers().add(phoneNumber);
                                }
                                break;
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
                if (!streamReader.hasNext()) {
                    break;
                }
                event = streamReader.next();
            }
        } finally {
            try {
                streamReader.close();
            } catch (XMLStreamException e) {
                e.printStackTrace();
            }
            return person;
        }
    }
}
