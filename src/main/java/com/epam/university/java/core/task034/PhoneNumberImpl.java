package com.epam.university.java.core.task034;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@JsonAutoDetect
@XmlType(name = "person-phone")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class PhoneNumberImpl implements PhoneNumber {


    @JsonProperty
    @XmlValue
    private String phoneNumber;

    /**
     * Default phone number constructor.
     */
    public PhoneNumberImpl() {
    }

    /**
     * Constructor with String for phone number.
      * @param phoneNumber phone number string
     */
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
