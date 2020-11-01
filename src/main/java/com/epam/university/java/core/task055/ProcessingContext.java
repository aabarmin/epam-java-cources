package com.epam.university.java.core.task055;

import java.util.Collection;

/**
 * Implement methods to get information from Xml file.
 */
public interface ProcessingContext {

    /**
     * Find oldest living houses in Saint Petersburg.
     * @return collection of definitions such houses.
     */
    Collection<HouseDefinition> oldestHouses();

    /**
     * Calculate average age of living houses for each district of the city.
     * @param district - Cyrillic name of district. "Город" - must calculate
     *                 average age for houses entire city.
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
