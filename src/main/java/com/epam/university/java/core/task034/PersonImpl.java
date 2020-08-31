package com.epam.university.java.core.task034;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

/**
 * Created by Romin Nuro on 28.08.2020 2:24.
 */
@XmlRootElement(name = "person")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class PersonImpl implements Person {
    @JsonProperty("id")
    @XmlAttribute
    private int id;

    @JsonProperty("firstName")
    @XmlElement(name = "first-name")
    private String firstName;

    @JsonProperty("lastName")
    @XmlElement(name = "last-name")
    private String lastName;

    @JsonProperty("phones")
    @XmlElementWrapper(name = "person-phones")
    @XmlElements({@XmlElement(type = PhoneNumberImpl.class, name = "person-phone")})
    private Collection<PhoneNumber> phoneNumbers;

    @Override
    public String toString() {
        return "PersonImpl{"
                + "id=" + id
                + ", firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + ", phoneNumbers=" + phoneNumbers + '}';
    }

    /**
     * Get person id.
     *
     * @return person id
     */
    @Override
    public int getId() {
        return this.id;
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
        return this.firstName;
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
        return this.lastName;
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
        return this.phoneNumbers;
    }

    /**
     * Set phone numbers collection.
     *
     * @param phoneNumbers phone numbers
     */
    @Override
    public void setPhoneNumbers(Collection<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
