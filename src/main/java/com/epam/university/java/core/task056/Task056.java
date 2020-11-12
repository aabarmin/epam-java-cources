package com.epam.university.java.core.task056;

import java.util.Collection;

/**
 * Treatment.
 *
 * <p>
 *     Boris felt sick. He went to the hospital for treatment. At the hospital the doctor prescribed
 *     Boris to take n-packs of pills and designated a certain period of days to take each pack.
 *     During treatment the following conditions must be observed:
 *     1. Boris can only take one pill a day.
 *     2. Pills from n-pack should be taken only during the period of days prescribed by the doctor.
 *     3. Boris cannot start a new pack if the last one isn't finished.
 *     4. It's forbidden to take pills from different packs at the same time.
 *
 *     Boris needs to choose a combination of packs to maximize the number of pills.
 *
 *     In addition, it's prohibited to drink alcohol on the days of taking medication. Boris quite
 *     upset about this fact.
 *
 *     If the number of packs is more than one, then Boris need to determine the interval between
 *     taking medication, if such exists.
 *
 *          For example:
 *          The doctor prescribed 4 packs of pills. Each line contains the number of pills in the
 *          pack and period for taking medication (separated by space).
 *
 *          Prescription:
 *          3 1-3
 *          10 3-12
 *          5 6-10
 *          3 12-14
 *
 *          Packs: [0, 2, 3] (the number of pills in this combination is maximum)
 *          Interval between medication: [4-5, 11-11] (these days Boris can treat himself with apple
 *          cider)
 * </p>
 */

public interface Task056 {
    /**
     * Determination of the required packs of pills.
     * @param prescriptionFile prescription from the doctor
     * @return collection with packs numbers. Numbering started from 0
     * @throws IllegalArgumentException if input parameter is null
     */
    Collection<Integer> necessaryMedication(String prescriptionFile);

    /**
     * Determination of intervals between medication. Each interval is a string in the following
     * format:
     *      "from-to" (both inclusive)
     * @param necessaryMedication treatment course
     * @return collection of intervals or empty collection. Numbering started from 1
     * @throws IllegalArgumentException if input parameter is null
     */
    Collection<String> intervalBetweenMedication(Collection<Integer> necessaryMedication);
}
