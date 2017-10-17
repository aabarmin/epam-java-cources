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
import java.util.List;

public class Task034Impl implements Task034 {

    @Override
    public Person readWithSaxParser(DefaultHandler handler, String filepath) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(getClass().getResourceAsStream(filepath), handler);
            if (handler instanceof SaxHandlerImpl) {
                return ((SaxHandlerImpl) handler).getPerson();
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Person readWithJaxbParser(String filepath) {
        try {
            JAXBContext jaxb = JAXBContext.newInstance(PersonImpl.class,PhoneNumberImpl.class);
            Unmarshaller unmarshaller = jaxb.createUnmarshaller();
            String resourcePath = getClass().getResource(filepath).getFile();
            return (Person) unmarshaller.unmarshal(Paths.get(resourcePath).toFile());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Person readWithStaxParser(XMLStreamReader streamReader) {
        Person person = new PersonImpl();
        String element = "";
        List<PhoneNumber> phones = new ArrayList<>();
        try {
            while (streamReader.hasNext()) {
                final int event = streamReader.next();
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        if (streamReader.getName().toString().equals("person")) {
                            person.setId(Integer.parseInt(streamReader.getAttributeValue(0)));
                        } else {
                            element = streamReader.getName().toString();
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        element = "";
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        switch (element) {
                            case "person id":
                                person.setId(new Integer(streamReader.getText().trim()));
                                break;
                            case "first-name":
                                person.setFirstName(streamReader.getText().trim());
                                break;
                            case "last-name":
                                person.setLastName(streamReader.getText().trim());
                                break;
                            case "person-phone":
                                PhoneNumber phoneNumber = new PhoneNumberImpl();
                                phoneNumber.setPhoneNumber(streamReader.getText().trim());
                                phones.add(phoneNumber);
                                break;
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
            }
            person.setPhoneNumbers(phones);
            return person;
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return null;
    }
}
