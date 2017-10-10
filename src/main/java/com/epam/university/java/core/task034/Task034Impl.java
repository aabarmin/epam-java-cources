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
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Read the XML.
 */
public class Task034Impl implements Task034 {

    /**
     * Parse XML document with SAX parser.
     * @param handler sax handler
     * @param filepath path to file with xml
     * @return parsed data
     */
    @Override
    public Person readWithSaxParser(DefaultHandler handler, String filepath) {
        try {
            SAXParserFactory parserFactor = SAXParserFactory.newInstance();
            SAXParser parser = parserFactor.newSAXParser();
            parser.parse(getClass().getResourceAsStream(filepath), handler);
            return (handler instanceof SaxHandlerImpl)
                ? ((SaxHandlerImpl)handler).getPerson()
                : null;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Parse XML document with JAXB parser.
     * @param filepath path to file with xml
     * @return parsed data
     */
    @Override
    public Person readWithJaxbParser(String filepath) {
        try {
            final JAXBContext jaxbContext = JAXBContext.newInstance(
                PersonImpl.class,
                PhoneNumberImpl.class
            );
            final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            final String resourcePath = getClass().getResource(filepath).getFile();
            return (Person) unmarshaller.unmarshal(Paths.get(resourcePath).toFile());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Parse document with StAX parser.
     * @param streamReader stax reader
     * @return parsed data
     */
    @Override
    public Person readWithStaxParser(XMLStreamReader streamReader) {
        try {
            Person person = null;
            Collection<PhoneNumber> phoneNumbers = null;
            String content = null;
            String localName;
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
                                person.setFirstName(content);
                                break;
                            case "last-name":
                                person.setLastName(content);
                                break;
                            case "person-phone":
                                PhoneNumber phoneNumber = new PhoneNumberImpl();
                                phoneNumber.setPhoneNumber(content);
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
            return person;
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return null;
    }

}
