package com.epam.university.java.core.task034;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import javax.xml.bind.annotation.XmlValue;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PhoneNumberImpl implements PhoneNumber {
    private String phoneNumber;

    public PhoneNumberImpl() {
    }

    public PhoneNumberImpl(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


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
