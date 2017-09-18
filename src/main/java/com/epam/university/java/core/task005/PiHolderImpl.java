package com.epam.university.java.core.task005;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * PiHolder implementation.
 */

@Setter
@Getter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
final class PiHolderImpl implements PiHolder {

    /**
     * numerator.
     */
    private int first;

    /**
     * denominator.
     */
    private int second;
}
