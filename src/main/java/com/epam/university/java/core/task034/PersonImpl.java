package com.epam.university.java.core.task034;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

/**
 * Person model.
 */
@XmlRootElement(name = "person")
public class PersonImpl implements Person {

    private int id;
    private String firstName;
    private String lastName;
    private Collection<PhoneNumber> phoneNumbers;

    /**
     * Get person id.
     * @return person id
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Set person id.
     * @param id person id
     */
    @Override
    @XmlAttribute(name = "id")
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get person first name.
     * @return first name
     */
    @Override
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set person first name.
     * @param firstName first name
     */
    @Override
    @XmlElement(name = "first-name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get person last name.
     * @return last name
     */
    @Override
    public String getLastName() {
        return lastName;
    }

    /**
     * Set person last name.
     * @param lastName last name
     */
    @Override
    @XmlElement(name = "last-name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get phone numbers collection.
     * @return phone numbers
     */
    @Override
    public Collection<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    /**
     * Set phone numbers collection.
     * @param phoneNumbers phone numbers
     */
    @Override
    @XmlElementWrapper(name = "person-phones")
    @XmlElement(name = "person-phone", type = PhoneNumberImpl.class)
    public void setPhoneNumbers(Collection<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

}
