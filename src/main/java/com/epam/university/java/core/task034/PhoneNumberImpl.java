package com.epam.university.java.core.task034;

import javax.xml.bind.annotation.XmlValue;

public class PhoneNumberImpl implements PhoneNumber {
    private String phoneNumber;

    @Override
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    @XmlValue
    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
