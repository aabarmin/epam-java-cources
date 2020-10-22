package com.epam.university.java.core.task034;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlType(name = "person-phone")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class PhoneNumberImpl implements PhoneNumber {


    @XmlValue
    private String phoneNumber;

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }


    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
