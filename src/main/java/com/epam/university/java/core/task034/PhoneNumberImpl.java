package com.epam.university.java.core.task034;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 * Phone number model.
 */
@XmlRootElement(name = "person-phone")
public class PhoneNumberImpl implements PhoneNumber {

    private String phoneNumber;

    /**
     * Get phone number value.
     * @return number value
     */
    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set phone number value.
     * @param phoneNumber number value
     */
    @Override
    @XmlValue
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return phoneNumber;
    }

}
