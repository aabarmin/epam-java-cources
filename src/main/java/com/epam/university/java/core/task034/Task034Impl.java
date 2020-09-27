package com.epam.university.java.core.task034;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Author Dmitry Novikov 15-Sep-20.
 */
public class Task034Impl implements Task034 {
    @Override
    public Person readWithSaxParser(DefaultHandler handler, String filepath)
            throws ParserConfigurationException, SAXException, IOException, URISyntaxException {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        URI fileUri = getClass().getResource(filepath).toURI();
        File file = new File(fileUri);

        parser.parse(file, handler);

        return ((SaxHandlerImpl) handler).getResult();
    }

    @Override
    public Person readWithJaxbParser(String filepath) throws JAXBException, URISyntaxException {
        JAXBContext jc = JAXBContext.newInstance(PersonImpl.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();

        URI fileUri = getClass().getResource(filepath).toURI();
        File file = new File(fileUri);

        Person person = (Person) unmarshaller.unmarshal(file);

        return person;
    }

    @Override
    public Person readWithStaxParser(XMLStreamReader streamReader) throws XMLStreamException {
        Person person = new PersonImpl();
        Collection<PhoneNumber> phoneNumbers = new ArrayList<>();
        String currentElement = "";


        while (streamReader.hasNext()) {

            int next = streamReader.next();
            switch (next) {
                case (XMLStreamConstants.START_ELEMENT): {
                    currentElement = streamReader.getName().toString();
                    if (currentElement.equals("person")) {
                        person.setId(Integer.parseInt(streamReader.getAttributeValue(0)));
                    }
                    break;
                }
                case (XMLStreamConstants.CHARACTERS): {
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
        person.setPhoneNumbers(phoneNumbers);
        return person;
    }
}
