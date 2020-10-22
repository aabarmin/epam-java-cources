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

        Annotation[] annotations2 = toCheck.getClass().getPackage().getAnnotations();
        for (Annotation annotation : annotations2) {
            if (annotation.annotationType().equals(annotationToFind)) {
                return true;
            }
        }

        Annotation[] annotations1 = toCheck.getClass().getAnnotations();
        for (Annotation annotation : annotations1) {
            if (annotation.annotationType().equals(annotationToFind)) {
                return true;
            }

        }


        Constructor<?>[] constructors = toCheck.getClass().getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            Annotation[] annotations = constructor.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType().equals(annotationToFind)) {
                    return true;
                }
            }
        }

        Field[] fields = toCheck.getClass().getDeclaredFields();
        for (Field field : fields) {
            Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
            for (Annotation annotation : declaredAnnotations) {
                if (annotation.annotationType().equals(annotationToFind)) {
                    return true;
                }
            }
        }

        Method[] methods = toCheck.getClass().getMethods();
        for (Method method : methods) {
            Annotation[] declaredAnnotations = method.getDeclaredAnnotations();

            final Annotation[][] paramAnnotations = method.getParameterAnnotations();
            for (int i = 0; i < paramAnnotations.length; i++) {
                for (Annotation a : paramAnnotations[i]) {
                    if (a.annotationType().equals(annotationToFind)) {
                        return true;
                    }
                }
            }

            for (Annotation annotation : declaredAnnotations) {
                if (annotation.annotationType().equals(annotationToFind)) {
                    return true;
                }
            }
        }

        return false;
    }
}
