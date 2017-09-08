package com.epam.university.java.core.task004;

import com.epam.university.java.core.validation.Validator;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Александр on 06.09.2017.
 */
public class Task004Impl implements Task004 {
    private static Validator VALIDATOR =Validator.newInstance(Task004Impl.class);

    /**
     * Find intersection of two arrays.
     *
     * @param first  first array
     * @param second second array
     * @return array of common elements
     * @throws IllegalArgumentException if parameters not provided
     */
    @Override
    public String[] intersection(String[] first, String[] second) {
        VALIDATOR.assertNotNull(first);
        VALIDATOR.assertNotNull(second);

        Set<String> result = new LinkedHashSet<>();
        result.addAll(Arrays.asList(first));
        result.retainAll(Arrays.asList(second));

        return result.toArray(new String[result.size()]);
    }

    /**
     * Find union of two arrays.
     *
     * @param first  first array
     * @param second second array
     * @return array of all elements of array
     * @throws IllegalArgumentException if parameters not provided
     */
    @Override
    public String[] union(String[] first, String[] second) {
        VALIDATOR.assertNotNull(first);
        VALIDATOR.assertNotNull(second);

        Set<String> result = new LinkedHashSet<>();
        result.addAll(Arrays.asList(first));
        result.addAll(Arrays.asList(second));

        return result.toArray(new String[result.size()]);
    }
}
