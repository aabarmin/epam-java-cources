package com.epam.university.java.core.task055;

import java.util.Collection;

/**
 * Read XML.
 * Implement a programme that get a data about Saint Petersburg residential buildings from
 * XML file with buildings passports.
 * Table comes from: https://data.gov.spb.ru/opendata/7840013199-passports_houses/.
 */
public interface Task055 {

    /**
     * Set filepath to read.
     * @param path - full path to file to read.
     */
    void setInputFile(String path);

    /**
     * Find oldest living houses in Saint Petersburg.
     * @return collection of definitions such houses.
     */
    Collection<HouseDefinition> oldestHouses();

    /**
     * Calculate average age of living houses for each district of the city.
     * @param district - Cyrillic name of district. "Город" - must calculate
     *                 average age for entire city.
     * @return - average age of houses in particular district.
     */
    int averageAge(String district);

    /**
     * Find the biggest house in the city.
     * @return definition of house that have biggest total floor space.
     */
    HouseDefinition biggestTotalFloorSpace();

    /**
     * Find the smallest house in the city.
     * @return definition of house that have smallest total floor space.
     */
    HouseDefinition smallestTotalFloorSpace();

    /**
     * Count all living houses in the city.
     * @return number of living houses.
     */
    int totalCountHouses();

    /**
     * Count all houses which have communal flats.
     * @return number of such houses.
     */
    int totalCountHousesWithCommunalFlats();

}
