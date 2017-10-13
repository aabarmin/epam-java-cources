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
import java.util.LinkedList;
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
        try {
            File xmlFile = new File(getClass().getResource(filepath).getFile());

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(xmlFile, handler);

            return PersonSingletonWrapper.getInstance().getPerson();
        } catch (Exception e) {
            throw new RuntimeException(e);
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
        try {
            File xmlFile = new File(getClass().getResource(filepath).getFile());

            JAXBContext jaxbContext = JAXBContext.newInstance(PersonImpl.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            return (Person) jaxbUnmarshaller.unmarshal(xmlFile);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
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
        PhoneNumber phone = null;
        List<PhoneNumber> phonesCollection = null;
        boolean isFirstName = false;
        boolean isLastName = false;
        boolean isPhonesArray = false;
        boolean isPhone = false;

        try {
            while (streamReader.hasNext()) {
                switch (streamReader.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT:
                        String elementName = streamReader.getLocalName();
                        switch (elementName) {
                            case "person":
                                person = new PersonImpl();
                                person.setId(
                                        Integer.parseInt(
                                                streamReader.getAttributeValue(0)
                                        )
                                );
                                break;
                            case "first-name":
                                isFirstName = true;
                                break;
                            case "last-name":
                                isLastName = true;
                                break;
                            case "person-phones":
                                phonesCollection = new LinkedList<>();
                                isPhonesArray = true;
                                break;
                            case "person-phone":
                                isPhone = true;
                                break;
                            default:
                                break;
                        }
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        assert person != null;
                        if (isFirstName) {
                            person.setFirstName(streamReader.getText());
                        } else if (isLastName) {
                            person.setLastName(streamReader.getText());
                        } else if (isPhonesArray && isPhone) {
                            phone = new PhoneNumberImpl();
                            phone.setPhoneNumber(streamReader.getText());
                        }
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        elementName = streamReader.getLocalName();
                        switch (elementName) {
                            case "first-name":
                                isFirstName = false;
                                break;
                            case "last-name":
                                isLastName = false;
                                break;
                            case "person-phones":
                                assert person != null;
                                person.setPhoneNumbers(phonesCollection);
                                isPhonesArray = false;
                                break;
                            case "person-phone":
                                assert phonesCollection != null;
                                phonesCollection.add(phone);
                                break;
                            default:
                                break;
                        }
                        break;

                    default:
                        break;
                }

                streamReader.next();
            }

            streamReader.close();
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        }

        return person;
    }
}