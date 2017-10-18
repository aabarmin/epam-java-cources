package com.epam.university.java.core.task034;

import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessType;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Implementation class for Person.
 *
 * @author Sergei Titov
 */
@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonImpl implements Person {

    @XmlAttribute
    private int id;

    @XmlElement(name = "first-name")
    private String firstName;

    @XmlElement(name = "last-name")
    private String lastName;

    @SerializedName("phones")
    @XmlElementWrapper(name = "person-phones")
    @XmlElements({
            @XmlElement(type = PhoneNumberImpl.class, name = "person-phone")
    })
    private Collection<PhoneNumber> phoneNumbers = new ArrayList<>();


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
    @Override
    public void setPhoneNumbers(Collection<PhoneNumber> phoneNumbers) {}
}
