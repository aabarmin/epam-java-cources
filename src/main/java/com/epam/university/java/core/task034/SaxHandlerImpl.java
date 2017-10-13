package com.epam.university.java.core.task034;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.LinkedList;
import java.util.List;

public class SaxHandlerImpl extends SaxHandler {
    private Person person = null;
    private PhoneNumber phone = null;
    private List<PhoneNumber> phonesCollection = null;
    private String elementName = null;
    private boolean isFirstName = false;
    private boolean isLastName = false;
    private boolean isPhonesArray = false;
    private boolean isPhone = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        elementName = qName;

        if (elementName.equals("person")) {
            person = new PersonImpl();
            person.setId(
                    Integer.parseInt(
                            attributes.getValue("id")
                    )
            );
        } else if (elementName.equals("first-name")) {
            isFirstName = true;
        } else if (elementName.equals("last-name")) {
            isLastName = true;
        } else if (elementName.equals("person-phones")) {
            phonesCollection = new LinkedList<>();
            isPhonesArray = true;
        } else if (elementName.equals("person-phone")) {
            isPhone = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        assert person != null;
        if (isFirstName) {
            person.setFirstName(
                    new String(ch, start, length)
            );
        } else if (isLastName) {
            person.setLastName(
                    new String(ch, start, length)
            );
        } else if (isPhonesArray && isPhone) {
            phone = new PhoneNumberImpl();
            phone.setPhoneNumber(
                    new String(ch, start, length)
            );
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementName = qName;

        if (elementName.equals("first-name")) {
            isFirstName = false;
        } else if (elementName.equals("last-name")) {
            isLastName = false;
        } else if (elementName.equals("person-phones")) {
            assert person != null;
            person.setPhoneNumbers(phonesCollection);
            isPhonesArray = false;
        } else if (elementName.equals("person-phone")) {
            assert phonesCollection != null;
            phonesCollection.add(phone);
        }
    }

    // life-hack to return parsed object
    @Override
    public void endDocument() throws SAXException {
        PersonSingletonWrapper.getInstance().setPerson(person);
    }
}
