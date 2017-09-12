package com.epam.university.java.core.validation;

import java.util.function.Predicate;

/**
 * Created by Александр on 06.09.2017.
 *
 * Use:
 *  private static final Validator VALIDATOR = Validator.newInstance(ValidationClient.class);
 *  VALIDATOR.assertNotNull(value);
 */
public class Validator {
    private Class targetClass;

    protected Validator(Class targetClass) {
        this.targetClass = targetClass;
    }

    public static Validator newInstance(Class clazz) {
        return new Validator(clazz);
    }

    /**
     * Test parametr not null.
     *
     * @param value to test
     */
    public void assertNotNull(Object value) {
        if (value == null) {
            throw new IllegalArgumentException(String.format(
                    "Exception in class %s",
                    targetClass
            ));
        }
    }

    /**
     * Test number with predicate.
     *
     * @param num to test
     * @param p condition
     */
    public void validNum(Integer num, Predicate <Integer>p) {
        if (!p.test(num)) {
            throw new IllegalArgumentException(String.format(
                    "Exception in class %s",
                    targetClass
            ));
        }
    }

}
