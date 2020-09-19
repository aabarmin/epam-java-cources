package com.epam.university.java.core.task018;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

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
        Class clazz = toCheck.getClass();

        // Checking for the class
        Annotation[] declaredAnnotations = clazz.getAnnotations();
        for (int i = 0; i < declaredAnnotations.length; i++) {
            if (declaredAnnotations[i].annotationType().equals(annotationToFind)) {
                return true;
            }
        }

        // Checking for methods in the class
        Method[] method = clazz.getDeclaredMethods();
        for (int i = 0; i < method.length; i++) {
            Annotation[] arrOfAnnotations = method[i].getDeclaredAnnotations();
            for (Annotation ann :
                    arrOfAnnotations) {
                if (ann.annotationType().equals(annotationToFind)) {
                    return true;
                }
            }
            // Checking for params in methods
            Annotation[][] parameterAnnotations = method[i].getParameterAnnotations();
            for (Annotation[] annotations :
                    parameterAnnotations) {
                for (Annotation annotation :
                        annotations) {
                    if (annotation.annotationType().equals(annotationToFind)) {
                        return true;
                    }
                }
            }
        }

        // Checking for the Class Package
        Annotation[] arrForThePackageAnnotations = clazz.getPackage().getDeclaredAnnotations();
        for (Annotation ann :
                arrForThePackageAnnotations) {
            if (ann.annotationType().equals(annotationToFind)) {
                return true;
            }
        }

        // Checking for fields in the Class
        Field[] clazzFields = clazz.getDeclaredFields();
        for (Field field :
                clazzFields) {
            Annotation[] fieldDeclaredAnnotations = field.getDeclaredAnnotations();
            for (Annotation ann :
                    fieldDeclaredAnnotations) {
                if (ann.annotationType().equals(annotationToFind)) {
                    return true;
                }
            }
        }

        // Checking for the Class Constructor.

        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor constructor :
                declaredConstructors) {
            Annotation[] constructorDeclaredAnnotations = constructor.getDeclaredAnnotations();
            for (Annotation ann :
                    constructorDeclaredAnnotations) {
                if (ann.annotationType().equals(annotationToFind)) {
                    return true;
                }
            }
        }

        return false;
    }
}
