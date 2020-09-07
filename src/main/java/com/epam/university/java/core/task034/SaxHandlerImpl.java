package com.epam.university.java.core.task034;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.Collection;

public class SaxHandlerImpl extends SaxHandler {

    private boolean bname;
    private boolean blastName;
    private boolean bphoneNumbers;
    private Collection<PhoneNumber> phoneNumbers;
    private PersonImpl person;

    @Override
    public void startElement(String uri,
                             String localName,
                             String qName,
                             Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("PERSON")) {
            person = new PersonImpl();
            person.setId(Integer.parseInt(attributes.getValue("id")));
        } else if (qName.equalsIgnoreCase("FIRST-NAME")) {
            bname = true;
        } else if (qName.equalsIgnoreCase("LAST-NAME")) {
            blastName = true;
        } else if (qName.equalsIgnoreCase("PERSON-PHONES")) {
            phoneNumbers = new ArrayList<>();
        } else if (qName.equalsIgnoreCase("PERSON-PHONE")) {
            bphoneNumbers = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bname) {
            person.setFirstName(new String(ch, start, length));
        } else if (blastName) {
            person.setLastName(new String(ch, start, length));
        } else if (bphoneNumbers) {
            phoneNumbers.add(new PhoneNumberImpl(new String(ch, start, length)));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("FIRST-NAME")) {
            bname = false;
        } else if (qName.equalsIgnoreCase("LAST-NAME")) {
            blastName = false;
        } else if (qName.equalsIgnoreCase("PERSON-PHONE")) {
            bphoneNumbers = false;
        } else if (qName.equalsIgnoreCase("PERSON-PHONES")) {
            person.setPhoneNumbers(phoneNumbers);
        }
    }

    public PersonImpl getPerson() {
        return person;
    }
}
