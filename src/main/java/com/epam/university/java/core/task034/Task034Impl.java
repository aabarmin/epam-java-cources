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
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Romin Nuro on 28.08.2020 12:57.
 */
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
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            URI fileUri = getClass().getResource(filepath).toURI();
            SAXParser parser = factory.newSAXParser();
            parser.parse(new File(fileUri), handler);
            return ((SaxHandlerImpl) handler).getPerson();
        } catch (ParserConfigurationException
                | SAXException
                | URISyntaxException
                | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Parse XML document with JAXB parser.
     *
     * @param filepath path to file with xml
     * @return parsed data
     */
    @Override
    public Person readWithJaxbParser(String filepath) {
        Person personFromXml = null;

        try {
            URI fileUri = getClass().getResource(filepath).toURI();
            JAXBContext context = JAXBContext.newInstance(PersonImpl.class);
            Unmarshaller um = context.createUnmarshaller();
            personFromXml = (Person) um.unmarshal(new File(fileUri));
        } catch (JAXBException | URISyntaxException e) {
            e.printStackTrace();
        }

        return personFromXml;
    }

    /**
     * Parse document with StAX parser.
     *
     * @param streamReader stax reader
     * @return parsed data
     */
    @Override
    public Person readWithStaxParser(XMLStreamReader streamReader) {
        Person person = new PersonImpl();
        Collection<PhoneNumber> phoneNumbers = new ArrayList<>();
        String currentElement = "";
        try {
            while (streamReader.hasNext()) {
                int next = streamReader.next();

                switch (next) {
                    case (XMLStreamConstants.START_ELEMENT) : {
                        currentElement = streamReader.getName().toString();
                        if (currentElement.equals("person")) {
                            person.setId(Integer.parseInt(streamReader.getAttributeValue(0)));
                        }
                        break;
                    }
                    case (XMLStreamConstants.CHARACTERS) : {
                        String data = streamReader.getText();

                        switch (currentElement) {
                            case ("first-name"): {
                                person.setFirstName(data);
                                break;
                            }
                            case ("last-name"): {
                                person.setLastName(data);
                                break;
                            }
                            case ("person-phone"): {
                                phoneNumbers.add(new PhoneNumberImpl(data));
                                break;
                            }
                            default: {
                                break;
                            }

                        }
                        break;
                    }
                    case (XMLStreamConstants.END_ELEMENT): {
                        currentElement = "";
                        break;
                    }
                    default: {
                        break;
                    }
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        person.setPhoneNumbers(phoneNumbers);
        return person;
    }
}
