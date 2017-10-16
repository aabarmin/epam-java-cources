package com.epam.university.java.core.task034;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.List;

public class SaxHandlerImpl extends SaxHandler {

    public Person getPerson() {
        return person;
    }

    private Person person = new PersonImpl();
    private List<PhoneNumber> phoneNumbers = new ArrayList<>();
    private String thisElement = "";


    @Override
    public void startDocument() throws SAXException {
    }

    @Override
    public void startElement(String namespaceUrl, String localName,
                             String qName, Attributes atts) throws SAXException {
        thisElement = qName;
        if (qName.equals("person")) {
            person.setId(Integer.parseInt(atts.getValue("id")));
        }
    }

    @Override
    public void endElement(String namespaceUrl,
                           String localName, String qName) throws SAXException {
        thisElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (thisElement.equals("first-name")) {
            person.setFirstName(new String(ch, start, length));
        }
        if (thisElement.equals("last-name")) {
            person.setLastName(new String(ch, start, length));
        }
        if (thisElement.equals("person-phone")) {
            PhoneNumber phoneNumber = new PhoneNumberImpl(new String(ch, start, length));
            phoneNumbers.add(phoneNumber);
        }
    }

    @Override
    public void endDocument() {
        person.setPhoneNumbers(phoneNumbers);
    }
}
