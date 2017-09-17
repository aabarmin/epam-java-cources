package com.epam.university.java.core.task006;

import java.util.Collection;

/**
 * This task provide collection of measurements of voltage and amperage in resistance. Using
 * Least Square method determine value of resistance.
 */
public interface Task006 {
    /**
     * Calculate resistance by collection of measurements using Least Square method.
     * @param measurements collection of measurements
     * @return value of resistance
     * @throws IllegalArgumentException if measurements not provided
     */
    double resistance(Collection<Measurement> measurements);
}
