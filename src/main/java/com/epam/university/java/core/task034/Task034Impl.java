package com.epam.university.java.core.task034;

import org.xml.sax.helpers.DefaultHandler;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

public class Task034Impl implements Task034 {

    @Override
    public Person readWithSaxParser(DefaultHandler handler, String filepath) {
        Person person = null;
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            SaxHandlerImpl saxHandlerImpl = new SaxHandlerImpl();
            parser.parse(new File(getClass().getResource(filepath).toURI()), saxHandlerImpl);
            person = saxHandlerImpl.getPerson();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public Person readWithJaxbParser(String filepath) {
        Person person = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(
                    PersonImpl.class,
                    PhoneNumberImpl.class
            );
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            person = (Person) unmarshaller
                    .unmarshal(new File(getClass().getResource(filepath).toURI()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
public Person readWithStaxParser(XMLStreamReader streamReader) {

        Person person = null;
        String content = null;
        Collection<PhoneNumber> phoneNumbers = null;

        try {
            while (streamReader.hasNext()) {
                final int event = streamReader.next();
                switch (event) {
                    case XMLStreamConstants.CHARACTERS:
                        content = streamReader.getText().trim();
                        break;

                    case XMLStreamConstants.START_ELEMENT:
                        String current = streamReader.getLocalName();
                        switch (current) {
                            case "person":
                                person = new PersonImpl();
                                person.setId(Integer.parseInt(streamReader
                                        .getAttributeValue("","id")));
                                break;
                            case "person-phones":
                                phoneNumbers = new ArrayList<>();
                                break;
                            default:
                                break;
                        }
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        current = streamReader.getLocalName();
                        switch (current) {
                            case "first-name":
                                person.setFirstName(content);
                                break;
                            case "last-name":
                                person.setLastName(content);
                                break;
                            case "person-phone":
                                PhoneNumber phoneNumber = new PhoneNumberImpl(content);
                                phoneNumbers.add(phoneNumber);
                                break;
                            case "person-phones":
                                person.setPhoneNumbers(phoneNumbers);
                                break;
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return person;
    }
}
