package com.epam.university.java.core.task018;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Task018Impl implements Task018 {
    @Override
    public boolean isAnnotationPresent(Object toCheck, Class<?> annotationToFind) {
        if (toCheck == null || annotationToFind == null) {
            throw new IllegalArgumentException();
        }
        Class clazz = toCheck.getClass();
        if (clazz.isAnnotationPresent(annotationToFind)) {
            return true;
        }
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> con : constructors) {
            for (Annotation an : con.getDeclaredAnnotations()) {
                if (an.annotationType().equals(annotationToFind)) {
                    return true;
                }
            }
        }
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            for (Annotation an : method.getDeclaredAnnotations()) {
                if (an.annotationType().equals(annotationToFind)) {
                    return true;
                }
            }
            Annotation[][] annotations = method.getParameterAnnotations();
            for (Annotation[] an : annotations) {
                for (Annotation annotation : an) {
                    if (annotation.annotationType().equals(annotationToFind)) {
                        return true;
                    }
                }
            }
        }
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            for (Annotation an : f.getDeclaredAnnotations()) {
                if (an.annotationType().equals(annotationToFind)) {
                    return true;
                }
            }
        }
        Package pack = clazz.getPackage();
        for (Annotation an : pack.getAnnotations()) {
            if (an.annotationType().equals(annotationToFind)) {
                return true;
            }
        }
        return false;
    }
}
