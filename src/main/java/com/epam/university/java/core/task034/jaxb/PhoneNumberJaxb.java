package com.epam.university.java.core.task034.jaxb;

import com.epam.university.java.core.task034.PhoneNumber;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 * Created by Александр on 09.10.2017.
 * Implementation of PhoneNumber class
 */
@XmlRootElement(name = "person-phone")
@XmlAccessorType(XmlAccessType.FIELD)
public class PhoneNumberJaxb implements PhoneNumber {
    @XmlValue
    private String phoneNumber;

    /**
     * Constructor without parametrs.
     */
    public PhoneNumberJaxb() {
    }

    /**
     * Constructor with string.
     *
     * @param phoneNumber string
     */
    public PhoneNumberJaxb(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Get phone number value.
     *
     * @return number value
     */
    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set phone number value.
     *
     * @param phoneNumber number value
     */
    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
