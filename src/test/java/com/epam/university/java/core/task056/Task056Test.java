package com.epam.university.java.core.task056;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Task056Test {
    private Task056 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task056.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void prescriptionFileIsNull() throws Exception {
        instance.necessaryMedication(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void necessaryMedicationListIsNull() throws Exception {
        instance.intervalBetweenMedication(null);
    }

    @Test
    public void testPrescription1() {
        final String prescription =
                getClass().getResource("/task056/prescription1.txt").getPath();
        final Collection<Integer> targetMedications = List.of(0);
        final Collection<Integer> resultMedications = instance.necessaryMedication(prescription);
        assertEquals(
                "Incorrect medications with prescription 1",
                targetMedications,
                resultMedications
        );

        final Collection<String> targetBreak = Collections.emptyList();
        final Collection<String> resultBreak =
                instance.intervalBetweenMedication(resultMedications);
        assertEquals(
                "Incorrect intervals with prescription 1",
                targetBreak,
                resultBreak
        );
    }

    @Test
    public void testPrescription2() {
        final String prescription =
                getClass().getResource("/task056/prescription2.txt").getPath();
        final Collection<Integer> targetMedications = List.of(2, 3);
        final Collection<Integer> resultMedications = instance.necessaryMedication(prescription);
        assertEquals(
                "Incorrect medications with prescription 2",
                targetMedications,
                resultMedications
        );

        final Collection<String> targetBreak = List.of("8-9");
        final Collection<String> resultBreak =
                instance.intervalBetweenMedication(resultMedications);
        assertEquals(
                "Incorrect intervals with prescription 2",
                targetBreak,
                resultBreak
        );
    }

    @Test
    public void testPrescription3() {
        final String prescription =
                getClass().getResource("/task056/prescription3.txt").getPath();
        final Collection<Integer> targetMedications = List.of(0, 1, 2, 3, 4, 5);
        final Collection<Integer> resultMedications = instance.necessaryMedication(prescription);
        assertEquals(
                "Incorrect medications with prescription 3",
                targetMedications,
                resultMedications
        );

        final Collection<String> targetBreak = Collections.emptyList();
        final Collection<String> resultBreak =
                instance.intervalBetweenMedication(resultMedications);
        assertEquals(
                "Incorrect intervals with prescription 3",
                targetBreak,
                resultBreak
        );
    }

    @Test
    public void testPrescription4() {
        final String prescription =
                getClass().getResource("/task056/prescription4.txt").getPath();
        final Collection<Integer> targetMedications = List.of(0, 1, 3, 4);
        final Collection<Integer> resultMedications = instance.necessaryMedication(prescription);
        assertEquals(
                "Incorrect medications with prescription 4",
                targetMedications,
                resultMedications
        );

        final Collection<String> targetBreak = List.of("5-7", "12-12", "17-18");
        final Collection<String> resultBreak =
                instance.intervalBetweenMedication(resultMedications);
        assertEquals(
                "Incorrect intervals with prescription 4",
                targetBreak,
                resultBreak
        );
    }

    @Test
    public void testPrescription5() {
        final String prescription =
                getClass().getResource("/task056/prescription5.txt").getPath();
        final Collection<Integer> targetMedications = List.of(0, 1, 3, 4);
        final Collection<Integer> resultMedications = instance.necessaryMedication(prescription);
        assertEquals(
                "Incorrect medications with prescription 5",
                targetMedications,
                resultMedications
        );

        final Collection<String> targetBreak = List.of("6-7", "12-12", "17-17");
        final Collection<String> resultBreak =
                instance.intervalBetweenMedication(resultMedications);
        assertEquals(
                "Incorrect intervals with prescription 5",
                targetBreak,
                resultBreak
        );
    }
}