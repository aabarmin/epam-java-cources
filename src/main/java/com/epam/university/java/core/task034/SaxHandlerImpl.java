package com.epam.university.java.core.task034;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import java.util.ArrayList;
import java.util.Collection;

public class SaxHandlerImpl extends SaxHandler {

    private String content;
    private Person person;
    private Collection<PhoneNumber> phoneNumbers = new ArrayList<>();

    public Person getPerson() {
        return person;
    }

    @Override
    public void startElement(String uri, String localName,
                             String qName, Attributes attributes) throws SAXException {
        if (qName.equals("person")) {
            person = new PersonImpl();
            person.setId(Integer.parseInt(attributes.getValue("id")));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
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
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        content = String.valueOf(ch, start, length);
    }

}
