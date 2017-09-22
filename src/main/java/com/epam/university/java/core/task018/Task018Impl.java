package com.epam.university.java.core.task018;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Task018Impl implements Task018 {
    @Override
    public boolean isAnnotationPresent(Object toCheck, Class<?> annotationToFind) {
        // list of found annotations
        List<Annotation> annotations = new ArrayList<>();

        // object's class
        Class<?> objClass = toCheck.getClass();

        // constructors, methods and fields
        Constructor<?>[] declaredConstructors = objClass.getDeclaredConstructors();
        Method[] declaredMethods = objClass.getDeclaredMethods();
        Field[] declaredFields = objClass.getDeclaredFields();

        // add constructor's annotations
        Stream.of(declaredConstructors)
                .forEach(c -> annotations.addAll(
                        Arrays.asList(c.getDeclaredAnnotations())
                ));

        // add method's and parameter's annotations
        Stream.of(declaredMethods)
                .forEach(m -> {
                    annotations.addAll(Arrays.asList(m.getDeclaredAnnotations()));
                    Stream.of(m.getParameterAnnotations())
                            .forEach(p -> annotations.addAll(
                                    Arrays.asList(p)
                            ));
                });

        // add field's annotations
        Stream.of(declaredFields)
                .forEach(f -> annotations.addAll(
                        Arrays.asList(f.getDeclaredAnnotations())
                ));

        // add package annotations
        annotations.addAll(Arrays.asList(objClass.getPackage().getDeclaredAnnotations()));
        // add class annotations
        annotations.addAll(Arrays.asList(objClass.getDeclaredAnnotations()));

        // check if annotationToFind exists in found annotations
        for (Annotation annotation : annotations) {
            if (annotation.annotationType().equals(annotationToFind)) {
                return true;
            }
        }

        return false;
    }
}
