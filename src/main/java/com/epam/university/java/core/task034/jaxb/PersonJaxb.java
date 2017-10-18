package com.epam.university.java.core.task034.jaxb;

import com.epam.university.java.core.task034.Person;
import com.epam.university.java.core.task034.PhoneNumber;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

/**
 * Created by Александр on 09.10.2017.
 * Person model for jaxb parser.
 */
@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.UNDEFINED)
public class PersonJaxb implements Person {
    @XmlAttribute
    private int id;

    @XmlElement(name = "first-name")
    private String firstName;

    @XmlElement(name = "last-name")
    private String lastName;

    @XmlElementWrapper(name = "person-phones")
    @XmlElement(name = "person-phone", type = PhoneNumberJaxb.class)
    Collection<PhoneNumber> phoneNumbers;

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
        return phoneNumbers;
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
