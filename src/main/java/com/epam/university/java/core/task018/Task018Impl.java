package com.epam.university.java.core.task018;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Task018Impl implements Task018 {
    @Override
    public boolean isAnnotationPresent(Object toCheck, Class<?> annotationToFind) {
        Class clazz = toCheck.getClass();
        Annotation[][] annotations;
        if (clazz.isAnnotationPresent(annotationToFind)) {
            return true;
        }
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent((Class<? extends Annotation>) annotationToFind)) {
                return true;
            }
            annotations = m.getParameterAnnotations();
            for (Annotation[] annotations1 : annotations) {
                for (Annotation annotation : annotations1) {
                    if (annotation.annotationType().equals(annotationToFind)) {
                        return true;
                    }
                }
            }
        }

        Constructor[] constructors = clazz.getConstructors();
        for (Constructor m : constructors) {
            if (m.isAnnotationPresent((Class<? extends Annotation>) annotationToFind)) {
                return true;
            }
        }

        Field[] fields = clazz.getDeclaredFields();
        for (Field m : fields) {
            if (m.isAnnotationPresent((Class<? extends Annotation>) annotationToFind)) {
                return true;
            }
        }

        return clazz.getPackage()
                .isAnnotationPresent((Class<? extends Annotation>) annotationToFind);
    }
}
