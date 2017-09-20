package com.epam.university.java.core.task018;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Task018Impl implements Task018 {

    /**
     * Check is annotation present in the following object.
     *
     * @param toCheck          object to check
     * @param annotationToFind annotation to look for
     * @return is annotation presents
     */
    @Override
    public boolean isAnnotationPresent(Object toCheck, Class annotationToFind) {

        Class classToCheck = toCheck.getClass();

        if (classToCheck.isAnnotationPresent(annotationToFind)) {
            return true;
        }

        Package classPackage = classToCheck.getPackage();

        if (classPackage.isAnnotationPresent(annotationToFind)) {
            return true;
        }

        Field[] fields = classToCheck.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(annotationToFind)) {
                return true;
            }
        }

        Constructor[] constructors = classToCheck.getDeclaredConstructors();

        for (Constructor constructor : constructors) {

            if (constructor.isAnnotationPresent(annotationToFind)) {
                return true;
            }

            Parameter[] parameters = constructor.getParameters();

            for (Parameter parameter : parameters) {
                if (parameter.isAnnotationPresent(annotationToFind)) {
                    return true;
                }
            }

        }

        Method[] methods = classToCheck.getDeclaredMethods();

        for (Method method : methods) {

            if (method.isAnnotationPresent(annotationToFind)) {
                return true;
            }

            Parameter[] parameters = method.getParameters();

            for (Parameter parameter : parameters) {
                if (parameter.isAnnotationPresent(annotationToFind)) {
                    return true;
                }
            }

        }

        return false;

    }
}
