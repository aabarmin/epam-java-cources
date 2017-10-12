package com.epam.university.java.core.task034;

import java.util.Collection;

/**
 * Person model.
 */
public interface Person {
    /**
     * Get person id.
     * @return person id
     */
    int getId();

    /**
     * Set person id.
     * @param id person id
     */
    void setId(int id);

    /**
     * Get person first name.
     * @return first name
     */
    String getFirstName();

    /**
     * Set person first name.
     * @param firstName first name
     */
    void setFirstName(String firstName);

    /**
     * Get person last name.
     * @return last name
     */
    String getLastName();

    /**
     * Set person last name.
     * @param lastName last name
     */
    void setLastName(String lastName);

    /**
     * Get phone numbers collection.
     * @return phone numbers
     */
    Collection<PhoneNumber> getPhoneNumbers();

    /**
     * Set phone numbers collection.
     * @param phoneNumbers phone numbers
     */
    void setPhoneNumbers(Collection<PhoneNumber> phoneNumbers);
}
