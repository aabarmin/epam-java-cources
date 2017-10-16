package com.epam.university.java.core.task034;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.Collection;

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.UNDEFINED)
public class PersonImpl implements Person {
    @XmlAttribute
    private int id;
    @XmlElement(name = "first-name")
    private String firstName;
    @XmlElement(name = "last-name")
    private String lastName;
    @XmlElementWrapper(name = "person-phones")
    @XmlElement(name = "person-phone", type = PhoneNumberImpl.class)
    private Collection<PhoneNumber> phoneNumbers = new ArrayList<>();

    public void addPhoneNumber(PhoneNumber phoneNumber) {
        phoneNumbers.add(phoneNumber);
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
        this.phoneNumbers = new ArrayList<PhoneNumber>(phoneNumbers);

    }

    @Override
    public void addElement(String elementName, String value) {
        switch (elementName) {
            case "first-name": {
                this.setFirstName(value);
                break;
            }
            case "last-name": {
                this.setLastName(value);
                break;
            }
            case "person-phone": {
                PhoneNumber phoneNumber = new PhoneNumberImpl(value);
                phoneNumbers.add(phoneNumber);
                break;
            }
            case "person-phones": {
                this.setPhoneNumbers(phoneNumbers);
                break;
            }
            default: {
                break;
            }
        }
    }
}
