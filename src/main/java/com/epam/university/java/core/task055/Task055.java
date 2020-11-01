package com.epam.university.java.core.task055;

/**
 * Read XML.
 * Implement a programme that get a data about Saint Petersburg residential buildings from
 * XML file with buildings passports.
 * Table comes from: https://data.gov.spb.ru/opendata/7840013199-passports_houses/.
 */
public interface Task055 {

    /**
     * Create Xml processor for file with specified path.
     * @param path file to read.
     * @return ProcessingContext which will be perform processing to the file.
     */
    ProcessingContext createContext(String path);
}
