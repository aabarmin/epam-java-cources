package com.epam.university.java.core.task018;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * {@inheritDoc}
 */
public class Task018Impl implements Task018 {

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAnnotationPresent(Object toCheck, Class<?> annotationToFind) {
        Class<?> classToCheck = toCheck.getClass();
        if (classToCheck.isAnnotationPresent((Class<? extends Annotation>) annotationToFind)) {
            return true;
        }

        Package classToCheckPackage = classToCheck.getPackage();
        if (classToCheckPackage.isAnnotationPresent(
                (Class<? extends Annotation>) annotationToFind)) {
            return true;
        }

        Constructor[] constructors = classToCheck.getConstructors();
        for (Constructor c : constructors) {
            if (c.isAnnotationPresent((Class<? extends Annotation>) annotationToFind)) {
                return true;
            }
        }

        Field[] fields = classToCheck.getDeclaredFields();
        for (Field f : fields) {
            if (f.isAnnotationPresent((Class<? extends Annotation>) annotationToFind)) {
                return true;
            }
        }

        Method[] methods = classToCheck.getDeclaredMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent((Class<? extends Annotation>) annotationToFind)) {
                return true;
            }
            Parameter[] parameters = m.getParameters();
            for (Parameter p : m.getParameters()) {
                if (p.isAnnotationPresent((Class<? extends Annotation>) annotationToFind)) {
                    return true;
                }
            }
        }
        return false;
    }


}
