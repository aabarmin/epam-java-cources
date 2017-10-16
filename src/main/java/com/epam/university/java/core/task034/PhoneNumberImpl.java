package com.epam.university.java.core.task034;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "person-phone")
@XmlAccessorType(XmlAccessType.FIELD)
public class PhoneNumberImpl implements PhoneNumber {

    @XmlValue
    private String phoneNumber;

    public PhoneNumberImpl() {
    }

    @Override
    public String toString() {
        return "PhoneNumberImpl{" + "phoneNumber='" + phoneNumber + '\'' + '}';
    }

    public PhoneNumberImpl(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
