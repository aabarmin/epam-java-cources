package com.epam.university.java.core.task018;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created by Romin Nuro on 11.09.2020 14:36.
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
        if (toCheck == null || annotationToFind == null) {
            throw new IllegalArgumentException();
        }
        Class<? extends Annotation> annotation = (Class<? extends Annotation>) annotationToFind;
        Class<?> objectClass = toCheck.getClass();
        for (Method m : objectClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(annotation)) {
                return true;
            }
            for (Parameter p : m.getParameters()) {
                if (p.isAnnotationPresent(annotation)) {
                    return true;
                }
            }
        }
        if (objectClass.isAnnotationPresent(annotation)) {
            return true;
        }
        for (Field f : objectClass.getDeclaredFields()) {
            if (f.isAnnotationPresent(annotation)) {
                return true;
            }
        }
        for (Constructor c : objectClass.getDeclaredConstructors()) {
            if (c.isAnnotationPresent(annotation)) {
                return true;
            }
        }
        if (objectClass.getPackage().isAnnotationPresent(annotation)) {
            return true;
        }

        return false;
    }
}
