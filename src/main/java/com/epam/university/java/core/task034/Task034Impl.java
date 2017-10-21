package com.epam.university.java.core.task034;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class Task034Impl implements Task034 {
    private Person person;
    private Collection<PhoneNumber> phoneNumbers = new ArrayList<>();
    @Override
    public Person readWithSaxParser(DefaultHandler handler, String filepath) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SaxHandlerImpl handle = (SaxHandlerImpl) handler;
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();

            InputSource source = new InputSource(
                    getClass().getResourceAsStream(filepath)
            );
            saxParser.parse(source, handler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return handle.getPerson();
    }

    @Override
    public Person readWithJaxbParser(String filepath) {
        InputSource source = new InputSource(
                getClass().getResourceAsStream(filepath)
        );
        try {
        JAXBContext jaxbContext = JAXBContext.newInstance(PersonImpl.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        this.person = (PersonImpl) jaxbUnmarshaller.unmarshal(source);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public Person readWithStaxParser(XMLStreamReader streamReader) {
        boolean firstName = false;
        boolean lastName = false;
        boolean phoneNumber = false;
        person = new PersonImpl();
        try {
            while (streamReader.hasNext()) {
                int xmlEvent = streamReader.next();
                if (xmlEvent == XMLStreamConstants.START_ELEMENT) {
                    if (streamReader.getLocalName().equals("person")) {
                        person.setId(Integer.parseInt(streamReader.getAttributeValue(0)));
                    } else if(streamReader.getLocalName().equals("first-name")) {
                        firstName = true;
                    } else if(streamReader.getLocalName().equals("last-name")) {
                        lastName = true;
                    } else if(streamReader.getLocalName().equals("person-phone")) {
                        phoneNumber = true;
                    }
                } else if(xmlEvent == XMLStreamConstants.CHARACTERS) {
                    if (firstName) {
                        person.setFirstName(streamReader.getText());
                        firstName = false;
                    } else if (lastName) {
                        person.setLastName(streamReader.getText());
                        lastName = false;
                    } else if (phoneNumber) {
                        phoneNumbers.add(new PhoneNumberImpl(streamReader.getText()));
                        phoneNumber = false;
                    }
                }
            }
            person.setPhoneNumbers(phoneNumbers);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return person;
    }
}
