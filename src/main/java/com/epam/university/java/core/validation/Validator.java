package com.epam.university.java.core.validation;

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

    public void assertNotNull(Object value) {
        if (value == null) {
            throw new IllegalArgumentException(String.format(
                    "Exception in class %s",
                    targetClass
            ));
        }
    }

    public void assertMoreZero(Integer num) {
        if (num <= 0) {
            throw new IllegalArgumentException(String.format(
                    "Exception in class %s",
                    targetClass
            ));
        }
    }

}
