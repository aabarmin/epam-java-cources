package com.epam.university.java.core.task034;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlType(name = "person-phone")
@XmlAccessorType(value = XmlAccessType.FIELD)
@JsonAutoDetect
public class PhoneNumberImpl implements PhoneNumber {

    @XmlValue
    @JsonValue
    private String phoneNumber;

    public PhoneNumberImpl() {
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
