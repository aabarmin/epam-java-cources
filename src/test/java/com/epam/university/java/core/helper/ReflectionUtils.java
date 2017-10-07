package com.epam.university.java.core.helper;

import java.lang.reflect.Field;

/**
 * Supplementary reflection utils.
 */
public class ReflectionUtils {
    /**
     * Set object property value via reflection.
     * @param object object to set value
     * @param field field to set
     * @param value value to set
     */
    public static void setField(Object object, String field, Object value) {
        try {
            final Field declaredField = object.getClass().getDeclaredField(field);
            declaredField.setAccessible(true);
            declaredField.set(object, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
