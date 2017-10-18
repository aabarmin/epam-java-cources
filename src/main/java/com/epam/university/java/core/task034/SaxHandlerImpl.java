package com.epam.university.java.core.task034;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import javax.xml.stream.events.Attribute;
import java.util.ArrayList;

/**
 * Created by Александр on 13.10.2017.
 * SAX parser
 */
public class SaxHandlerImpl extends SaxHandler {
    private String thisElement = "";
    private Person person;

    /**
     * Get parsed person.
     * @return PersonImpl object
     */
    public Person getPerson() {
        return person;
    }

    @Override
    public void startElement(String namespaceURI,
                             String localName,
                             String qName,
                             Attributes atts)
            throws SAXException {
        thisElement = qName;
        if (qName == "person") {
            person = new PersonImpl();
            person.setId(Integer.valueOf(atts.getValue("id")));
        }
        if (qName == "person-phones")  {
            person.setPhoneNumbers(new ArrayList<PhoneNumber>());
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (thisElement.equals("id")) {
            person.setId(new Integer(new String(ch, start, length)));
        }
        if (thisElement.equals("first-name")) {
            person.setFirstName(new String(ch, start, length));
        }
        if (thisElement.equals("last-name")) {
            person.setLastName(new String(ch, start, length));
        }
        if (thisElement.equals("person-phone")) {
            person.getPhoneNumbers().add(new PhoneNumberImpl(new String(ch, start, length)));
        }
    }

    @Override
    public void endElement(String namespaceURI,
                           String localName,
                           String qName) throws
            SAXException {
        thisElement = "";
    }

}
