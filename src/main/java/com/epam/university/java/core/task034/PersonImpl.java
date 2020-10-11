package com.epam.university.java.core.task034;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;
import java.util.LinkedList;

@JsonRootName(value = "person")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@XmlRootElement(name = "person")
//@XmlType(propOrder = {"id", "firstName", "lastName", "phoneNumbers"})
public class PersonImpl implements Person {
    private int id;
    private String firstName;
    private String lastName;
    Collection<PhoneNumber> phoneNumbers = new LinkedList<>();


    @Override
    public int getId() {
        return this.id;
    }

    @XmlAttribute
    @Override
    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @XmlElement(name = "first-name")
    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    @Override
    public String getLastName() {
        return this.lastName;
    }

    @XmlElement(name = "last-name")
    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Override
    public Collection<PhoneNumber> getPhoneNumbers() {
        return this.phoneNumbers;
    }

    @JsonSetter(value = "phones")
    @XmlElementWrapper(name = "person-phones")
    @XmlElements({@XmlElement(type = PhoneNumberImpl.class, name = "person-phone")})
    @Override
    public void setPhoneNumbers(Collection<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
