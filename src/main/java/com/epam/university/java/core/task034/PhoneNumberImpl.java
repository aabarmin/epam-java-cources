package com.epam.university.java.core.task034;

import com.epam.university.java.core.utils.common.Validator;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 * Class implements <code>PhoneNumber</code> interface.
 */
@XmlRootElement(name = "person-phone")
public class PhoneNumberImpl implements PhoneNumber {
    private String phoneNumber;

    /**
     * Get phone number.
     *
     * @return <code>String</code> phone number
     */
    @Override
    @XmlValue
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set phone number.
     *
     * @param phoneNumber number value
     * @throws IllegalArgumentException if parameter is null
     */
    @Override
    public void setPhoneNumber(String phoneNumber) {
        Validator.validateNotNull(phoneNumber,
                Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return phoneNumber;
    }
}