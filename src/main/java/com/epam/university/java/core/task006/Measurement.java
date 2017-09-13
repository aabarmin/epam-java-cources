package com.epam.university.java.core.task006;

/**
 * Stores data about measurements.
 */
public class Measurement {
    private final double amperage;
    private final double voltage;

    /**
     * Constructor with all parameters.
     * @param amperage amperage value
     * @param voltage voltage value
     */
    public Measurement(double amperage, double voltage) {
        this.amperage = amperage;
        this.voltage = voltage;
    }

    public double getAmperage() {
        return amperage;
    }

    public double getVoltage() {
        return voltage;
    }
}
