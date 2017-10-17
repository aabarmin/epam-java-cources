package com.epam.university.java.core.task034;

import com.epam.university.java.core.utils.common.Validator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Class implements <code>Person</code> interface.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name = "person")
public class PersonImpl implements Person {
    private int id;
    private String firstName;
    private String lastName;
    private Collection<PhoneNumber> phoneNumbers = new ArrayList<>();

    /**
     * Get person id.
     *
     * @return <code>int</code> person id
     */
    @Override
    @XmlAttribute(name = "id")
    public int getId() {
        return id;
    }

    /**
     * Set person id.
     *
     * @param id person id
     * @throws IllegalArgumentException if parameter is negative
     */
    @Override
    public void setId(int id) {
        Validator.validateNotNegative(id, Validator.MESSAGE_IF_NEGATIVE);
        this.id = id;
    }

    /**
     * Get person's first name.
     *
     * @return <code>String</code> first name
     */
    @Override
    @XmlElement(name = "first-name")
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set person's first name.
     *
     * @param firstName first name
     * @throws IllegalArgumentException if parameter is null
     */
    @Override
    public void setFirstName(String firstName) {
        Validator.validateNotNull(firstName,
                Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        this.firstName = firstName;
    }

    /**
     * Get person's last name.
     *
     * @return <code>String</code> last name
     */
    @Override
    @XmlElement(name = "last-name")
    public String getLastName() {
        return lastName;
    }

    /**
     * Set person's last name.
     *
     * @param lastName last name
     * @throws IllegalArgumentException if parameter is null
     */
    @Override
    public void setLastName(String lastName) {
        Validator.validateNotNull(lastName,
                Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        this.lastName = lastName;
    }

    /**
     * Get phone numbers collection.
     *
     * @return phone numbers
     */
    @Override
    @XmlElementWrapper(name = "person-phones")
    @XmlElement(name = "person-phone", type = PhoneNumberImpl.class)
    public Collection<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    /**
     * Set phone numbers collection.
     *
     * @param phoneNumbers phone numbers
     * @throws IllegalArgumentException if parameter is null
     */
    @Override
    public void setPhoneNumbers(Collection<PhoneNumber> phoneNumbers) {
        Validator.validateNotNull(phoneNumbers,
                Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        Validator.validateEmpty(phoneNumbers,
                Validator.MESSAGE_IF_COLLECTION_EMPTY);
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString() {
        return "PersonImpl{id=" + id + ", firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\'' + ", phoneNumbers="
                + phoneNumbers + '}';
    }
}