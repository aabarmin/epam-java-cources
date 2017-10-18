package com.epam.university.java.core.task034;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class SaxHandlerImpl extends SaxHandler {

    public BuilderMapper<Person> personMapper = (new PersonMapper()).newInstance();
    private String value;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
        throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            personMapper.set(attributes.getQName(i), attributes.getValue(i));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        personMapper.set(qName, value);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        value = new String(ch, start, length);
    }

}
