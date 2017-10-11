package com.epam.university.java.core.task036;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Integration algorithm implementation.
 */
public interface Integrator extends BiFunction<Double, Function<Double, Double>, Double> {
}
