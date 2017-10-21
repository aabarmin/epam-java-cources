package com.epam.university.java.core.task018;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Task018Impl implements Task018 {
    @Override
    public boolean isAnnotationPresent(Object toCheck, Class<?> annotationToFind) {
        if (toCheck.getClass().isAnnotationPresent(BasicAnnotation.class)) {
            return true;
        }
        for (Constructor<?> c: toCheck.getClass().getConstructors()) {
            if (c.isAnnotationPresent(BasicAnnotation.class)) {
                return true;
            }
        }
        for (Method m: toCheck.getClass().getMethods()) {
            if (m.isAnnotationPresent(BasicAnnotation.class)) {
                return true;
            }
            for (Parameter p: m.getParameters()) {
                if (p.isAnnotationPresent(BasicAnnotation.class)) {
                    return true;
                }
            }
        }
        for (Field f: toCheck.getClass().getDeclaredFields()) {
            if (f.isAnnotationPresent(BasicAnnotation.class)) {
                return true;
            }
        }

        return false;
    }

}
