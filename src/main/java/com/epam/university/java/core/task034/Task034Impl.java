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
import java.util.ArrayList;
import java.util.List;

public class Task034Impl implements Task034 {
    /**
     * Parse XML document with SAX parser.
     *
     * @param handler  sax handler
     * @param filepath path to file with xml
     * @return parsed data
     */
    @Override
    public Person readWithSaxParser(DefaultHandler handler, String filepath) {

        Person person = null;

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            SaxHandlerImpl saxHandlerImpl = new SaxHandlerImpl();
            parser.parse(new File(getClass().getResource(filepath).toURI()), saxHandlerImpl);
            person = saxHandlerImpl.getResult();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } finally {
            return person;
        }

    }

    /**
     * Parse XML document with JAXB parser.
     *
     * @param filepath path to file with xml
     * @return parsed data
     */
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
        } catch (JAXBException e) {
            e.printStackTrace();
        } finally {
            return person;
        }

    }

    /**
     * Parse document with StAX parser.
     *
     * @param streamReader stax reader
     * @return parsed data
     */
    @Override
    public Person readWithStaxParser(XMLStreamReader streamReader) {

        Person person = null;
        List<PhoneNumber> phoneNumbers = null;
        String content = "";
        String localName = "";

        try {
            while (streamReader.hasNext()) {
                final int event = streamReader.next();
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        localName = streamReader.getLocalName();
                        switch (localName) {
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
                    case XMLStreamConstants.CHARACTERS:
                        content = streamReader.getText().trim();
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        localName = streamReader.getLocalName();
                        switch (localName) {
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
        } finally {
            return person;
        }

    }

}
