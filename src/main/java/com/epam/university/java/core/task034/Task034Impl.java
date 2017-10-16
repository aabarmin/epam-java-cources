package com.epam.university.java.core.task034;

import org.xml.sax.helpers.DefaultHandler;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import static com.epam.university.java.core.Callback.runObject;

public class Task034Impl implements Task034 {
    @Override
    public Person readWithSaxParser(DefaultHandler handler, String filepath) {
        return runObject(() -> {
            final SAXParserFactory factory = SAXParserFactory.newInstance();
            final SAXParser parser = factory.newSAXParser();
            final String contextPath = getClass().getResource(filepath).getFile();
            parser.parse(new File(contextPath), handler);
            return ((SaxHandlerImpl) handler).getPerson();
        });
    }

    @Override
    public Person readWithJaxbParser(String filepath) {
        return runObject(() -> {
            final JAXBContext jaxbContext = JAXBContext.newInstance(PersonImpl.class);
            final Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            final String contextPath = getClass().getResource(filepath).getFile();
            return (Person) jaxbUnmarshaller.unmarshal(new File(contextPath));
        });
    }

    @Override
    @SuppressWarnings("unchecked")
    public Person readWithStaxParser(XMLStreamReader streamReader) {

        final Person person = new PersonImpl();
        final List<PhoneNumber> phoneNumbers = new ArrayList<>();

        return runObject(() -> {

            final XMLInputFactory factory = XMLInputFactory.newInstance();
            final XMLEventReader eventReader =
                    factory.createXMLEventReader(streamReader);
            boolean bFirstName = false;
            boolean bLastName = false;
            boolean bPhone = false;
            while (eventReader.hasNext()) {

                XMLEvent event = eventReader.nextEvent();

                switch (event.getEventType()) {

                    case XMLStreamConstants.START_ELEMENT:
                        StartElement startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();


                        if (qName.equalsIgnoreCase("person")) {
                            Iterator<Attribute> attributes = startElement.getAttributes();
                            String id = attributes.next().getValue();
                            person.setId(Integer.parseInt(id));
                        } else if (qName.equalsIgnoreCase("first-name")) {
                            bFirstName = true;
                        } else if (qName.equalsIgnoreCase("last-name")) {
                            bLastName = true;
                        } else if (qName.equalsIgnoreCase("person-phone")) {
                            bPhone = true;
                        }
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        Characters characters = event.asCharacters();
                        if (bFirstName) {
                            person.setFirstName(characters.getData());
                            bFirstName = false;
                        }
                        if (bLastName) {
                            person.setLastName(characters.getData());
                            bLastName = false;
                        }
                        if (bPhone) {
                            phoneNumbers.add(new PhoneNumberImpl(characters.getData()));
                            bPhone = false;
                        }

                        break;

                    case XMLStreamConstants.END_ELEMENT:
                    default:
                        break;
                }
            }

            person.setPhoneNumbers(phoneNumbers);
            return person;
        });
    }
}
