package com.epam.university.java.core.task034;

/**
 * Created by Александр on 09.10.2017.
 * Implementation of PhoneNumber class
 */
public class PhoneNumberImpl implements PhoneNumber, Cloneable {
    private String phoneNumber;

    /**
     * Constructor without parametrs.
     */
    public PhoneNumberImpl() {
    }

    /**
     * Constructor with string.
     *
     * @param phoneNumber string
     */
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
