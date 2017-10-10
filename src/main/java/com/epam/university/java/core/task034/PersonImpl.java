package com.epam.university.java.core.task034;

import com.google.gson.annotations.SerializedName;

import java.util.Collection;
import java.util.HashSet;

public class PersonImpl implements Person {

    private int id;
    private String firstName;
    private String lastName;
    @SerializedName("phones")
    private Collection<PhoneNumber> phoneNumbers;

    /**
     * Get person id.
     *
     * @return person id
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Set person id.
     *
     * @param id person id
     */
    @Override
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get person first name.
     *
     * @return first name
     */
    @Override
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set person first name.
     *
     * @param firstName first name
     */
    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get person last name.
     *
     * @return last name
     */
    @Override
    public String getLastName() {
        return lastName;
    }

    /**
     * Set person last name.
     *
     * @param lastName last name
     */
    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get phone numbers collection.
     *
     * @return phone numbers
     */
    @Override
    public Collection<PhoneNumber> getPhoneNumbers() {
        return new HashSet<>(phoneNumbers);
    }

    /**
     * Set phone numbers collection.
     *
     * @param phoneNumbers phone numbers
     */
    @Override
    public void setPhoneNumbers(Collection<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = new HashSet<>(phoneNumbers);
    }
}
