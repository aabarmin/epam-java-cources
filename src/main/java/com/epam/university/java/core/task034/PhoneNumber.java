package com.epam.university.java.core.task034;

import com.sun.xml.txw2.annotation.XmlElement;

/**
 * Phone number model.
 */

public interface PhoneNumber {
    /**
     * Get phone number value.
     * @return number value
     */
    String getPhoneNumber();

    @XmlElement
    /**
     * Set phone number value.
     * @param phoneNumber number value
     */
    void setPhoneNumber(String phoneNumber);
}
