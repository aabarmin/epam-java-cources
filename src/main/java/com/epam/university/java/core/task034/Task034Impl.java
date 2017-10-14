package com.epam.university.java.core.task034;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;

/**
 * Created by Александр on 13.10.2017.
 */
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
        SaxHandlerImpl saxp;

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(getClass().getResourceAsStream(filepath), handler);

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ((SaxHandlerImpl)handler).getPerson();
    }

    /**
     * Parse XML document with JAXB parser.
     *
     * @param filepath path to file with xml
     * @return parsed data
     */
    @Override
    public Person readWithJaxbParser(String filepath) {
        return null;
    }

    /**
     * Parse document with StAX parser.
     *
     * @param streamReader stax reader
     * @return parsed data
     */
    @Override
    public Person readWithStaxParser(XMLStreamReader streamReader) {
        return null;
    }
}
