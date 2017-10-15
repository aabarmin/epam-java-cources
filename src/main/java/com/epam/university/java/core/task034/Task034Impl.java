package com.epam.university.java.core.task034;

import org.xml.sax.InputSource;
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
import java.util.ArrayList;
import java.util.Collection;

public class Task034Impl implements Task034 {
    @Override
    public Person readWithSaxParser(DefaultHandler handler, String filepath) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            InputSource source = new InputSource(
                    getClass().getResourceAsStream(filepath)
            );
            parser.parse(source, handler);
            return ((SaxHandlerImpl) handler).getPerson();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Person readWithJaxbParser(String filepath) {
        try {
            JAXBContext context = JAXBContext.newInstance(PersonImpl.class, PhoneNumberImpl.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (Person) unmarshaller.unmarshal(getClass().getResourceAsStream(filepath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Person readWithStaxParser(XMLStreamReader streamReader) {
        Person person = new PersonImpl();
        Collection<PhoneNumber> phoneNumbers = new ArrayList<>();
        String currentNode = null;
        try {
            while (streamReader.hasNext()) {
                int next = streamReader.next();
                if (XMLStreamConstants.START_ELEMENT == next) {
                    currentNode = streamReader.getName().toString();
                    if ("person".equals(currentNode)) {
                        person.setId(Integer.valueOf(streamReader.getAttributeValue(0)));
                    }
                }

                if (XMLStreamConstants.END_ELEMENT == next) {
                    currentNode = null;
                }

                if (XMLStreamConstants.CHARACTERS == next) {
                    if (currentNode == null) {
                        continue;
                    }
                    String value = streamReader.getText();
                    switch (currentNode){
                        case "first-name":
                            person.setFirstName(value);
                            break;
                        case "last-name":
                            person.setLastName(value);
                            break;
                        case "person-phone":
                            phoneNumbers.add(new PhoneNumberImpl(value));
                            break;
                        default:
                            break;
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
