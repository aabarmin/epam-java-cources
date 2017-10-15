package com.epam.university.java.core.task034;


import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.annotations.SerializedName;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

/**
 * {@inheritDoc}
 */
@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonImpl implements Person {
    public PersonImpl() {
    }
    @SerializedName("id")
    @XmlAttribute
    private int id;

    @SerializedName("firstName")
    @XmlElement(name = "first-name")
    private String firstName;

    @SerializedName("lastName")
    @XmlElement(name = "last-name")
    private String lastName;

    @JsonDeserialize(contentAs = PhoneNumberImpl.class)
    @SerializedName("phones")
    @XmlElement(name = "person-phone", type = PhoneNumberImpl.class)
    @XmlElementWrapper(name = "person-phones")
    private Collection<PhoneNumber> phoneNumbers;

    /**
     * {@inheritDoc}
     */
    @Override

    public int getId() {
        return id;
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public void setId(int id) {
        this.id = id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getFirstName() {
        return firstName;
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLastName() {
        return lastName;
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    /**
     * {@inheritDoc}
     */
    @JsonSetter("phones")
    @Override
    public void setPhoneNumbers(Collection<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
