package com.epam.university.java.core.task018;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Task018Impl implements Task018 {

    @Override
    public boolean isAnnotationPresent(Object toCheck, Class<?> annotationToFind) {

        if (toCheck == null || annotationToFind == null) {
            throw new IllegalArgumentException();
        }

        Class<? extends Object> clazz = toCheck.getClass();

        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            if (f.isAnnotationPresent(annotationToFind.asSubclass(Annotation.class))) {
                return true;
            }
        }

        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(annotationToFind.asSubclass(Annotation.class))) {
                return true;
            }
            Parameter[] parameters = m.getParameters();
            for (Parameter p : parameters) {
                if (p.isAnnotationPresent(annotationToFind.asSubclass(Annotation.class))) {
                    return true;
                }
            }
        }

        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> c : constructors) {
            if (c.isAnnotationPresent(annotationToFind.asSubclass(Annotation.class))) {
                return true;
            }
        }

        Package pack = clazz.getPackage();
        return pack.isAnnotationPresent(annotationToFind.asSubclass(Annotation.class))
                || clazz.isAnnotationPresent(annotationToFind.asSubclass(Annotation.class));
    }
}

