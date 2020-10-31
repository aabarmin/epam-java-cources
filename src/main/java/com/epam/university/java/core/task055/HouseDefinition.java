package com.epam.university.java.core.task055;

/**
 * Definition of house.
 */
public interface HouseDefinition {

    /**
     * Get address of house.
     * @return address of house.
     */
    String getAddress();

    /**
     * Get year when house was built. If field in XML contains several dates,
     * pick the last one.
     * @return year of house.
     */
    int getYear();

    /**
     * Get total floor space of the house.
     * @return total floor space of the house.
     */
    double getArea();

    /**
     * Set address of house.
     * @param address - address of house.
     */
    void setAddress(String address);

    /**
     * Set year when house was built. If field in XML contains several dates,
     * pick the last one.
     * @param year - year of construction of the house.
     */
    void setYear(int year);

    /**
     * Set total floor space of the house.
     * @param area - total floor space of the house.
     */
    void setArea(double area);

}
