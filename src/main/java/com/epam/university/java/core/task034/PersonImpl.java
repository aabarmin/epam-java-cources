package com.epam.university.java.core.task034;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Collection;

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonImpl implements Person {
    @XmlAttribute
    private int id;
    @XmlElement(name = "first-name")
    private String firstName;
    @XmlElement(name = "last-name")
    private String lastName;

    @XmlElementWrapper(name = "person-phones")
    @XmlElements({@XmlElement(type = PhoneNumberImpl.class, name = "person-phone")})
    private Collection<PhoneNumber> phoneNumbers = new ArrayList<>();

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
        this.phoneNumbers.addAll(phoneNumbers);
    }
}
