package com.epam.university.java.core.task006;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.assertEquals;


/**
 * Created by Aleksandr_Barmin on 9/6/2017.
 */
public class Task006Test {
    public static final double DELTA = 0.0001;
    private Task006 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task006.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkMeasurementsIsNull() throws Exception {
        instance.resistance(null);
    }

    @Test
    public void checkResistanceWithEmptyList() throws Exception {
        assertEquals("Error in measurement",
                0.0,
                instance.resistance(Collections.emptyList()),
                DELTA
        );
    }

    @Test
    public void checkResistanceFirst() throws Exception {
        final Collection<Measurement> measurements = new ArrayList<>();
        measurements.add(new Measurement(0, 2.1));
        measurements.add(new Measurement(1, 2.4));
        measurements.add(new Measurement(2, 2.6));
        measurements.add(new Measurement(4, 2.8));
        measurements.add(new Measurement(5, 3.0));
        //
        assertEquals("Error in first measurement",
                0.165,
                instance.resistance(measurements),
                DELTA
        );
    }

    @Test
    public void checkResistanceSecond() throws Exception {
        final Collection<Measurement> measurements = new ArrayList<>();
        measurements.add(new Measurement(1, 5.3));
        measurements.add(new Measurement(2, 6.3));
        measurements.add(new Measurement(3, 4.8));
        measurements.add(new Measurement(4, 3.8));
        measurements.add(new Measurement(5, 3.3));
        //
        assertEquals("Error in second measurement",
                -0.65,
                instance.resistance(measurements),
                DELTA
        );
    }

    @Test
    public void checkResistanceThird() throws Exception {
        /**
         * Assumption, that measurements are noised.
         */
        final Collection<Measurement> measurements = new ArrayList<>();
        measurements.add(new Measurement(0,5.3));
        measurements.add(new Measurement(0,6.3));
        measurements.add(new Measurement(0,4.8));
        measurements.add(new Measurement(0,3.8));
        measurements.add(new Measurement(0,3.3));
        //
        assertEquals("Error in third measurement",
                0.0,
                instance.resistance(measurements),
                DELTA
        );
    }
}