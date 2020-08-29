package com.epam.university.java.core.task018;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Task018Impl implements Task018 {
    @Override
    public boolean isAnnotationPresent(Object toCheck, Class<?> annotationToFind) {
        Class clazz = toCheck.getClass();

        for (Annotation an : clazz.getDeclaredAnnotations()) {
            if (an.annotationType().equals(annotationToFind)) {
                return true;
            }
        }

        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            Annotation[] methodAnn = m.getDeclaredAnnotations();
            for (Annotation an : methodAnn) {
                if (an.annotationType().equals(annotationToFind)) {
                    return true;
                }
            }

            Annotation[][] annotations = m.getParameterAnnotations();
            for (Annotation[] an : annotations) {
                for (Annotation annotation : an) {
                    if (annotation.annotationType().equals(annotationToFind)) {
                        return true;
                    }
                }
            }
        }

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            for (Annotation an : field.getDeclaredAnnotations()) {
                if (an.annotationType().equals(annotationToFind)) {
                    return true;
                }
            }
        }

        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            for (Annotation an : constructor.getDeclaredAnnotations()) {
                if (an.annotationType().equals(annotationToFind)) {
                    return true;
                }
            }
        }

        Package pakage = clazz.getPackage();
        for (Annotation an : pakage.getDeclaredAnnotations()) {
            if (an.annotationType().equals(annotationToFind)) {
                return true;
            }
        }

        return false;
    }
}
