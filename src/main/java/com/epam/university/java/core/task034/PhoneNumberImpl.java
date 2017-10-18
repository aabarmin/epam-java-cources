package com.epam.university.java.core.task034;


import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 * {@inheritDoc}
 */
@XmlRootElement(name = "person-phone")
public class PhoneNumberImpl implements PhoneNumber {

    private String phoneNumber;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public PhoneNumberImpl(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public PhoneNumberImpl() {
    }

    /**
     * {@inheritDoc}
     */
    @XmlValue
    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return phoneNumber;
    }
}
