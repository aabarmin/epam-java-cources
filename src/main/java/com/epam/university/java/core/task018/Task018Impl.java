package com.epam.university.java.core.task018;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Daniil Smirnov on 21.09.2017.
 * All copy registered MF.
 */
public class Task018Impl implements Task018 {

    @Override
    public boolean isAnnotationPresent(Object toCheck, Class<?> annotationToFind) {

        Class<?> clazz = toCheck.getClass();

        List<Annotation> annotationList = new ArrayList<>();

        Field[] fields = clazz.getDeclaredFields();
        Method[] onMethod = clazz.getDeclaredMethods();
        Constructor<?>[] constructors = clazz.getConstructors();

        for (Constructor c : constructors) {
            annotationList.addAll(Arrays.asList(c.getDeclaredAnnotations()));
        }
        for (Field f : fields) {
            annotationList.addAll(Arrays.asList(f.getDeclaredAnnotations()));
        }
        for (Method m : onMethod) {
            annotationList.addAll(Arrays.asList(m.getDeclaredAnnotations()));
            Annotation[][] parameterAnnotations = m.getParameterAnnotations();
            for (int i = 0; i < parameterAnnotations.length; i++) {
                for (int j = 0; j < parameterAnnotations.length; j++) {
                    annotationList.add(parameterAnnotations[i][j]);
                }
            }
        }

        annotationList.addAll(Arrays.asList(clazz.getPackage().getDeclaredAnnotations()));

        annotationList.addAll(Arrays.asList(clazz.getDeclaredAnnotations()));

        for (Annotation a : annotationList) {
            if (a.annotationType().equals(annotationToFind)) {
                return true;
            }
        }

        return false;
    }
}
