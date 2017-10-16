package com.epam.university.java.core.task034;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.List;

public class SaxHandlerImpl extends SaxHandler {

    private Person person;
    private List<PhoneNumber> phoneNumbers;
    private String elementContent;

    public Person getResult() {
        return person;
    }

    /**
     * Receive notification of the start of an element.
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        switch (qName) {
            case "person":
                person = new PersonImpl();
                person.setId(Integer.parseInt(attributes.getValue("id")));
                break;
            case "person-phones":
                phoneNumbers = new ArrayList<>();
                break;
            default:
                break;
        }
    }

    /**
     * Receive notification of the end of an element.
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "first-name":
                person.setFirstName(elementContent);
                break;
            case "last-name":
                person.setLastName(elementContent);
                break;
            case "person-phone":
                PhoneNumber phoneNumber = new PhoneNumberImpl(elementContent);
                phoneNumbers.add(phoneNumber);
                break;
            case "person-phones":
                person.setPhoneNumbers(phoneNumbers);
                break;
            default:
                break;
        }
    }

    /**
     * Receive notification of character data inside an element.
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        elementContent = String.copyValueOf(ch, start, length).trim();
    }
}
