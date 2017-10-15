package com.epam.university.java.core.task034;

import org.xml.sax.helpers.DefaultHandler;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;

public class Task034Impl implements Task034 {

    @Override
    public Person readWithSaxParser(DefaultHandler handler, String filepath) {
        try {
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            SAXParser parser = parserFactory.newSAXParser();
            parser.parse(getClass().getResourceAsStream(filepath), handler);
            if (handler instanceof SaxHandlerImpl) {
                return ((SaxHandlerImpl)handler).getPerson();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Person readWithJaxbParser(String filepath) {
        try {
            final JAXBContext jaxbContext = JAXBContext.newInstance(
                PersonImpl.class,
                PhoneNumberImpl.class
            );
            final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            final File file = Paths.get(getClass().getResource(filepath).getFile()).toFile();
            return (Person) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Person readWithStaxParser(XMLStreamReader streamReader)  {
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
                                person.setId(Integer.parseInt(streamReader.getAttributeValue(0)));
                                break;
                            case "person-phones":
                                phoneNumbers = new ArrayList<>();
                                break;
                            default:
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
                                PhoneNumber phoneNumber = new PhoneNumberImpl();
                                phoneNumber.setPhoneNumber(content);
                                phoneNumbers.add(phoneNumber);
                                break;
                            case "person-phones":
                                person.setPhoneNumbers(phoneNumbers);
                                break;
                            default:
                        }
                        break;
                    default:
                }

            }
        } catch (XMLStreamException | NullPointerException e) {
            e.printStackTrace();
        }
        return person;
    }
}
