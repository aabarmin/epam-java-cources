package com.epam.university.java.core.task035;

import com.epam.university.java.core.task034.PhoneNumber;

/**
 * Created by Александр on 09.10.2017.
 * POJO for
 */
public class PhoneNumberPOJO implements PhoneNumber {
    private String phoneNumber;

    /**
     * Constructor without parametrs.
     */
    public PhoneNumberPOJO() {
    }

    /**
     * Constructor with string.
     *
     * @param phoneNumber string
     */
    public PhoneNumberPOJO(String phoneNumber) {
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
