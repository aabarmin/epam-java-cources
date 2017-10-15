package com.epam.university.java.core.task034;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlValue;

/**
 * Implementation class for PhoneNumber.
 *
 * @author Sergei Titov
 */
@XmlRootElement(name = "person-phone")
@XmlAccessorType(XmlAccessType.FIELD)
public class PhoneNumberImpl implements PhoneNumber {

    @XmlValue
    private String phoneNumber;

    /**
     * Defaul constructor.
     */
    public PhoneNumberImpl() {}


    /**
     * Constructor from phone number string.
     *
     * @param phoneNumber is a string, consisting of phone number
     */
    PhoneNumberImpl(String phoneNumber) {

        this.phoneNumber = phoneNumber;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String getPhoneNumber() {

        return phoneNumber;
    }


    /**w
     * {@inheritDoc}
     */
    @Override
    public void setPhoneNumber(String phoneNumber) {

        this.phoneNumber = phoneNumber;
    }
}
