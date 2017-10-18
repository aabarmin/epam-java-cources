package com.epam.university.java.core.task034;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.List;

public class SaxHandlerImpl extends SaxHandler {

    private String element = "";
    private Person person = new PersonImpl();
    private List<PhoneNumber> phones = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equals("person")) {
            person.setId(Integer.parseInt(attributes.getValue("id")));
        } else {
            element = qName;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        element = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        switch (element) {
            case "first-name":
                person.setFirstName(new String(ch,start,length));
                break;
            case "last-name":
                person.setLastName(new String(ch,start,length));
                break;
            case "person-phone":
                PhoneNumber phoneNumber = new PhoneNumberImpl();
                phoneNumber.setPhoneNumber(new String(ch,start,length));
                phones.add(phoneNumber);
                break;
            default:
                break;

        }
    }

    public Person getPerson() {
        person.setPhoneNumbers(phones);
        return person;
    }
}
