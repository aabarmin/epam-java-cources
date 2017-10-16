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
import java.io.IOException;


public class Task034Impl implements Task034 {
    @Override
    public Person readWithSaxParser(DefaultHandler handler, String filepath) {
        try {
            final SAXParserFactory factory = SAXParserFactory.newInstance();
            final SAXParser parser = factory.newSAXParser();
            InputSource source = new InputSource(
                    getClass().getResourceAsStream(filepath)
            );
            parser.parse(source, handler);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ((SaxHandlerImpl) handler).getPerson();
    }

    @Override
    public Person readWithJaxbParser(String filepath) {
        Person person = new PersonImpl();
        try {
            JAXBContext context = JAXBContext.newInstance(PersonImpl.class, PhoneNumberImpl.class);
            final Unmarshaller unmarshaller = context.createUnmarshaller();
            person = (PersonImpl) unmarshaller.unmarshal(
                    getClass().getResourceAsStream(filepath)
            );
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public Person readWithStaxParser(XMLStreamReader streamReader) {
        Person person = new PersonImpl();
        String value = "";
        try {
            while (streamReader.hasNext()) {
                final int next = streamReader.next();
                switch (next) {
                    case XMLStreamConstants.START_ELEMENT: {
                        switch (streamReader.getName().toString()) {
                            case "person": {
                                person.setId(
                                        Integer.parseInt(
                                                streamReader.getAttributeValue("", "id")
                                        )
                                );
                                break;
                            }
                            default: {
                                break;
                            }
                        }
                        break;
                    }
                    case XMLStreamConstants.CHARACTERS: {
                        value = streamReader.getText();
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT: {
                        person.addElement(streamReader.getName().toString(), value);
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
        return person;
    }
}
