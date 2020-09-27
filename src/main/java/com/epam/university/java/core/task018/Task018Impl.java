package com.epam.university.java.core.task018;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


/**
 * Author Dmitry Novikov 06-Sep-20.
 */
public class Task018Impl implements Task018 {
    @Override
    public boolean isAnnotationPresent(Object toCheck, Class<?> annotationToFind) {
        if (toCheck == null || annotationToFind == null) {
            throw new IllegalArgumentException();
        }

        String annotationName = annotationToFind.getSimpleName();
        Class myClass = toCheck.getClass();

        Package myPackage = myClass.getPackage();
        Annotation[] myPackageAnnotations = myPackage.getAnnotations();
        for (Annotation a : myPackageAnnotations
        ) {
            String name = a.annotationType().getSimpleName();
            if (annotationName.equals(name)) {
                return true;
            }
        }

        Annotation[] annotations = myClass.getAnnotations();
        for (Annotation a : annotations
        ) {
            String name = a.annotationType().getSimpleName();
            if (annotationName.equals(name)) {
                return true;
            }
        }

        Method[] methods = myClass.getDeclaredMethods();
        for (Method m : methods
        ) {
            Annotation[] annotationsM = m.getDeclaredAnnotations();
            for (Annotation a : annotationsM
            ) {
                String name = a.annotationType().getSimpleName();
                if (annotationName.equals(name)) {
                    return true;
                }
            }

            Annotation[][] parameterAnnotations = m.getParameterAnnotations();
            for (Annotation[] an : parameterAnnotations
            ) {
                for (Annotation ann : an
                ) {
                    String name = ann.annotationType().getSimpleName();
                    if (annotationName.equals(name)) {
                        return true;
                    }
                }
            }
        }


        Constructor[] constructors = myClass.getConstructors();
        for (Constructor c : constructors
        ) {
            Annotation[] annotationsM = c.getDeclaredAnnotations();
            for (Annotation a : annotationsM
            ) {
                String name = a.annotationType().getSimpleName();
                if (annotationName.equals(name)) {
                    return true;
                }
            }
        }

        Field[] fields = myClass.getDeclaredFields();
        for (Field f : fields
        ) {
            Annotation[] annotationsM = f.getDeclaredAnnotations();
            for (Annotation a : annotationsM
            ) {
                String name = a.annotationType().getSimpleName();
                if (annotationName.equals(name)) {
                    return true;
                }
            }
        }

        return false;
    }
}
