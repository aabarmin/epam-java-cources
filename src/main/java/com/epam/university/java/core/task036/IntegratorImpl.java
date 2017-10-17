package com.epam.university.java.core.task036;

import com.epam.university.java.core.utils.common.Validator;

import java.util.function.Function;

/**
 * Class implements <code>Integrator</code>.
 */
public class IntegratorImpl implements Integrator {

    /**
     * Integrate function by trapezoidal rule.
     *
     * @param limitFirst  left limit
     * @param limitSecond right limit
     * @param adjustedN   adjusting value to set needed level of accuracy
     * @param function    function to integrate
     */
    private double integrateByTrapezoidalRule(double limitFirst, double
            limitSecond, int adjustedN, Function<Double, Double> function) {
        Validator.validateValueRange(limitFirst, -Double.MAX_VALUE,
                limitSecond, Validator.MESSAGE_IF_VIOLATES_LOWER_BORDER,
                Validator.MESSAGE_IF_VIOLATES_UPPER_BORDER);
        Validator.validateNotNegative(adjustedN, Validator.MESSAGE_IF_NEGATIVE);
        Validator.validateNotNull(function, Validator
                .MESSAGE_FOR_SOURCE_IF_NULL);
        double valueH = (limitSecond - limitFirst) / adjustedN;
        double sum = 0.5 * (function.apply(limitFirst) + function.apply(
                limitSecond));
        for (int i = 1; i < adjustedN; i++) {
            double valueX = limitFirst + valueH * i;
            sum = sum + function.apply(valueX);
        }
        return sum * valueH;
    }

    @Override
    public double integrate(double left, double right, Function<Double,
            Double> function) {
        return integrateByTrapezoidalRule(left, right, 9999999,
                function);
    }
}