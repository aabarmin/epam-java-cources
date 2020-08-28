package com.epam.university.java.core.task034;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 * Created by Romin Nuro on 28.08.2020 2:26.
 */
@XmlRootElement(name = "person-phone")
@XmlAccessorType(XmlAccessType.FIELD)
public class PhoneNumberImpl implements PhoneNumber {
    @XmlValue
    private String phoneNumber;

    public PhoneNumberImpl() {
    }

    public PhoneNumberImpl(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Get phone number value.
     *
     * @return number value
     */
    @Override
    public String getPhoneNumber() {
        return this.phoneNumber;
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
