package com.epam.university.java.core.task034;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@JsonAutoDetect
@XmlType(name = "person")
@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonImpl implements Person {

    @XmlAttribute()
    private int id;
    @XmlElement(name = "first-name")
    private String firstName;
    @XmlElement(name = "last-name")
    private String lastName;

    @JsonProperty("phones")
    @XmlElementWrapper(name = "person-phones")
    @XmlElements({@XmlElement(type = PhoneNumberImpl.class, name = "person-phone")})
    List<PhoneNumber> phoneNumbers;

    /**
     * Default constructor for Jackson.
     */
    public PersonImpl() {
    }

    /**
     * Json creator for Jackson Deserialization.
     * @param id Person id
     * @param firstName person first name
     * @param lastName person last name
     * @param phoneNumbers person phone numbers
     */
    @JsonCreator
    public PersonImpl(
            @JsonProperty("id") int id,
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("phones") List<PhoneNumberImpl> phoneNumbers) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumbers = new ArrayList<>();
        this.phoneNumbers.addAll(phoneNumbers);
    }

    @Override
    public int getId() {
        return id;
    }


    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }


    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }


    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public Collection<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    @Override
    public void setPhoneNumbers(Collection<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = (List<PhoneNumber>) phoneNumbers;
    }

}
