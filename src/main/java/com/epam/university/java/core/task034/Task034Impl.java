package com.epam.university.java.core.task034;

import java.io.IOException;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.Consumer;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Task034Impl implements Task034 {

    private static Person person;

    public static void setPerson(Person person) {
        Task034Impl.person = person;
    }

    @Override
    public Person readWithSaxParser(DefaultHandler handler, String filepath) {
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = parserFactory.newSAXParser();
            parser.parse(getClass().getResourceAsStream(filepath), handler);

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return handler instanceof SaxHandlerImpl
            ? ((SaxHandlerImpl) handler).personMapper.get() :
            null;
    }

    @Override
    public Person readWithJaxbParser(String filepath) {
        Person person = new PersonImpl();

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(PersonImpl.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            person = (Person) unmarshaller.unmarshal(getClass().getResourceAsStream(filepath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return person;
    }

    @Override
    public Person readWithStaxParser(XMLStreamReader streamReader) {

        Deque<String> values = new LinkedList<>();

        BuilderMapper<Person> personMapper = (new PersonMapper()).newInstance();

        Map<Integer, Consumer<XMLStreamReader>> streamMapper = new HashMap<>();

        streamMapper.put(XMLStreamConstants.CHARACTERS, (r) -> values.push(r.getText().trim()));
        streamMapper.put(XMLStreamConstants.START_ELEMENT, (r) -> {
            for (int i = 0; i < r.getAttributeCount(); i++) {
                QName attributeName = r.getAttributeName(i);
                personMapper.set(attributeName.getLocalPart(), r.getAttributeValue(i));
            }
        });
        streamMapper.put(XMLStreamConstants.END_ELEMENT,
            (r) -> personMapper.set(r.getLocalName(), values.pop()));

        try {
            while (streamReader.hasNext()) {
                int next = streamReader.next();
                if (streamMapper.containsKey(next)) {
                    streamMapper.get(next).accept(streamReader);
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

        return personMapper.get();
    }
}
