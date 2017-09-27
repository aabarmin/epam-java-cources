package com.epam.university.java.core.task018;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created by Александр on 27.09.2017.
 * Annotation check
 */
public class Task018Impl implements Task018 {
    /**
     * Check is annotation present in the following object.
     *
     * @param toCheck          object to check
     * @param annotationToFind annotation to look for
     * @return is annotation presents
     */
    @Override
    public boolean isAnnotationPresent(Object toCheck, Class<?> annotationToFind) {
        boolean result = false;

        if  (toCheck.getClass().getAnnotation(BasicAnnotation.class) != null) {
            return true;
        }
        for (Constructor<?> s : toCheck.getClass().getConstructors()) {
            if (s.isAnnotationPresent(BasicAnnotation.class)) {
                return true;
            }
        }
        for (Method m : toCheck.getClass().getMethods()) {
            if (m.isAnnotationPresent(BasicAnnotation.class)) {
                return true;
            }
            for (Parameter p : m.getParameters()) {
                if (p.isAnnotationPresent(BasicAnnotation.class)) {
                    return true;
                }
            }
        }
        for (Field f : toCheck.getClass().getDeclaredFields()) {
            if (f.isAnnotationPresent(BasicAnnotation.class)) {
                return true;
            }
        }
        if (toCheck.getClass().getPackage().isAnnotationPresent(BasicAnnotation.class)) {
            return true;
        }
        return false;
    }

}
