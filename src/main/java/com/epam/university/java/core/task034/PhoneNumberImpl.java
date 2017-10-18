package com.epam.university.java.core.task034;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "person-phone")
public class PhoneNumberImpl implements PhoneNumber {

    private String phoneNumber;

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    @XmlValue
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "PhoneNumber:  " + phoneNumber;
    }
}
